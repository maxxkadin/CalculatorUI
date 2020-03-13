package GUI;

import domain.ArithmeticOperations;
import domain.Calculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class CalculatorUI extends Application implements EventHandler<ActionEvent> {

    Calculator theCalculator = new Calculator();

    Label displayLabel = new Label("");

    String operation = "";

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");

        GridPane calculatorGridPane = new GridPane();


        displayLabel.setFont(new Font(20));
        displayLabel.setPadding(new Insets(20));
        displayLabel.setPrefSize(500, 50);
        displayLabel.setTextAlignment(TextAlignment.RIGHT);
        displayLabel.setMaxWidth(Double.MAX_VALUE);


        //Making Buttons and adding functionality.
        int buttonSize = 35;
        Button button0 = new Button("0");
        button0.setPrefSize(buttonSize, buttonSize);
        button0.setOnAction(this);
        Button button1 = new Button("1");
        button1.setPrefSize(buttonSize, buttonSize);
        button1.setOnAction(this);
        Button button2 = new Button("2");
        button2.setPrefSize(buttonSize, buttonSize);
        button2.setOnAction(this);
        Button button3 = new Button("3");
        button3.setPrefSize(buttonSize, buttonSize);
        button3.setOnAction(this);
        Button button4 = new Button("4");
        button4.setPrefSize(buttonSize, buttonSize);
        button4.setOnAction(this);
        Button button5 = new Button("5");
        button5.setPrefSize(buttonSize, buttonSize);
        button5.setOnAction(this);
        Button button6 = new Button("6");
        button6.setPrefSize(buttonSize, buttonSize);
        button6.setOnAction(this);
        Button button7 = new Button("7");
        button7.setPrefSize(buttonSize, buttonSize);
        button7.setOnAction(this);
        Button button8 = new Button("8");
        button8.setPrefSize(buttonSize, buttonSize);
        button8.setOnAction(this);
        Button button9 = new Button("9");
        button9.setPrefSize(buttonSize, buttonSize);
        button9.setOnAction(this);

        //Arithmetic
        Button plusButton = new Button("+");
        plusButton.setPrefSize(buttonSize, buttonSize);
        plusButton.setOnAction(value -> {
            theCalculator.setAppendedNumber(Integer.parseInt(displayLabel.getText()));
            operation = plusButton.getText();
            displayLabel.setText("");
        });
        Button subtractButton = new Button("-");
        subtractButton.setPrefSize(buttonSize, buttonSize);
        subtractButton.setOnAction(value -> {
            theCalculator.setAppendedNumber(Integer.parseInt(displayLabel.getText()));
            operation = subtractButton.getText();
            displayLabel.setText("");
        });
        Button multiplyButton = new Button("x");
        multiplyButton.setPrefSize(buttonSize, buttonSize);
        multiplyButton.setOnAction(value -> {
            theCalculator.setAppendedNumber(Integer.parseInt(displayLabel.getText()));
            operation = multiplyButton.getText();
            displayLabel.setText("");
        });
        Button divideButton = new Button("\u00F7");
        divideButton.setPrefSize(buttonSize, buttonSize);
        divideButton.setOnAction(value -> {
            theCalculator.setAppendedNumber(Integer.parseInt(displayLabel.getText()));
            operation = divideButton.getText();
            displayLabel.setText("");
        });
        Button equalsButton = new Button("=");
        equalsButton.setPrefSize(buttonSize, buttonSize);
        equalsButton.setOnAction(value -> {
            if(operation == plusButton.getText()){
                theCalculator.setAppendedNumber(ArithmeticOperations.add(theCalculator.getAppendedNumber(), Integer.parseInt(displayLabel.getText())));
                theCalculator.setShownNumber(theCalculator.getAppendedNumber() + "");
                displayLabel.setText(theCalculator.getShownNumber());
            } else if(operation == subtractButton.getText()){
                theCalculator.setAppendedNumber(ArithmeticOperations.subtract(theCalculator.getAppendedNumber(), Integer.parseInt(displayLabel.getText())));
                theCalculator.setShownNumber(theCalculator.getAppendedNumber() + "");
                displayLabel.setText(theCalculator.getShownNumber());
            } else if(operation == multiplyButton.getText()){
                theCalculator.setAppendedNumber(ArithmeticOperations.multiply(theCalculator.getAppendedNumber(), Integer.parseInt(displayLabel.getText())));
                theCalculator.setShownNumber(theCalculator.getAppendedNumber() + "");
                displayLabel.setText(theCalculator.getShownNumber());
            } else if(operation == divideButton.getText()){
                theCalculator.setAppendedNumber(ArithmeticOperations.divide(theCalculator.getAppendedNumber(), Integer.parseInt(displayLabel.getText())));
                theCalculator.setShownNumber(theCalculator.getAppendedNumber() + "");
                displayLabel.setText(theCalculator.getShownNumber());
            }
        });

        //Memory
        Button memoryReadButton = new Button("MR");
        memoryReadButton.setPrefSize(buttonSize, buttonSize);
        memoryReadButton.setOnAction(value -> {
            displayLabel.setText(theCalculator.getMemoryNumber() + "");
        });
        Button memoryClearButton = new Button("MC");
        memoryClearButton.setPrefSize(buttonSize, buttonSize);
        memoryClearButton.setOnAction(value -> {
            theCalculator.clearMemoryNumber();
        });
        Button memoryAddButton = new Button("M+");
        memoryAddButton.setPrefSize(buttonSize, buttonSize);
        memoryAddButton.setOnAction(value -> {
            theCalculator.addMemoryNumber(theCalculator.getInputNumber());
            displayLabel.setText("");
        });
        Button memorySubtractButton = new Button("M-");
        memorySubtractButton.setPrefSize(buttonSize, buttonSize);
        memorySubtractButton.setOnAction(value -> {
            theCalculator.subtractMemoryNumber(theCalculator.getInputNumber());
            displayLabel.setText("");
        });

        //Other Buttons
        Button clearCalculatorButton = new Button("C");
        clearCalculatorButton.setPrefSize(buttonSize, buttonSize);
        clearCalculatorButton.setOnAction(value -> {
            theCalculator.clearCalculator();
            displayLabel.setText(theCalculator.getShownNumber() + "");
        });
        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(buttonSize*4, buttonSize);
        exitButton.setOnAction(value -> {
            System.exit(0);
        });


        //Adding Buttons to grid.
        calculatorGridPane.add(displayLabel, 0, 0, 4, 1);
        calculatorGridPane.add(button0, 1, 5);
        calculatorGridPane.add(button1, 0, 4);
        calculatorGridPane.add(button2, 1, 4);
        calculatorGridPane.add(button3, 2, 4);
        calculatorGridPane.add(button4, 0, 3);
        calculatorGridPane.add(button5, 1, 3);
        calculatorGridPane.add(button6, 2, 3);
        calculatorGridPane.add(button7, 0, 2);
        calculatorGridPane.add(button8, 1, 2);
        calculatorGridPane.add(button9, 2, 2);
        calculatorGridPane.add(plusButton, 3, 5);
        calculatorGridPane.add(subtractButton, 3, 4);
        calculatorGridPane.add(multiplyButton, 3,3 );
        calculatorGridPane.add(divideButton, 3, 2);
        calculatorGridPane.add(equalsButton, 2, 5);
        calculatorGridPane.add(memoryReadButton, 0, 1);
        calculatorGridPane.add(memoryClearButton, 1, 1);
        calculatorGridPane.add(memoryAddButton, 2, 1);
        calculatorGridPane.add(memorySubtractButton, 3, 1);
        calculatorGridPane.add(clearCalculatorButton, 0, 5);
        calculatorGridPane.add(exitButton, 0, 6, 4, 1);

        Scene mainScene = new Scene(calculatorGridPane, buttonSize*calculatorGridPane.getColumnCount(), buttonSize*calculatorGridPane.getRowCount());
        stage.setScene(mainScene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String hitNumber = ((Button) actionEvent.getSource()).getText();
        if(!displayLabel.getText().isEmpty()) {
            hitNumber =  theCalculator.getInputNumber() + hitNumber;
        }
        displayLabel.setText(hitNumber);
        theCalculator.setInputNumber(Integer.parseInt(hitNumber));
    }
}