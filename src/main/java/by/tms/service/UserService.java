package by.tms.service;

import by.tms.entity.User;
import by.tms.dao.jdbc.InMySQLUserDAO;

public class UserService {
    private InMySQLUserDAO inMySQLUserDAO = InMySQLUserDAO.getInstance();
    private User user;

    // добавление пользователя в базу данных
    public boolean addUser(User user) {
        int userResultAddFromBD = inMySQLUserDAO.addUser(user);
        if (userResultAddFromBD != -1) {
            user.setIdUser(userResultAddFromBD);
            return true;
        }
        return false;
    }
//
//    // обновление пользователя в базу данных
//    public boolean updateUser(int userId, int userRoleID, String userName,String userLogin, String userPassword,
//                               String userEmail, String userSecretQuestion) {
//        user = new User(userId, userRoleID, userName, userLogin, userPassword, userEmail, userSecretQuestion, Timestamp.valueOf(LocalDateTime.now()));
//        int userResultUpdateFromBD = inMySQLUserRepository.updateUser(user);
//        if (userResultUpdateFromBD != -1) {
//            user.setIdUser(userResultUpdateFromBD);
//            return true;
//        }
//        return false;
//    }
//
//    // удаление пользователя
//    public boolean deleteUser(int idUser) {
//        return inMySQLUserRepository.deleteUser(idUser);
//    }
//
//    // создание авторизованного пользователя
//    public void createAuthorizedUser(int idUser) {
//        user = inMySQLUserRepository.getAuthorizedUserInfo(idUser);
//        user.setIdUser(idUser);
//    }
//
//    // получение id авторизованного пользователя
//    public int getAuthorizedUserId() {
//        return user.getIdUser();
//    }
//
//    // получение роли авторизованного пользователя
//    public int getAuthorizedUserRole() {
//        return user.getUserRoleId();
//    }
//
    // получения id пользователя по логину
    public int getUserId(String login) {
        return inMySQLUserDAO.getUserId(login);
    }

    // проверка логина пользователя
    public boolean checkByUserLogin(String userLogin) {
        if (inMySQLUserDAO.getUserId(userLogin) != -1) {
            return true;
        } else {
            return false;
        }
    }

    // проверка обновления пароля пользователя
//    public boolean checkUpdateUserPassword(int idUser, String newPassword) {
//        if (inMySQLUserRepository.updateUserPassword(idUser, newPassword) != -1) {
//            return true;
//        } else {
//            return false;
//        }
//    }

//    // получение информации по пользователю
//    public String getUserInfo(int userId) {
//        return inMySQLUserRepository.getUserInfo(userId);
//    }

//    // получение списка пользователей
//    public void printUsersInfo() {
//        ArrayList<String> listUsersInfo = inMySQLUserRepository.getUsersInfo();
//        System.out.println("\nСписок всех пользователей:");
//        listUsersInfo.forEach(System.out::println);
//    }

    // проверка изменения роли пользователя
//    public boolean checkUpdateUserRole(String userLogin, int newRoleId) {
//        boolean result = inMySQLUserRepository.updateUserRole(userLogin, newRoleId);
//        return result;
//    }

    // проверка пароля в БД
    public boolean checkUserByUsernamePassword(String inputUserLogin, String inputUserPassword) {
        if (inMySQLUserDAO.checkUserPassword(inputUserLogin, inputUserPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
