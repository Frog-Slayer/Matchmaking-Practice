package lobbyserver;

import server.ClientThread;
import server.ServiceDelegator;
import utils.User;

import java.net.Socket;

public class LobbyClientThread extends ClientThread {
    public LobbyClientThread(Socket socket) {
        super(socket);
    }

    public LobbyClientThread(Socket socket, ServiceDelegator delegator) {
        super(socket, delegator);
    }
}
