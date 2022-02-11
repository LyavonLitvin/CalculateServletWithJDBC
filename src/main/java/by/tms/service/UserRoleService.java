package by.tms.service;

import by.tms.storage.InMySQLUserRoleRepository;

import java.util.HashMap;


public class UserRoleService {

    private InMySQLUserRoleRepository inMySQLUserRoleRepository = new InMySQLUserRoleRepository();

    // получение id роли пользователя
    public int getIdUserRole(String login) {
        return inMySQLUserRoleRepository.getUserRoleByUserLogin(login);
    }

    // получение id роли ползователя по id пользователя
    public int getIdUserRoleByIdUser(int idUser) {
        return inMySQLUserRoleRepository.getUserRoleIdByUserId(idUser);
    }

    // получение роли пользователя
    public String getUserRole(int userRoleId) {
        return inMySQLUserRoleRepository.getRoleNameFromUserRoleId(userRoleId);
    }

    // получение списка роли пользователей
    public void printUserRole() {
        HashMap<Integer, String> listUserRole = inMySQLUserRoleRepository.getHashMapUserRoles();
        listUserRole.forEach((k, v) -> {
            System.out.println("ID - " + k + ", Название роли - " + v);
        });
    }

    // проверка на соответсвие роли пользователя
    public boolean isValid(int inputUserRoleId) {
        InMySQLUserRoleRepository inMySQLUserRoleRepository = new InMySQLUserRoleRepository();
        int idFromBD = inMySQLUserRoleRepository.getUserRoleByUserRoleId(inputUserRoleId);
        if (idFromBD == -1) {
            return false;
        } else {
            return true;
        }
    }
}

