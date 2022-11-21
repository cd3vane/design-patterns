package main.com.cd3vane.memento.application;

public class CalculatorState {
    private final double value;

    public CalculatorState(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }


}
