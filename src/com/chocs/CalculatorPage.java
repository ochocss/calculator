package com.chocs;

import javax.swing.JFrame;

class CalculatorPage extends JFrame {
	public CalculatorPage() {
        this.pack();
        this.setTitle("Calculator");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setSize(320, 440);
        this.setLocation(800, 300);
        this.add(new Calculator());
        this.setVisible(true);
    }
}