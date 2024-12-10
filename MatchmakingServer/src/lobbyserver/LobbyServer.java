package lobbyserver;

import server.ClientThread;
import server.ServiceDelegator;

import java.net.Socket;

public class LobbyServer extends ClientThread {

    public LobbyServer(Socket socket) {
        super(socket);
    }

    public LobbyServer(Socket socket, ServiceDelegator delegator) {
        super(socket, delegator);
    }
}
