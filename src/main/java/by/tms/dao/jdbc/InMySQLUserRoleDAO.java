package by.tms.dao.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.HashMap;

public class InMySQLUserRoleDAO {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    final String url = "jdbc:mysql://localhost:3306/calculatordb?userUnicode=true&serverTimezone=UTC";
    final String username = "root";
    final String password = "admin";

    // запрос в базу данных на получения списка ролей пользователей
    public HashMap<Integer, String> getHashMapUserRoles() {
        logger.info("get user info");
        HashMap<Integer, String> hashMapUserRoles = new HashMap<>();
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from user_roles order by user_role_id");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    hashMapUserRoles.put(resultSet.getInt(1), resultSet.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hashMapUserRoles;
    }

    // запрос в базу данных на получения id роли пользователя
    public int getUserRoleByUserRoleId(int userRoleId) {
        logger.info("get user_role by user_role_id");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_roles.user_role_id from user_roles where user_role_id = ?");
                preparedStatement.setInt(1, userRoleId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получение id роли по логину пользователя
    public int getUserRoleByUserLogin(String userLogin) {
        logger.info("get user_role by user_login");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_role_id from users where user_login = ?;");
                preparedStatement.setString(1, userLogin);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получение id роли по id пользователя
    public int getUserRoleIdByUserId(int userId) {
        logger.info("get user_role by user_id");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_role_id from users where user_id = ?;");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получения названия роли по id роли
    public String getRoleNameFromUserRoleId(int userRoleId) {
        logger.info("get role_name by user_role_id");
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_role from user_roles where user_role_id = ?;");
                preparedStatement.setInt(1, userRoleId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getString(1);
                } else {
                    return "";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
