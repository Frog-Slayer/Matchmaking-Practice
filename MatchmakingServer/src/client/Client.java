package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static String serverHost = "localhost";
    public static Integer serverPort = 12000;

    public void run() {
        try (Socket socket = new Socket(InetAddress.getByName(serverHost), serverPort); BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String input = br.readLine();

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println(input);
                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String output = reader.readLine();

                System.out.println(output);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        new Client().run();
    }
}