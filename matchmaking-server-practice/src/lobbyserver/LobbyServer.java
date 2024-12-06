package lobbyserver;

import utils.server.Server;

public interface LobbyServer extends Server {
    void login(String username, String password);
    void match(String token);
    void requestBattleSession();
}
