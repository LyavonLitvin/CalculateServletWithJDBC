package by.tms.dao.inmemory;

import by.tms.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class InMemoryUsersStorage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
        logger.info("add user");
        users.add(user);
    }

    public User getOneByUserName(String username) {
        logger.info("return one by username");
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkOneByUserName(String username) {
        logger.info("check one by username");
        for (User user : users) {
            if (user.getLogin().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> getAll() {
        logger.info("Return all users");
        return users;
    }

    public void deleteAll() {
        users.clear();
        logger.info("Delete all users");
    }
}
