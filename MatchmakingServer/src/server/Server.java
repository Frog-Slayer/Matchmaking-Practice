package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(12000) ){
            while (true) {
                Socket connectionSocket = serverSocket.accept();
                ClientThread thread= new ClientThread(connectionSocket);
                thread.start();
           }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().run();
    }

}
