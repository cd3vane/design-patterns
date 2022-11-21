package main.com.cd3vane.memento.application;

public class Calculator {
    private String currentOperation;
    private double previousValue;
    private double currentValue;

    public Calculator(){
        previousValue = 0;
        currentValue = 0;
    }

    public double calculate(){
        switch(currentOperation){
            case "+":
                return previousValue + currentValue;
            case "-":
                return previousValue - currentValue;
            case "*":
                return previousValue * currentValue;
            case "÷":
                return handleDivision();
            default:
                return Double.NaN;
        }
    }

    public double handleDivision(){
        if(currentValue == 0){
            return Double.NaN;
        }
        return previousValue / currentValue;
    }

    public CalculatorState createState(){
        return new CalculatorState(previousValue);
    }

    public void restoreState(CalculatorState state){
        currentValue = state.getValue();
    }

    public void setCurrentOperation(String currentOperation) {
        this.currentOperation = currentOperation;
    }

    public void setPreviousValue(double previousValue) {
        this.previousValue = previousValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public String getCurrentValueAsString(){
        return String.valueOf(currentValue);
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }
}
