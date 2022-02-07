package by.tms.service;

import by.tms.repository.UserRoleRepository;

import java.util.HashMap;


public class UserRoleService {

    private UserRoleRepository userRoleRepository = new UserRoleRepository();

    // получение id роли пользователя
    public int getIdUserRole(String login) {
        return userRoleRepository.getUserRoleByUserLogin(login);
    }

    // получение id роли ползователя по id пользователя
    public int getIdUserRoleByIdUser(int idUser) {
        return userRoleRepository.getUserRoleIdByUserId(idUser);
    }

    // получение роли пользователя
    public String getUserRole(int userRoleId) {
        return userRoleRepository.getRoleNameFromUserRoleId(userRoleId);
    }

    // получение списка роли пользователей
    public void printUserRole() {
        HashMap<Integer, String> listUserRole = userRoleRepository.getHashMapUserRoles();
        listUserRole.forEach((k, v) -> {
            System.out.println("ID - " + k + ", Название роли - " + v);
        });
    }

    // проверка на соответсвие роли пользователя
    public boolean isValid(int inputUserRoleId) {
        UserRoleRepository userRoleRepository = new UserRoleRepository();
        int idFromBD = userRoleRepository.getUserRoleByUserRoleId(inputUserRoleId);
        if (idFromBD == -1) {
            return false;
        } else {
            return true;
        }
    }
}

