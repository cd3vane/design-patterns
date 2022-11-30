package test.com.cd3vane.iterator;



import main.com.cd3vane.iterator.application.Calculator;
import main.com.cd3vane.iterator.application.History;
import main.com.cd3vane.iterator.application.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryTest {
    private final Calculator calculator = new Calculator();
    private static History history;
    private static Iterator iterator;

    @BeforeEach
     void init(){
        history = new History();
        calculator.setPreviousValue(12);
        history.push(calculator.createState());
        calculator.setPreviousValue(13);
        history.push(calculator.createState());
        calculator.setPreviousValue(45);
        history.push(calculator.createState());

        iterator = history.createIterator();
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

    @Test
    void hasNext(){
        assert(iterator.hasNext());
    }

    @Test
    void getFirst(){
        var currentState = iterator.current();
        assertEquals(12, currentState.getValue());
    }

    @Test
    void getNext(){
        iterator.next();
        var currentState = iterator.current();
        assertEquals(13, currentState.getValue());
    }






}