package utils;

public class User {
    private String username;
    private String password;

    private int elo;
    private boolean isLogin;
    private boolean isMatching;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        isLogin = false;
        isMatching = false;
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

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void setMatching(boolean matching) {
        isMatching = matching;
    }

}
