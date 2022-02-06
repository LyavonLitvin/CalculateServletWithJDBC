package by.tms.service;

import by.tms.entity.Result;
import by.tms.repository.InMemoryResultsStorage;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CalculatorService {

    InMemoryResultsStorage inMemoryResultsStorage = InMemoryResultsStorage.getInstance();

    public CalculatorService() {
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
        saveResult(result);
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

    public void saveResult(Result result) {
        inMemoryResultsStorage.saveResult(result);
    }

    public ArrayList<String> getResults(String username) {
        ArrayList<String> selectedResult = inMemoryResultsStorage.getResults(username).stream()
                .map(Result::toString)
                .collect(Collectors.toCollection(ArrayList::new));
        return selectedResult;
    }

    public ArrayList<Result> getResultsToSOUT(String username) {
        return inMemoryResultsStorage.getResults(username);
    }

    public void deleteResults() {
        inMemoryResultsStorage.delResults();
    }
}






