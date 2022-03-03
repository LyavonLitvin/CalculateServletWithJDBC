package by.tms.dao.jdbc;


import by.tms.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static ProjectDAO instance;

    private ProjectDAO() {
    }

    private List executeSelect(User user) {
        ArrayList<String> listResults = new ArrayList<>();
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select result_id, first_number, operator_type, second_number, result_number, result_update_date  from results " +
                        "where results.result_creator_id = ? order by result_id;");
                preparedStatement.setInt(1, user.getIdUser());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listResults.add("id - " + resultSet.getInt(1) +
                            ", Выражение: " + resultSet.getDouble(3) +
                            " " + resultSet.getString(4) +
                            " " + resultSet.getDouble(5) +
                            " = " + resultSet.getDouble(6) +
                            ", Дата вычисления - " + resultSet.getDate(7));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResults;
    }

    final String url = "jdbc:mysql://localhost:3306/calculatordb?useUnicode=true&serverTimezone=UTC";
    final String username = "root";
    final String password = "admin";

    // запрос в базу данных на наличие задачи по id задачи
    public int getResultId(int resultId) {
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select results.result_id from results where result_id = ?;");
                preparedStatement.setInt(1, resultId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    return id;
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных получение списка результатов
    public ArrayList<String> getListResultsFromUserId(int userId) { // Просмотр результатов назначенных пользователю
        ArrayList<String> listResults = new ArrayList<>();
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select result_id, first_number, operator_type, second_number, result_number, result_update_date  from results " +
                        "where results.result_creator_id = ? order by result_id;");
                preparedStatement.setInt(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listResults.add("id - " + resultSet.getInt(1) +
                            ", Выражение: " + resultSet.getDouble(3) +
                            " " + resultSet.getString(4) +
                            " " + resultSet.getDouble(5) +
                            " = " + resultSet.getDouble(6) +
                            ", Дата вычисления - " + resultSet.getDate(7));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResults;
    }

    // запрос в базу данных на получение информации по результату
    public String getResultInfoByResultId(int resultId) {
        String resultInfo = "";
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select result_id, users.user_login, first_number, operator_type, second_number, result_number, result_update_date from results " +
                        "inner join users on results.result_creator_id = users.user_id " +
                        "where results.result_id = ?");
                preparedStatement.setInt(1, resultId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    resultInfo = "id - " + resultSet.getInt(1) +
                            ", Посчитал - " + resultSet.getString(2) +
                            ", Выражение: " + resultSet.getDouble(3) +
                            " " + resultSet.getString(4) +
                            " " + resultSet.getDouble(5) +
                            " = " + resultSet.getDouble(6) +
                            ", Дата вычисления - " + resultSet.getDate(7);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultInfo;
    }

    public int getCountOfRows (int userId) {
        int count = 0;
        try {
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select count(result_id)" +
                        "from results where result_creator_id = ?;");
                preparedStatement.setInt(1, userId);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (getListResultsFromUserId(userId).isEmpty()) {
            return count;
        } else {
            return -1;
        }
    }
}
