package main.com.cd3vane.iterator.gui;



import main.com.cd3vane.iterator.application.Calculator;
import main.com.cd3vane.iterator.application.History;
import main.com.cd3vane.iterator.application.Iterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    Font MONOSPACED_BOLD_20 = new Font("Monospaced", Font.BOLD, 22);
    JButton addButton, subtractButton, divideButton, multiplyButton, clearButton, undoButton, equalsButton, decimalButton, deleteButton, historyButton;
    JButton[] numberButtons;
    JTextField outputDisplay;
    String previousValueAsString, currentValueAsString, operatorAsString;
    Calculator calculator = new Calculator();
    History history = new History();
    Iterator iterator;


    public CalculatorGUI() {
        super("Calculator App");

        JPanel mainPanel = new JPanel();

        // Initializing the calculator operands
        currentValueAsString = "";
        previousValueAsString = "";

        // Create sub panels inside com.cd3vane.memento.main panel
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();
        JPanel row4 = new JPanel();
        JPanel row5 = new JPanel();

        // Initialize components
        outputDisplay = new JTextField(16);
        subtractButton = new JButton("-");
        addButton = new JButton("+");
        divideButton = new JButton("÷");
        multiplyButton = new JButton("*");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        undoButton = new JButton("U");
        deleteButton = new JButton("D");
        historyButton = new JButton("H");

        // Instantiate action listeners
        NumberBtnHandler numberButtonHandler = new NumberBtnHandler();
        OtherBtnHandler otherButtonHandler = new OtherBtnHandler();
        OperatorBtnHandler operatorButtonHandler = new OperatorBtnHandler();

        // Initialize, style, and add action listeners to number buttons
        numberButtons = new JButton[11];
        numberButtons[10] = decimalButton;
        for (int count = 0; count < numberButtons.length - 1; count++) {
            numberButtons[count] = new JButton(String.valueOf(count));
            numberButtons[count].setFont(MONOSPACED_BOLD_20);
            numberButtons[count].addActionListener(numberButtonHandler);
        }

        // Style other buttons
        decimalButton.setFont(MONOSPACED_BOLD_20);
        equalsButton.setFont(MONOSPACED_BOLD_20);
        addButton.setFont(MONOSPACED_BOLD_20);
        subtractButton.setFont(MONOSPACED_BOLD_20);
        divideButton.setFont(MONOSPACED_BOLD_20);
        multiplyButton.setFont(MONOSPACED_BOLD_20);
        clearButton.setFont(MONOSPACED_BOLD_20);
        undoButton.setFont(MONOSPACED_BOLD_20);
        deleteButton.setFont(MONOSPACED_BOLD_20);
        historyButton.setFont(MONOSPACED_BOLD_20);

        // Style the output display
        outputDisplay.setMaximumSize(new Dimension(185, 40));
        outputDisplay.setFont(new Font("Monospaced", Font.BOLD, 27));
        outputDisplay.setDisabledTextColor(new Color(0, 0, 0));
        outputDisplay.setMargin(new Insets(0, 5, 0, 0));
        outputDisplay.setText("0");

        // Add action listeners to other buttons
        decimalButton.addActionListener(numberButtonHandler);
        clearButton.addActionListener(otherButtonHandler);
        undoButton.addActionListener(otherButtonHandler);
        deleteButton.addActionListener(otherButtonHandler);
        equalsButton.addActionListener(otherButtonHandler);
        historyButton.addActionListener(otherButtonHandler);

        // Add action listeners to operation buttons
        multiplyButton.addActionListener(operatorButtonHandler);
        addButton.addActionListener(operatorButtonHandler);
        subtractButton.addActionListener(operatorButtonHandler);
        divideButton.addActionListener(operatorButtonHandler);

        // Set the layout of each row in the pane
        row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
        row2.setLayout(new BoxLayout(row2, BoxLayout.LINE_AXIS));
        row3.setLayout(new BoxLayout(row3, BoxLayout.LINE_AXIS));
        row4.setLayout(new BoxLayout(row4, BoxLayout.LINE_AXIS));
        row5.setLayout(new BoxLayout(row5, BoxLayout.LINE_AXIS));

        // Add components to each of the row
        row1.add(Box.createHorizontalGlue());
        row1.add(clearButton);
        row1.add(undoButton);
        row1.add(deleteButton);
        row1.add(historyButton);
        row2.add(numberButtons[7]);
        row2.add(numberButtons[8]);
        row2.add(numberButtons[9]);
        row2.add(multiplyButton);
        row3.add(numberButtons[4]);
        row3.add(numberButtons[5]);
        row3.add(numberButtons[6]);
        row3.add(addButton);
        row4.add(numberButtons[1]);
        row4.add(numberButtons[2]);
        row4.add(numberButtons[3]);
        row4.add(subtractButton);
        row5.add(decimalButton);
        row5.add(numberButtons[0]);
        row5.add(equalsButton);
        row5.add(divideButton);

        // Add all rows to the com.cd3vane.memento.main panel
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(outputDisplay);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        mainPanel.add(row1);
        mainPanel.add(row2);
        mainPanel.add(row3);
        mainPanel.add(row4);
        mainPanel.add(row5);

        // final touch
        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(205, 280);

    }

    private class NumberBtnHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedBtn = (JButton) e.getSource();
            for (JButton btn : numberButtons) {
                if (selectedBtn == btn) {
                    appendToOutput(btn.getText());
                    updateOutput();
                }
            }
        }
    }

    private class OperatorBtnHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedBtn = (JButton) e.getSource();
            if (selectedBtn == multiplyButton) {
                selectOperator(multiplyButton.getText());
            } else if (selectedBtn == addButton) {
                selectOperator(addButton.getText());
            } else if (selectedBtn == subtractButton) {
                selectOperator(subtractButton.getText());
            } else if (selectedBtn == divideButton) {
                selectOperator(divideButton.getText());
            }
            updateOutput();
        }
    }

    private class OtherBtnHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton selectedBtn = (JButton) e.getSource();
            if (selectedBtn == deleteButton) {
                delete();
            } else if (selectedBtn == undoButton) {
                undo();
            } else if (selectedBtn == clearButton) {
                clear();
            } else if (selectedBtn == equalsButton) {
                calculateToString();
            } else if (selectedBtn == historyButton) {
                showHistory();
        }
        }
    }

    public void processOutputNumber() {
        if (currentValueAsString.length() > 0) {
            String integerPart = currentValueAsString.split("\\.")[0];
            String decimalPart = currentValueAsString.split("\\.")[1];
            if (decimalPart.equals("0")) {
                currentValueAsString = integerPart;
            }
        }
    }

    public void delete() {
        if (currentValueAsString.length() > 0) {
            currentValueAsString = currentValueAsString.substring(0, currentValueAsString.length() - 1);
            calculator.setCurrentValue(Double.parseDouble(currentValueAsString));
            updateOutput();
        }
    }

    public void undo(){
        if(history.states.size() == 0){
            return;
        }
        calculator.restoreState(history.pop());
        currentValueAsString = calculator.getCurrentValueAsString();
        updateOutput();
    }

    public void clear() {
        calculator = new Calculator();
        currentValueAsString = "";
        previousValueAsString = "";
        outputDisplay.setText("0");
    }

    public void updateOutput() {
        outputDisplay.setText(currentValueAsString);
    }

    public void appendToOutput(String num) {
        if (num.equals(".") && currentValueAsString.contains(".")) {
            return;
        }
        currentValueAsString += num;
        calculator.setCurrentValue(Double.parseDouble(currentValueAsString));
    }

    public void showHistory(){
        iterator = history.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.current().getValue());
            iterator.next();
        }
    }

    public void calculateToString() {
        double result = calculator.calculate();

        currentValueAsString = String.valueOf(result);
        calculator.setCurrentValue(result);
        history.push(calculator.createState());

        operatorAsString = null;

        previousValueAsString = "";
        calculator.setPreviousValue(0);

        processOutputNumber();
        updateOutput();
    }

    public void selectOperator(String newOperator) {
        // if no number is entered yet
        if (currentValueAsString.isEmpty()) {
            operatorAsString = newOperator;
            return;
        }
        if (!previousValueAsString.isEmpty()) {
            calculateToString();
        }

        operatorAsString = newOperator;
        calculator.setCurrentOperation(newOperator);

        previousValueAsString = currentValueAsString;
        calculator.setPreviousValue(calculator.getCurrentValue());

        currentValueAsString = "";
        calculator.setCurrentValue(0);
    }
}
