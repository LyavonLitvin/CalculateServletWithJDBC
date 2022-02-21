package by.tms.service;

import by.tms.entity.Result;
import by.tms.dao.jdbc.InMySQLResultDAO;
import by.tms.valuelisthandler.ValueList;
import by.tms.valuelisthandler.ValueListHandler;

import java.util.ArrayList;

public class ResultService {
    private InMySQLResultDAO inMySQLResultDAO = InMySQLResultDAO.getInstance();
    private Result result;

    public Result calculation(Result result) {
        double resultNumber = 0;
        String controlLetter = result.getOperatorType();
        if (controlLetter.equals("+")) {
            resultNumber = sum(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("-")) {
            resultNumber = diff(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("*")) {
            resultNumber = multiple(result.getFirstNumber(), result.getSecondNumber());
        } else if (controlLetter.equals("/")) {
            resultNumber = divide(result.getFirstNumber(), result.getSecondNumber());
        }
        result.setResultNumber(resultNumber);
        addResult(result);
        return result;
    }

    public double diff(double a, double b) {
        return (a - b);
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public double multiple(double a, double b) {
        return a * b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    // получение списка результатов
    public ArrayList<String> getResults(int userId) {
        ArrayList<String> listUserResults = inMySQLResultDAO.getListResultsFromUserId(userId);
        return listUserResults;
    }

    public ValueList getResultsForHandler(int userId) {
        ValueList valueList = new ValueListHandler();
        valueList.setList(inMySQLResultDAO.getListResultsFromUserId(userId));
        return valueList;
    }

//    // получение id задачи по id результата
//    public int getResultId(int resultId) {
//        int resultIdInDB = inMySQLResultStorage.getResultId(resultId);
//        return resultIdInDB;
//    }
//
//    // получение информации о результате
//    public String getResultInfo(int resultId) {
//        return inMySQLResultStorage.getResultInfoByResultId(resultId);
//    }

//    // получение информации о всех задачах
//    public void printTasksInfo() {
//        ArrayList<String> listAllResults = inMySQLResultStorage.getAllResults();
//        return listAllResults;
//    }

    // добавление результата в БД
    public boolean addResult(Result result) {
        return inMySQLResultDAO.addResult(result);
    }

//    // удаление результата
//    public boolean deleteTaskByIdTask(int idTask) {
//        return inMySQLResultStorage.deleteResultByResultId(idTask);
//    }

}
