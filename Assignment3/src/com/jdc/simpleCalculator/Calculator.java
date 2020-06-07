package com.jdc.simpleCalculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class Calculator implements Initializable {
	
	@FXML
	private TextField input1;
	@FXML
	private TextField input2;
	@FXML
	private ComboBox<String> cboOperator;
	@FXML
	private Label result;

	public void add() {
		try {
			int num1 = Integer.parseInt(input1.getText());
			int num2 = Integer.parseInt(input2.getText());
			int sum = num1 + num2;

			result.setText("Result : " + String.valueOf(sum));
		} catch (Exception e) {
			result.setText("Please Enter Digit Only");
		}
	}

	public void minus() {
		try {
			int num1 = Integer.parseInt(input1.getText());
			int num2 = Integer.parseInt(input2.getText());
			int minus = num1 - num2;

			result.setText("Result : " + String.valueOf(minus));
		} catch (Exception e) {
			result.setText("Please Enter Digit Only");
		}
	}

	public void multiply() {
		try {
			int num1 = Integer.parseInt(input1.getText());
			int num2 = Integer.parseInt(input2.getText());
			int multiply = num1 * num2;

			result.setText("Result : " + String.valueOf(multiply));
		} catch (Exception e) {
			result.setText("Please Enter Digit Only");
		}
	}

	public void divide() {
		try {
			int num1 = Integer.parseInt(input1.getText());
			int num2 = Integer.parseInt(input2.getText());
			if(num2 == 0) {
				input2.requestFocus();
				result.setText("Can't divide by zero");
				return;
			}
			int divide = num1 / num2;

			result.setText("Result : " + String.valueOf(divide));
		} catch (Exception e) {
			result.setText("Please Enter Digit Only");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		result.setText("");
		cboOperator.getItems().addAll("+", "-", "*", "÷");

		input1.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
				input2.requestFocus();
		});

		input2.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER || e.getCode() == KeyCode.TAB) {
				cboOperator.getSelectionModel().selectFirst();
				calculate(cboOperator.getValue().toString());
				
				cboOperator.setOnAction(event -> {
					calculate(cboOperator.getValue().toString());
				});
			}
		});
	}

	private void calculate(String operator) {
		switch (operator) {
		case "+":
			add();
			break;
		case "-":
			minus();
			break;
		case "*":
			multiply();
			break;
		case "÷":
			divide();
			break;
		default:
			add();
		}
	}
	
}
