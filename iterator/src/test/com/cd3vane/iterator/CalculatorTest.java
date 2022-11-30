package test.com.cd3vane.iterator;


import main.com.cd3vane.iterator.application.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        calculator.setCurrentOperation("+");
        calculator.setPreviousValue(12);
        calculator.setCurrentValue(43.5);

        assertEquals(55.5, calculator.calculate());
    }

    @Test
    void difference() {
        calculator.setCurrentOperation("-");
        calculator.setPreviousValue(170);
        calculator.setCurrentValue(26);

        assertEquals(144, calculator.calculate());
    }

    @Test
    void multiplication() {
        calculator.setCurrentOperation("*");
        calculator.setPreviousValue(12);
        calculator.setCurrentValue(12);

        assertEquals(144, calculator.calculate());

    }

    @Test
    void division() {
        calculator.setCurrentOperation("÷");
        calculator.setPreviousValue(144);
        calculator.setCurrentValue(12);

        assertEquals(12, calculator.calculate());
    }

}