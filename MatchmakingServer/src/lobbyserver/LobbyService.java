package lobbyserver;

import server.ServiceDelegator;

public interface LobbyService extends ServiceDelegator {
    String login(String username, String password);
    String match(String token);
}
