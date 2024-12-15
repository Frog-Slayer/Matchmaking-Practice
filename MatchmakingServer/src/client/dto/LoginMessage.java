package client.dto;

import utils.Message;

public class LoginMessage extends  ClientMessage{

    public LoginMessage(String username, String password) {
        put("type", "login");
        put("username", username);
        put("password", password);
    }
}
