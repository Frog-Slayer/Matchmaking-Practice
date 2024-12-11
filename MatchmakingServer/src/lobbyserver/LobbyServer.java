package lobbyserver;

import server.Server;

public class LobbyServer extends Server {

    public LobbyServer(int port) {
        super(port, new LobbyServiceImpl(), LobbyClientThread.class);
    }

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        new LobbyServer(12000).run();
    }

}
