package by.tms.storage;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;

public class InMySQLUserRoleRepository {
    final String url = "jdbc:mysql://localhost:3306/calculatordb?userUnicode=true&serverTimezone=UTC";
    final String username = "root";
    final String password = "admin";

    // запрос в базу данных на получения списка ролей пользователей
    public HashMap<Integer, String> getHashMapUserRoles() {
        HashMap<Integer, String> hashMapUserRoles = new HashMap<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from user_roles order by user_role_id");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    hashMapUserRoles.put(resultSet.getInt(1), resultSet.getString(2));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return hashMapUserRoles;
    }

    // запрос в базу данных на получения id роли пользователя
    public int getUserRoleByUserRoleId(int userRoleId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select user_roles.user_role_id from user_roles where user_role_id = ?");
                preparedStatement.setInt(1, userRoleId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получение id роли по логину пользователя
    public int getUserRoleByUserLogin(String userLogin) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
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
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получение id роли по id пользователя
    public int getUserRoleIdByUserId(int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
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
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных на получения названия роли по id роли
    public String getRoleNameFromUserRoleId(int userRoleId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
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
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "";
    }
}