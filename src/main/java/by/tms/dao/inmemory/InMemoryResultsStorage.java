package by.tms.dao.inmemory;

import by.tms.entity.Result;
import by.tms.web.filter.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InMemoryResultsStorage {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static InMemoryResultsStorage instance;

    private InMemoryResultsStorage() {
    }

    public static InMemoryResultsStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryResultsStorage();
        }
        return instance;
    }

    private final static ArrayList<Result> results = new ArrayList<>();

    public void addResult(Result result) {
        results.add(result);
        logger.info("Add result to list");
    }

    public ArrayList<Result> getAll(int userId) {
        ArrayList<Result> selectedResult = results.stream()
                .filter(result -> result.getResultCreatorId() == userId)
                .collect(Collectors.toCollection(ArrayList::new));
        logger.info("Return list of results");
        return selectedResult;
    }

    public void deleteAll() {
        results.clear();
    }
}