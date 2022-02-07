package by.tms.service;

import by.tms.entity.Result;
import by.tms.repository.ResultRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class ResultService {
    private ResultRepository resultRepository = new ResultRepository();
    private Result result;

    // получение списка результатов
    public void getListResultsFromUserId(int userId) {
        ArrayList<String> listUserTasks = resultRepository.getListResultsFromUserId(userId);
        System.out.println("\nСписок заданий пользователя:\n");
        listUserTasks.forEach(System.out::println);
    }

    // получение информации о задаче по id пользователя и id задачи
    public String getTaskInfoByIdUserAndIdTask(int userId, int resultId) {
        String taskInfo = resultRepository.getTaskInfoFromIdUserAndIdTask(userId, resultId);
        if (taskInfo.length() == 0) {
            return "Проверьте корректность вводимых данных";
        }
        return taskInfo;
    }

    // получение id задачи по id задачи
    public int getIdTask(int resultId) {
        int idTaskDB = resultRepository.getResultId(resultId);
        return idTaskDB;
    }

    // получение информации о задаче
    public String getTaskInfo(int taskId) {
        return resultRepository.getTaskInfoByIdTask(taskId);
    }

    // получение id статуса задачи по статусу задачи
    public int getIdTaskStatusFromTaskStatus(String taskStatus) {
        int idStatus = taskStatusRepository.getIdTaskStatusFromTaskStatus(taskStatus);
        return idStatus;
    }

    // получение id категории задачи по категории задачи
    public int getIdTaskCategoryFromNameTaskCategory(String nameTaskCategory) {
        int idCategory = taskCategoryRepository.getIdTaskCategoryFromTaskCategory(nameTaskCategory);
        return idCategory;
    }

    // получение id категории задачи
    public int getIdTaskCategory(int idTaskCategory) {
        return taskCategoryRepository.getIdTaskCategory(idTaskCategory);
    }

    // получение информации о всех задачах
    public void printTasksInfo() {
        ArrayList<String> listTasksInfo = resultRepository.getAllResults();
        System.out.println("\nСписок всех задач:");
        listTasksInfo.forEach(System.out::println);
    }

    // получение списка категорий
    public void printListCategory() {
        HashMap<Integer, String> listCategory = taskCategoryRepository.getListTaskCategories();
        System.out.println("\nСписок всех категорий:");
        listCategory.forEach((k, v) -> {
            System.out.println("ID - " + k + ", название категории - " + v);
        });
    }

    // добавление задачи в БД
    public boolean addTaskToDB(int idTaskCreator, int idTaskExecutor, int idTaskCategory,
                               int idTaskStatus, String taskTopic, Timestamp taskDateUpdate, String taskDescription) {
        result = new Task(idTaskCreator, idTaskExecutor, idTaskCategory, idTaskStatus, taskTopic, taskDateUpdate, taskDescription);
        return resultRepository.addTask(result);
    }

    // удаление задачи
    public boolean deleteTaskByIdTask(int idTask) {
        return resultRepository.deleteResultByResultId(idTask);
    }

    // обновление названия задачи
    public boolean updateTaskTopic(int idTask, String newTaskTopic) {
        return resultRepository.updateTaskTopic(idTask, newTaskTopic);
    }

    // обновление описания задачи
    public boolean updateTaskDescription(int idTask, String newTaskDescription) {
        return resultRepository.updateTaskDescription(idTask, newTaskDescription);
    }

    // обновление исполнителя задачи
    public boolean updateUserIdForTask(int idTask, int idUser) {
        return resultRepository.updateIdUserByIdTaskAndIdUser(idTask, idUser);
    }
}
