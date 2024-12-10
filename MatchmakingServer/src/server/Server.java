package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;
    private final ServiceDelegator delegator;

    public Server(int port) {
        this.port = port;
        this.delegator = DefaultServiceDelegator.getInstance();
    }

    public Server(int port, ServiceDelegator delegator) {
        this.port = port;
        this.delegator = delegator;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port) ){
            while (true) {
                Socket connectionSocket = serverSocket.accept();
                ClientThread thread= new ClientThread(connectionSocket, delegator);
                thread.start();
           }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server(12000).run();
    }
}
