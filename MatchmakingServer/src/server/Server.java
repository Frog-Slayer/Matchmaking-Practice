package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;
    private final ServiceDelegator delegator;
    private final Class<? extends ClientThread> threadClass;

    public Server(int port) {
        this.port = port;
        this.delegator = DefaultServiceDelegator.getInstance();
        this.threadClass = ClientThread.class;
    }

    public Server(int port, ServiceDelegator delegator) {
        this.port = port;
        this.delegator = delegator;
        this.threadClass = ClientThread.class;
    }

    public Server(int port, ServiceDelegator delegator, Class<? extends ClientThread> threadClass) {
        this.port = port;
        this.delegator = delegator;
        this.threadClass = threadClass;
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
