package by.tms.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultServiceTest {

    @Test
    void calculation() {
        ResultService resultService = new ResultService();
        double result = resultService.sum(2,2);
        assertEquals(4, result);
    }
}