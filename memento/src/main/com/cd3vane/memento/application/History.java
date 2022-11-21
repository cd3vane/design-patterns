package main.com.cd3vane.memento.application;

import java.util.ArrayList;
import java.util.List;

public class History {
    public List<CalculatorState> states = new ArrayList<>();


    public void push(CalculatorState state){
        states.add(state);
    }

    public CalculatorState pop() throws ArrayIndexOutOfBoundsException{
        int indexOfLastElement = states.size() - 1;
        var lastState = states.get(indexOfLastElement);
        states.remove(indexOfLastElement);
        return lastState;
    }

}
