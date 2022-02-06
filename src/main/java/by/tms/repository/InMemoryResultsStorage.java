package by.tms.repository;

import by.tms.entity.Result;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InMemoryResultsStorage {

    private static InMemoryResultsStorage instance;

    private InMemoryResultsStorage() {
    }

    public static InMemoryResultsStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryResultsStorage();
        }
        return instance;
    }

    private final static  ArrayList<Result> results = new ArrayList<>();

    public void saveResult(Result result) {
        results.add(result);
    }

    public ArrayList<Result> getResults(String username) {
        ArrayList<Result> selectedResult = results.stream()
                .filter(result -> result.getUserName() == username)
                .collect(Collectors.toCollection(ArrayList::new));
        return selectedResult;
    }

    public void delResults() {
        results.clear();
    }
}