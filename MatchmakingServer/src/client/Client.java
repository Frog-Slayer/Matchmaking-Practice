package client;

import client.dto.LoginMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static String serverHost = "localhost";
    public static Integer serverPort = 12000;
    private String token;

    public void run() {
        try (Socket socket = new Socket(InetAddress.getByName(serverHost), serverPort);
             BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while (true) {
                String input = inputReader.readLine();
                if (input.equals("login")) login(inputReader, socketWriter, socketReader);
                else if (input.equals("match")) match(inputReader, socketWriter, socketReader);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void login(BufferedReader br, PrintWriter sockWriter, BufferedReader sockReader) {
        try {
                String[] input = br.readLine().split(" ");
                String username = input[0];
                String password = input[1];

                sockWriter.println(new LoginMessage(username, password));
                sockWriter.flush();

                token = sockReader.readLine();
                System.out.println("[Login Success]" + token);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void match(BufferedReader br, PrintWriter sockWriter, BufferedReader sockReader) {
        try {
            if (token != null) {
                sockWriter.println("type match token " + token);
                sockWriter.flush();
                System.out.println("[match]" + sockReader.readLine());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Client().run();
    }
}