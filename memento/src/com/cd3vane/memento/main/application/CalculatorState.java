package com.cd3vane.memento.main.application;

public class CalculatorState {
    private final double value;

    public CalculatorState(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }


}
