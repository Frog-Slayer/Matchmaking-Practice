package lobbyserver;

import utils.Message;

public class LobbyServiceImpl implements LobbyService{

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
        return "[Match]";
    }

}
