package utils;

public class User {
    private String username;
    private String password;

    private int elo;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        elo = 1000;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getElo() {
        return elo;
    }



}
