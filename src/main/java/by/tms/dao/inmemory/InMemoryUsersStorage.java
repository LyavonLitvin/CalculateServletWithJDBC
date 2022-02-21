package by.tms.dao.inmemory;

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


    public void addUser(User user) {
        users.add(user);
    }

    public User getOneByUserName(String username) {
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkOneByUserName(String username) {
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAll() {
        return users;
    }

    public void deleteAll() {
        users.clear();
    }
}
