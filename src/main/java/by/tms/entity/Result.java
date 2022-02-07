package by.tms.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Result {
    private int resultId;
    private int resultCreatorId;
    private double firstNumber;
    private double secondNumber;
    private String operatorType;
    private double resultNumber;
    private String userName;
    private Timestamp resultUpdateDate;

    public Result() {
    }

    public Result(int resultId, int resultCreatorId, double firstNumber, double secondNumber, String operatorType, double resultNumber, String userName, Timestamp resultUpdateDate) {
        this.resultId = resultId;
        this.resultCreatorId = resultCreatorId;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
        this.userName = userName;
        this.resultUpdateDate = resultUpdateDate;
    }

    public Result(int resultCreatorId, double firstNumber, double secondNumber, String operatorType, double resultNumber, String userName, Timestamp resultUpdateDate) {
        this.resultCreatorId = resultCreatorId;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
        this.userName = userName;
        this.resultUpdateDate = resultUpdateDate;
    }

    public Result(double firstNumber, double secondNumber, String operatorType, String userName) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.userName = userName;
    }

    public Result(double firstNumber, double secondNumber, String operatorType, double resultNumber, String userName) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
        this.userName = userName;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public double getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(double resultNumber) {
        this.resultNumber = resultNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getResultCreatorId() {
        return resultCreatorId;
    }

    public void setResultCreatorId(int resultCreatorId) {
        this.resultCreatorId = resultCreatorId;
    }

    public Timestamp getResultUpdateDate() {
        return resultUpdateDate;
    }

    public void setResultUpdateDate(Timestamp resultUpdateDate) {
        this.resultUpdateDate = Timestamp.valueOf(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return " " + firstNumber + " " + operatorType + " " + secondNumber + " = " + resultNumber + " ";
    }


}
