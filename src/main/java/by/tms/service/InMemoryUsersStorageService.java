package by.tms.service;

import by.tms.entity.User;
import by.tms.repository.InMemoryUsersStorage;

import java.util.ArrayList;

public class InMemoryUsersStorageService {
    InMemoryUsersStorage inMemoryUsersStorage = InMemoryUsersStorage.getInstance();

    public boolean saveUser(User user) {
        if (!inMemoryUsersStorage.checkByUserName(user.getLogin())) {
            inMemoryUsersStorage.saveUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUser(String username) {
        return inMemoryUsersStorage.checkByUserName(username);
    }

    public boolean checkUserByUsernamePassword(String username, String password) {
        User user = inMemoryUsersStorage.getByUserName(username);
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return inMemoryUsersStorage.getUsers();
    }

    public void deleteUsers() {
        inMemoryUsersStorage.deleteUsers();
    }
}
