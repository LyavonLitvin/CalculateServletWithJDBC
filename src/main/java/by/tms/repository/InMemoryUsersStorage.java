package by.tms.repository;

import by.tms.entity.User;

import java.util.ArrayList;

public class InMemoryUsersStorage {

    private static InMemoryUsersStorage instance;

    private InMemoryUsersStorage() {
    }

    private final static ArrayList<User> users = new ArrayList<>();

    public static InMemoryUsersStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryUsersStorage();
        }
        return instance;
    }


    public void saveUser(User user) {
        users.add(user);
    }

    public User getByUserName(String username) {
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkByUserName(String username) {
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void deleteUsers() {
        users.clear();
    }
}
