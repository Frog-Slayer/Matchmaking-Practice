package utils.db.entity;

public class User {
    private String username;
    private String password;

    private double elo;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getElo() {
        return elo;
    }
}
