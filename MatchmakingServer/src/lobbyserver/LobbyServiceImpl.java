package lobbyserver;

import server.ClientThread;
import utils.Message;
import utils.SimpleUserDB;
import utils.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LobbyServiceImpl implements LobbyService{

    private static final int MATCH_NEEDED = 5;

    private Map<String, LobbyClientThread> loginUsers = new ConcurrentHashMap<>();
    private SimpleUserDB userDB = SimpleUserDB.getInstance();

    @Override
    public String process(String message) {
        Message m = new Message(message);

        if (m.get("type").equals("login")) {
            String username = m.get("username");
            String password = m.get("password");
            return login(username, password);
        }
        else if (m.get("type").equals("match")) {
            return match(m.get("token"));
        }

        return "";
    }

    @Override
    public String login(String username, String password) {
        User user = userDB.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            String token = UUID.randomUUID().toString();
            if (Thread.currentThread() instanceof LobbyClientThread thread) {
                thread.setUser(user);
                loginUsers.put(token, thread);
            }
            return token;
        }

        return "FAIL";
    }

    @Override
    public String match(String token) {
        User currentUser = loginUsers.get(token).getUser();
        currentUser.setMatching(true);

        for (LobbyClientThread thread: loginUsers.values()) {
            List<LobbyClientThread> matched = new ArrayList<>();

            if (isSimilar(currentUser.getElo(), thread.getUser().getElo())) {
                matched.add(thread);
            }

            if (matched.size() == MATCH_NEEDED) {
                return "MATCH_COMPLETE";
            }
        }

        return "MATCH_FAILED";
    }

    private boolean isSimilar(int elo1, int elo2) {
        return Math.abs(elo1 - elo2) < 50;
    }

}
