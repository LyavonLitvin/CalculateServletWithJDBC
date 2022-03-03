package by.tms.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultServiceTest {

    @Test
    void calculationSum() {
        ResultService resultService = new ResultService();
        double result = resultService.sum(2,2);
        assertEquals(4, result);
    }

    @Test
    void calculationDiff(){
        ResultService resultService = new ResultService();
        double result = resultService.diff(2,2);
        assertEquals(0, result);
    }

    @Test
    void calculationMultiple(){
        ResultService resultService = new ResultService();
        double result = resultService.multiple(2,2);
        assertEquals(4, result);
    }

    @Test
    void calculationDivide(){
        ResultService resultService = new ResultService();
        double result = resultService.divide(2,2);
        assertEquals(1, result);
    }
}