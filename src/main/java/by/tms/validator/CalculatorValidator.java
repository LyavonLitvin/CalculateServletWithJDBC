package by.tms.validator;

public class CalculatorValidator {
    public boolean isNumeric(String inputData) {
        try {
            Double.parseDouble(inputData);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isRightOperator(String inputData) {
        if (inputData.equals("div") || inputData.equals("multiple") || inputData.equals("diff") || inputData.equals("sum")) {
            return true;
        } else {
            return false;
        }
    }
}
