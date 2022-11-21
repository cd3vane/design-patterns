package com.cd3vane.memento.test;



import com.cd3vane.memento.main.application.Calculator;
import com.cd3vane.memento.main.application.History;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryTest {
    private final Calculator calculator = new Calculator();
    private static History history;

    @BeforeEach
     void init(){
        history = new History();
        calculator.setPreviousValue(12);
        history.push(calculator.createState());
        calculator.setPreviousValue(13);
        history.push(calculator.createState());
        calculator.setPreviousValue(45);
        history.push(calculator.createState());
    }

    @Test
    void push() {
        assertEquals(3, history.states.size());
    }

    @Test
    void pop() {
        history.pop();

        var lastIndex = history.states.size() - 1;
        var lastElement = history.states.get(lastIndex);

        assertEquals(13, lastElement.getValue());
    }


}