package main.com.cd3vane.iterator.application;

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

    public Iterator createIterator(){
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator{
        private History history;
        private int index;

        ListIterator(History history){
            this.history = history;
        }
        @Override
        public void next() {
            index++;
        }
        @Override
        public boolean hasNext() {
            return (index < history.states.size());
        }

        @Override
        public CalculatorState current() {
            return history.states.get(index);
        }
    }

}
