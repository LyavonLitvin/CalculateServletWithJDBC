package by.tms.dao.jdbc;



import by.tms.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class InMySQLUserDAO {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static InMySQLUserDAO instance;

    private InMySQLUserDAO() {
    }

    public static InMySQLUserDAO getInstance() {
        if (instance == null) {
            instance = new InMySQLUserDAO();
        }
        return instance;
    }

    final String url = "jdbc:mysql://localhost:3306/calculatordb?useUnicode=true&serverTimezone=UTC";
    final String username = "root";
    final String password = "admin";


    // запрос в базу данных на добавление пользователя
    public int addUser(User user) {
        logger.info("add users");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into users (user_role_id, user_name, user_login, user_password, user_email," +
                        " user_secret_question, user_date_update) values (?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, user.getUserRoleId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getLogin());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getEmail());
                preparedStatement.setString(6, user.getSecretQuestion());
                preparedStatement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int userID = getUserId(user);
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    // запрос в базу данных на обновление пользователя
    public int updateUser(User user) {
        logger.info("update users");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update users set user_role_id = ?, user_name = ?, user_password = ?, user_email = ?," +
                        " user_secret_question = ?, user_date_update =? where user_id = ?;");
                preparedStatement.setInt(1, user.getUserRoleId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getEmail());
                preparedStatement.setString(6, user.getSecretQuestion());
                preparedStatement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
                preparedStatement.setString(3, user.getLogin());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int userID = getUserId(user);
        if (userID != -1) {
            return userID;
        } else {
            return -1;
        }
    }

    // запрос в базу данных на обновление пароля пользователя по id пользователя
    public int updateUserPassword(int userId, String newUserPassword) {
        logger.info("update user password");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update users set user_password = ?, user_date_update = ? where user_id = ?;");
                preparedStatement.setString(1, newUserPassword);
                preparedStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                preparedStatement.setInt(3, userId);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int userIdTemp = getUserId(userId);
        if (userIdTemp != -1) {
            return userIdTemp;
        } else {
            return -1;
        }
    }

    // запрос в базу данных на удаление пользователя по id пользователя
    public boolean deleteUser(int idUser) {
        logger.info("delete user");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from users where user_id = ?");
                preparedStatement.setInt(1, idUser);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int userID = getUserId(idUser);
        if (userID == -1) {
            return true;
        } else {
            return false;
        }
    }

    // запрос в базу данных на получения id пользователя по логину пользователя
    public int getUserId(User user) {
        logger.info("get user id");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select users.user_id from users where user_login = ?");
                preparedStatement.setString(1, user.getLogin());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получения id пользователя по логину пользователя
    public int getUserId(String login) {
        logger.info("get user id by login");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_id from users where user_login = ?");
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получения id пользователя по id пользователя
    public int getUserId(int userId) {
        logger.info("get user id by id");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_id from users where user_id = ?");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на проверку роли пользователя по id пользователя и по id роли
    public boolean checkUserRole(String userLogin, int userRoleId) {
        logger.info("check user_role_id by id");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_login, user_role_id from users where user_id = ?;");
                preparedStatement.setString(1, userLogin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String idUserDB = resultSet.getString(1);
                    int idUserRoleDB = resultSet.getInt(2);
                    if (userLogin == idUserDB && userRoleId == idUserRoleDB)
                        return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // запрос в базу данных на проверку логина и пароля
    public boolean checkUserPassword(String tempLogin, String tempPassword) {
        logger.info("check user password");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_login, user_password from users where user_login = ?");
                preparedStatement.setString(1, tempLogin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String userLoginDB = resultSet.getString(1);
                    String userPasswordDB = resultSet.getString(2);
                    if (tempLogin.equals(userLoginDB) && tempPassword.equals(userPasswordDB))
                        return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // запрос в базу данных на получения информации о пользователе
    public String getUserInfo(int userId) {
        logger.info("get user info");
        String userInfo = "";

        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select users.user_id, user_roles.user_role, users.user_name, users.user_login, users.user_password, user_email, user_secret_question, user_date_update from users " +
                        "inner join user_roles on users.user_role_id = user_roles.user_role_id where users.user_id = ?;");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    userInfo = "id - " + resultSet.getInt(1) +
                            ", роль пользователя - " + resultSet.getString(2) +
                            ", имя - " + resultSet.getString(3) +
                            ", логин - " + resultSet.getString(4) +
                            ", пароль - " + resultSet.getString(5) +
                            ", @mail - " + resultSet.getString(6) +
                            ", секретный вопрос - " + resultSet.getString(7) +
                            ", дата последнего обновления карточки - " + resultSet.getDate(8);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    // запрос в базу данных на получения информации об авторизованном пользователе
    public User getAuthorizedUserInfo(int userId) {
        logger.info("check user password");
        int tempIdUser = -1;
        int tempIdUserRole = -1;
        String tempIdUserLogin = "";
        String tempIdUserPassword = "";
        String tempUserName = "";
        String tempUserEmail = "";
        String tempUserSecretQestion = "";
        Timestamp tempUserDateUpdate = null;
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select user_id, user_role_id, user_name, user_login, user_password, user_phone_number, user_email, user_secret_question, user_date_update from users " +
                        " where user_id = ?;");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    tempIdUser = resultSet.getInt(1);
                    tempIdUserRole = resultSet.getInt(2);
                    tempUserName = resultSet.getString(3);
                    tempIdUserLogin = resultSet.getString(4);
                    tempIdUserPassword = resultSet.getString(5);
                    tempUserEmail = resultSet.getString(6);
                    tempUserSecretQestion = resultSet.getString(7);
                    tempUserDateUpdate = resultSet.getTimestamp(8);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(tempIdUser, tempIdUserRole, tempUserName, tempIdUserLogin, tempIdUserPassword, tempUserEmail, tempUserSecretQestion, tempUserDateUpdate);
    }

    // запрос в базу данных на получения информации о всех пользователях
    public ArrayList<String> getUsersInfo() {
        logger.info("get user info");
        ArrayList<String> listUsersInfo = new ArrayList<>();

        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select user_id, user_roles.user_role, user_name, user_login, user_password, user_email, user_secret_question, user_date_update from users " +
                        "inner join user_roles on users.user_role_id = user_roles.user_role_id order by users.user_id;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listUsersInfo.add("id - " + resultSet.getInt(1) +
                            ", роль пользователя - " + resultSet.getString(2) +
                            ", имя - " + resultSet.getString(3) +
                            ", логин - " + resultSet.getString(4) +
                            ", пароль - " + resultSet.getString(5) +
                            ", @mail - " + resultSet.getString(6) +
                            ", секретный вопрос - " + resultSet.getString(7) +
                            ", дата последнего обновления карточки - " + resultSet.getDate(8));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsersInfo;
    }


}
