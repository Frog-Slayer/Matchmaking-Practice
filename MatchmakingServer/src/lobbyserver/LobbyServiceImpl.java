package lobbyserver;

import server.ClientThread;
import utils.Message;
import utils.SimpleUserDB;
import utils.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LobbyServiceImpl implements LobbyService{

    private Map<String, ClientThread> loginUsers = new ConcurrentHashMap<>();
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
        return "[Login]";
    }

    @Override
    public String match(String token) {
        for (User user : loginUsers.values()) {


        }


        return "[Match]";
    }

}
