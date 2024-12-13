package lobbyserver;

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

    private final Map<String, LobbyClientThread> clientThreads = new ConcurrentHashMap<>();
    private final Map<String, User>  loginUsers= new ConcurrentHashMap<>();
    private final SimpleUserDB userDB = SimpleUserDB.getInstance();

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
            loginUsers.put(token, user);
            return token;
        }

        return "FAIL";
    }

    @Override
    public String match(String token) {
        User currentUser = loginUsers.get(token);
        currentUser.setMatching(true);

        List<User> matched = new ArrayList<>();

        for (User user: loginUsers.values()) {
            if (user.isMatching() && isSimilar(currentUser.getElo(), user.getElo())) matched.add(user);

            if (matched.size() == MATCH_NEEDED) {
                return "MATCH_COMPLETE";
            }
        }

        return "NOW MATCHING";
    }

    private boolean isSimilar(int elo1, int elo2) {
        return Math.abs(elo1 - elo2) < 50;
    }

}
