package by.tms.service;

import by.tms.entity.Result;
import by.tms.dao.inmemory.InMemoryResultsStorage;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InMemoryResultsStorageService {

    InMemoryResultsStorage inMemoryResultsStorage = InMemoryResultsStorage.getInstance();

    public InMemoryResultsStorageService() {
    }

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

    public void addResult(Result result) {
        inMemoryResultsStorage.addResult(result);
    }

    public ArrayList<String> getResults(int userId) {
        ArrayList<String> selectedResult = inMemoryResultsStorage.getAll(userId).stream()
                .map(Result::toString)
                .collect(Collectors.toCollection(ArrayList::new));
        return selectedResult;
    }

    public ArrayList<Result> getResultsToSOUT(int userId) {
        return inMemoryResultsStorage.getAll(userId);
    }

    public void deleteResults() {
        inMemoryResultsStorage.deleteAll();
    }
}






