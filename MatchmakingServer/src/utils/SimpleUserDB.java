package utils;

import java.util.ArrayList;
import java.util.List;

public class SimpleUserDB {
    private static SimpleUserDB instance = new SimpleUserDB();
    private List<User> users;

    private SimpleUserDB() {
        users = new ArrayList<>();
    }

    public static SimpleUserDB getInstance() {
        return instance;
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }



}
