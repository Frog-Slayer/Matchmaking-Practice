package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private ServiceDelegator delegator;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.delegator = new TestServiceDelegator();
    }

    @Override
    public void run() {
        try {
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = reader.readLine();
                String output = delegator.process(input);

                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.println(output);
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
