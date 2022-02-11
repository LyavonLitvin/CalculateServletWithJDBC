package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InMemoryUsersStorage;

import java.util.ArrayList;

public class InMemoryUsersStorageService {
    InMemoryUsersStorage inMemoryUsersStorage = InMemoryUsersStorage.getInstance();

    public boolean addUser(User user) {
        if (!inMemoryUsersStorage.checkOneByUserName(user.getLogin())) {
            inMemoryUsersStorage.addUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkByUserLogin(String userLogin) {
        return inMemoryUsersStorage.checkOneByUserName(userLogin);
    }

    public boolean checkUserByUsernamePassword(String username, String password) {
        User user = inMemoryUsersStorage.getOneByUserName(username);
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return inMemoryUsersStorage.getAll();
    }

    public void deleteUsers() {
        inMemoryUsersStorage.deleteAll();
    }
}
