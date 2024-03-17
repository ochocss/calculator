package com.chocs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JPanel implements ActionListener {
	private final Font DEFAULT_FONT = new Font("Tahoma", Font.BOLD, 36);

	private JTextField textField;

	private final JButton[] functionButtons = new JButton[8];
	private final JButton[] numberButtons = new JButton[10];

	private final JButton addButton, subButton, mulButton, divButton;
	private final JButton equButton, decButton, delButton, clrButton;

	private double num1 = 0;
	private double num2 = 0;
	private double result = 0;
	private char operator;

	public Calculator() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5); // intern spaces

		textField = new JTextField();
		textField.setFont(DEFAULT_FONT);
		textField.setEditable(false);

		this.add(textField, gbc);

		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");

		equButton = new JButton("=");
		decButton = new JButton(".");
		delButton = new JButton("Del");
		clrButton = new JButton("CE");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;

		functionButtons[4] = equButton;
		functionButtons[5] = decButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;

		for(int i = 0; i < 8; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(DEFAULT_FONT);
			functionButtons[i].setFocusable(false);
		}

		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(DEFAULT_FONT);
			numberButtons[i].setFocusable(false);
		}

		gbc.gridwidth = 2;  // cell width = 2
		gbc.gridy++; // next line

		gbc.gridx = 0;
		this.add(clrButton, gbc);
		gbc.gridx = 2;
		this.add(delButton, gbc);

		gbc.gridy++;
		gbc.gridwidth = 1;

		gbc.gridx = 0;
		this.add(numberButtons[7], gbc);
		gbc.gridx = 1;
		this.add(numberButtons[8], gbc);
		gbc.gridx = 2;
		this.add(numberButtons[9], gbc);
		gbc.gridx = 3;
		this.add(divButton, gbc);

		gbc.gridy++;

		gbc.gridx = 0;
		this.add(numberButtons[4], gbc);
		gbc.gridx = 1;
		this.add(numberButtons[5], gbc);
		gbc.gridx = 2;
		this.add(numberButtons[6], gbc);
		gbc.gridx = 3;
		this.add(mulButton, gbc);

		gbc.gridy++;

		gbc.gridx = 0;
		this.add(numberButtons[1], gbc);
		gbc.gridx = 1;
		this.add(numberButtons[2], gbc);
		gbc.gridx = 2;
		this.add(numberButtons[3], gbc);
		gbc.gridx = 3;
		this.add(subButton, gbc);

		gbc.gridy++;

		gbc.gridx = 0;
		this.add(decButton, gbc);
		gbc.gridx = 1;
		this.add(numberButtons[0], gbc);
		gbc.gridx = 2;
		this.add(equButton, gbc);
		gbc.gridx = 3;
		this.add(addButton, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}

		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}

		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}

		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}

		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}

		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}

		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());

			switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
			}

			textField.setText(String.valueOf(result));
			num1 = result;
		}

		if(e.getSource() == clrButton) {
			textField.setText("");
		}

		if(e.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");

			for(int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
	}
}