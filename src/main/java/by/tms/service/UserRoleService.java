package by.tms.service;

import by.tms.dao.jdbc.InMySQLUserRoleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;


public class UserRoleService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private InMySQLUserRoleDAO inMySQLUserRoleDAO = new InMySQLUserRoleDAO();

    // получение id роли пользователя
    public int getIdUserRole(String login) {
        return inMySQLUserRoleDAO.getUserRoleByUserLogin(login);
    }

    // получение id роли ползователя по id пользователя
    public int getIdUserRoleByIdUser(int idUser) {
        return inMySQLUserRoleDAO.getUserRoleIdByUserId(idUser);
    }

    // получение роли пользователя
    public String getUserRole(int userRoleId) {
        return inMySQLUserRoleDAO.getRoleNameFromUserRoleId(userRoleId);
    }

    // получение списка роли пользователей
    public void printUserRole() {
        HashMap<Integer, String> listUserRole = inMySQLUserRoleDAO.getHashMapUserRoles();
        listUserRole.forEach((k, v) -> {
            System.out.println("ID - " + k + ", Название роли - " + v);
        });
    }

    // проверка на соответсвие роли пользователя
    public boolean isValid(int inputUserRoleId) {
        InMySQLUserRoleDAO inMySQLUserRoleDAO = new InMySQLUserRoleDAO();
        int idFromBD = inMySQLUserRoleDAO.getUserRoleByUserRoleId(inputUserRoleId);
        if (idFromBD == -1) {
            return false;
        } else {
            return true;
        }
    }
}

