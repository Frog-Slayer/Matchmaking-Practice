package battleserver;

import server.ClientThread;
import server.ServiceDelegator;

import java.net.Socket;

public class BattleClientThread extends ClientThread {
    public BattleClientThread(Socket socket) {
        super(socket);
    }

    public BattleClientThread(Socket socket, ServiceDelegator delegator) {
        super(socket, delegator);
    }
}
