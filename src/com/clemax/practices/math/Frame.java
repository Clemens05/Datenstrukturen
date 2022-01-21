package com.clemax.practices.math;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class Frame extends JFrame {
    private Rekursiv rekursiv;
    private double currentTime;

    private String windowTitle;

    private JPanel mainPanel;
    private JLabel headingLabel;
    private JLabel valueLabel;
    private JLabel timeLabel;
    private JLabel currentMethodLabel;
    private JTextField inputTextField;
    private JLabel resultLabel;

    private final Font textFont = new Font(Font.SERIF, Font.PLAIN, 11);
    private final Font monospacedTextFont = new Font(Font.MONOSPACED, Font.PLAIN, 15);
    private final Font headingFont = new Font("Loma", Font.BOLD, 48);
    private final Font subheadingFont = new Font(Font.SERIF, Font.BOLD, 24);

    public Frame(String windowTitle) {
        rekursiv = new Rekursiv();
        currentTime = 0;
        this.windowTitle = windowTitle;

        initComponents();
    }

    private void initComponents() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            this.setMacOSMenuBarStyle();
        }

        this.setTitle(windowTitle);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        headingLabel = new JLabel();
        valueLabel = new JLabel();
        timeLabel = new JLabel();
        currentMethodLabel = new JLabel();
        inputTextField = new JTextField();
        resultLabel = new JLabel();

        mainPanel.setLayout(new GridLayout(4, 1));

        headingLabel.setFont(headingFont);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setText(windowTitle);

        valueLabel.setFont(monospacedTextFont);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valueLabel.setText("-");

        timeLabel.setFont(monospacedTextFont);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setText("Gebrauchte Zeit: -");

        currentMethodLabel.setFont(monospacedTextFont);
        currentMethodLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentMethodLabel.setText("Aktuelle Methode: -");

        resultLabel.setFont(monospacedTextFont);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setText("= ");

        inputTextField.setFont(monospacedTextFont);
        inputTextField.setHorizontalAlignment(SwingConstants.CENTER);
        inputTextField.setText("...");
        inputTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputTextField.getText();
                int length = input.length();

                if (input.endsWith("!")) {
                    String numbers = input.substring(0, length - 1);
                    if (isNumberic(numbers)) {
                        long n = Long.parseLong(numbers);

                        setResultLabelToWait();

                        long startTime = System.currentTimeMillis();
                        long result = rekursiv.fakultaet(n);
                        long endTime = System.currentTimeMillis();

                        setResult(Long.toString(result));

                        currentTime = endTime - startTime;
                    } else {
                        setResultLabel("Bitte gebe eine Zahl ein.");
                    }
                } else if (input.startsWith("fib(") && input.endsWith(")")) {
                    String numbers = input.substring(4, length - 1);
                    if (isNumberic(numbers)) {
                        long n = Long.parseLong(numbers);

                        setResultLabelToWait();

                        long startTime = System.currentTimeMillis();
                        long result = rekursiv.fibonacci(n);
                        long endTime = System.currentTimeMillis();

                        setResult(Long.toString(result));

                        currentTime = endTime - startTime;
                    } else {
                        setResultLabel("Bitte gebe eine Zahl ein.");
                    }
                }

                updateAll();
            }
        });

        mainPanel.add(headingLabel);
        mainPanel.add(valueLabel);
        mainPanel.add(timeLabel);
        mainPanel.add(currentMethodLabel);
        mainPanel.add(inputTextField);
        mainPanel.add(resultLabel);

        this.add(mainPanel);

        this.pack();
    }

    private void updateAll() {
        updateValueLabel();
        updateTimeLabel();
        updateCurrentMethodLabel();
    }

    private void updateValueLabel() {
        valueLabel.setText("-");
    }

    private void updateTimeLabel() {
        timeLabel.setText("Gebrauchte Zeit: " + currentTime);
    }

    private void updateCurrentMethodLabel() {
        currentMethodLabel.setText("Aktuelle Methode: " + "-");
    }

    private void setResultLabel(String s) {
        resultLabel.setText(s);
    }

    private void setResultLabelToWait() {
        resultLabel.setText("...");
    }

    private void setResult(String s) {
        resultLabel.setText("= " + s);
    }

    private boolean isNumberic(String s) {
        if (s == null) {
            return false;
        }

        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    private void setMacOSMenuBarStyle() {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.textantialiasing", "true");
            System.setProperty("apple.awt.application.name", "Autokontrolle Simulation");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("InstantiationException: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException: " + e.getMessage());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Frame f = new Frame("Mathematische Methoden");
        f.setVisible(true);
    }
}
