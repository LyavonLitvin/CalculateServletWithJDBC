package by.tms.service;

import by.tms.entity.Result;
import by.tms.storage.InMySQLResultStorage;

import java.util.ArrayList;

public class ResultService {
    private InMySQLResultStorage inMySQLResultStorage = new InMySQLResultStorage();
    private Result result;

    // получение списка результатов
    public ArrayList<String> getResults(String userLogin) {
        ArrayList<String> listUserResults = inMySQLResultStorage.getListResultsFromUserId(userLogin);
        return listUserResults;
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
        return inMySQLResultStorage.addResult(result);
    }

//    // удаление результата
//    public boolean deleteTaskByIdTask(int idTask) {
//        return inMySQLResultStorage.deleteResultByResultId(idTask);
//    }

}
