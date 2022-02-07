package by.tms.repository;


import by.tms.entity.Result;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ResultRepository {
    final String url = "jdbc:mysql://localhost:3306/calculatordb?useUnicode=true&serverTimezone=UTC";
    final String username = "root";
    final String password = "admin";

    // запрос в базу данных на наличие задачи по id задачи
    public int getResultId(int resultId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
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
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // запрос в базу данных получение списка результатов
    public ArrayList<String> getListResultsFromUserId(int userId) { // Просмотр результатов назначенных пользователю
        ArrayList<String> listResults = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
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
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listResults;
    }

    // запрос в базу данных на получение информации по результату
    public String getResultInfoByResultId(int resultId) {
        String resultInfo = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
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
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return resultInfo;
    }

    // запрос в базу данных на списка всех результатов
    public ArrayList<String> getAllResults() {
        ArrayList<String> listAllResults = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("" +
                        "select result_id, users.user_login, first_number, operator_type, second_number, result_number, result_update_date from results " +
                        "inner join users on results.result_creator_id = users.user_id " +
                        "order by result_creator_id;");
                ResultSet resultSet;
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listAllResults.add("id - " + resultSet.getInt(1) +
                            ", Посчитал - " + resultSet.getString(2) +
                            ", Выражение: " + resultSet.getDouble(3) +
                            " " + resultSet.getString(4) +
                            " " + resultSet.getDouble(5) +
                            " = " + resultSet.getDouble(6) +
                            ", Дата вычисления - " + resultSet.getDate(7));
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return listAllResults;
    }

    // запрос в базу данных на проверку наличия задачи с выбранной id задачи и id пользователя
    public boolean checkResultByResultIdAndUserId(int resultId, int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("select result_id from results where result_id = ? and result_creator_id= ?;");
                preparedStatement.setInt(1, resultId);
                preparedStatement.setInt(2, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    // запрос в базу данных на добавление результата расчета
    public boolean addResult(Result result) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into results (result_creator_id, first_number, operator_type, second_number, result_number," +
                        "result_update_date) values (?,?,?,?,?,?);");
                preparedStatement.setInt(1, result.getResultCreatorId());
                preparedStatement.setDouble(2, result.getFirstNumber());
                preparedStatement.setString(3, result.getOperatorType());
                preparedStatement.setDouble(4, result.getSecondNumber());
                preparedStatement.setDouble(5, result.getResultNumber());
                preparedStatement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return checkResultByResultIdAndUserId(result.getResultId(), result.getResultCreatorId());
    }

    // запрос в базу данных на удаление результата с выбранной id результата
    public boolean deleteResultByResultId(int resultId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from results where result_id = ?;");
                preparedStatement.setInt(1, resultId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (getResultId(resultId) == -1) {
            return true;
        } else {
            return false;
        }
    }

    // запрос в базу данных на удаление всех результатов с выбранной id пользователя
    public boolean deleteResultsByUserId(int userId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from results where result_creator_id = ?;");
                preparedStatement.setInt(1, userId);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (getListResultsFromUserId(userId).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
