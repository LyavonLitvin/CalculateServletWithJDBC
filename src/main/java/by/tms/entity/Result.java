package by.tms.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Result {
    private int resultID;
    private int resultCreatorID;
    private double firstNumber;
    private double secondNumber;
    private String operatorType;
    private double resultNumber;
    private String userName;
    private Timestamp resultUpdateDate;

    public Result() {
    }

    public Result(int resultID, int resultCreatorID, double firstNumber, double secondNumber, String operatorType, double resultNumber, String userName, Timestamp resultUpdateDate) {
        this.resultID = resultID;
        this.resultCreatorID = resultCreatorID;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operatorType = operatorType;
        this.resultNumber = resultNumber;
        this.userName = userName;
        this.resultUpdateDate = resultUpdateDate;
    }

    public Result(int resultCreatorID, double firstNumber, double secondNumber, String operatorType, double resultNumber, String userName, Timestamp resultUpdateDate) {
        this.resultCreatorID = resultCreatorID;
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

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getResultCreatorID() {
        return resultCreatorID;
    }

    public void setResultCreatorID(int resultCreatorID) {
        this.resultCreatorID = resultCreatorID;
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
