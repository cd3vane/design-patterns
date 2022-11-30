package main.com.cd3vane.iterator.application;

public interface Iterator {
    void next();
    boolean hasNext();
    CalculatorState current();
}
