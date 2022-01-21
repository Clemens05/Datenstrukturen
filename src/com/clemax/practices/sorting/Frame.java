package com.clemax.practices.sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class Frame extends JFrame {
    private double currentTime;

    private ArraySort arraySort;
    private String windowTitle;

    private JPanel mainPanel;
    private JLabel headingLabel;
    private JLabel valueLabel;
    private JLabel timeLabel;
    private JLabel currentMethodLabel;
    private JButton insertionSortButton;
    private JButton selectionSortButton;
    private JButton bubbleSortButton;
    private JButton linearSearchButton;
    private JButton binarySearchButton;
    private JButton resetButton;

    private final Font textFont = new Font(Font.SERIF, Font.PLAIN, 11);
    private final Font monospacedTextFont = new Font(Font.MONOSPACED, Font.PLAIN, 15);
    private final Font headingFont = new Font("Loma", Font.BOLD, 48);
    private final Font subheadingFont = new Font(Font.SERIF, Font.BOLD, 24);

    public Frame(String windowTitle) {
        currentTime = 0;
        this.windowTitle = windowTitle;

        arraySort = new ArraySort(getRandomArray());
        logArray();

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
        insertionSortButton = new JButton();
        selectionSortButton = new JButton();
        bubbleSortButton = new JButton();
        linearSearchButton = new JButton();
        binarySearchButton = new JButton();
        resetButton = new JButton();

        mainPanel.setLayout(new GridLayout(4, 1));

        headingLabel.setFont(headingFont);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setText(windowTitle);

        valueLabel.setFont(monospacedTextFont);
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valueLabel.setText(arraySort.werteToString());

        timeLabel.setFont(monospacedTextFont);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setText("Gebrauchte Zeit: -");

        currentMethodLabel.setFont(monospacedTextFont);
        currentMethodLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentMethodLabel.setText("Aktuelle Methode: -");

        insertionSortButton.setText("Insertion Sort anwenden");
        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                final double startTime = System.currentTimeMillis();
                arraySort.sort(arraySort.INSERTION_SORT);
                final double endTime = System.currentTimeMillis();

                currentTime = endTime - startTime;

                updateAll();
                System.out.println("Verlaufszeit von Insertion Sort: " + (endTime - startTime) + " Millisek.");
            }
        });

        selectionSortButton.setText("Selection Sort anwenden");
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final double startTime = System.currentTimeMillis();
                arraySort.sort(arraySort.SELECTION_SORT);
                final double endTime = System.currentTimeMillis();

                currentTime = endTime - startTime;

                updateAll();
                System.out.println("Verlaufszeit von Bubble Sort: " + (endTime - startTime) + " Millisek.");
            }
        });

        bubbleSortButton.setText("Bubble Sort anwenden");
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final double startTime = System.currentTimeMillis();
                arraySort.sort(arraySort.BUBBLE_SORT);
                final double endTime = System.currentTimeMillis();

                currentTime = endTime - startTime;

                updateAll();
                System.out.println("Verlaufszeit von Bubble Sort: " + (endTime - startTime) + " Millisek.");
            }
        });

        linearSearchButton.setText("Lineare Suche anwenden");
        linearSearchButton.setForeground(Color.MAGENTA);
        linearSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Zu suchende Zahl eingeben:");
                double startTime = 0;
                double endTime = 0;
                try {
                    int value = Integer.parseInt(input);
                    startTime = System.currentTimeMillis();
                    boolean exists = arraySort.search_if_exists(arraySort.LINEAR_SEARCH, value);
                    endTime = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, (exists ? "Ist vorhanden" : "Ist nicht vorhanden"), windowTitle, JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    System.err.println("Exception while parsing input to int: " + ex);
                    JOptionPane.showMessageDialog(null, "Bitte gebe eine Zahl vom Typ int ein.", windowTitle, JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    System.err.println("Exception while parsing input to int: " + ex);
                }

                currentTime = endTime - startTime;

                updateAll();
                System.out.println("Verlaufszeit von der linearen Suche: " + (endTime - startTime) + " Millisek.");
            }
        });

        binarySearchButton.setText("Binäre Suche anwenden");
        binarySearchButton.setForeground(Color.MAGENTA);
        binarySearchButton.setEnabled(false);
        binarySearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Zu suchende Zahl eingeben:");
                double startTime = 0;
                double endTime = 0;
                try {
                    int value = Integer.parseInt(input);
                    startTime = System.currentTimeMillis();
                    boolean exists = arraySort.search_if_exists(arraySort.BINARY_SEARCH, value);
                    endTime = System.currentTimeMillis();
                    JOptionPane.showMessageDialog(null, (exists ? "Ist vorhanden" : "Ist nicht vorhanden"), windowTitle, JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    System.err.println("Exception while parsing input to int: " + ex);
                    JOptionPane.showMessageDialog(null, "Bitte gebe eine Zahl vom Typ int ein.", windowTitle, JOptionPane.ERROR_MESSAGE);
                }
                catch (Exception ex) {
                    System.err.println("Exception while parsing input to int: " + ex);
                }

                currentTime = endTime - startTime;

                updateAll();
                System.out.println("Verlaufszeit von der binären Suche: " + (endTime - startTime) + " Millisek.");
            }
        });

        resetButton.setText("Zurücksetzen");
        resetButton.setForeground(Color.BLUE);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetWerte();
                updateAll();
            }
        });

        mainPanel.add(headingLabel);
        mainPanel.add(valueLabel);
        mainPanel.add(timeLabel);
        mainPanel.add(currentMethodLabel);
        mainPanel.add(insertionSortButton);
        mainPanel.add(selectionSortButton);
        mainPanel.add(bubbleSortButton);
        mainPanel.add(linearSearchButton);
        mainPanel.add(binarySearchButton);
        mainPanel.add(resetButton);

        this.add(mainPanel);

        this.pack();
    }

    private void resetWerte() {
        arraySort.setWerte(getRandomArray());
        updateValueLabel();
    }

    private void updateAll() {
        updateValueLabel();
        logArray();
        updateTimeLabel();
        updateCurrentMethodLabel();
        updateBinarySearchButton();
    }

    private void updateValueLabel() {
        valueLabel.setText(arraySort.werteToString());
    }

    private void updateTimeLabel() {
        timeLabel.setText("Gebrauchte Zeit: " + currentTime);
    }

    private void updateCurrentMethodLabel() {
        currentMethodLabel.setText("Aktuelle Methode: " + arraySort.getCurrentSort());
    }

    private void updateBinarySearchButton() {
        binarySearchButton.setEnabled(arraySort.isSorted());
    }

    private int[] getRandomArray() {
        int[] ints = new int[1000];

        Random r = new Random();
        for (int i = 0; i < ints.length - 1; i++) {
            ints[i] = r.nextInt(1000);
        }

        return ints;
    }

    private void logArray() {
        System.out.println("Array: " + arraySort.werteToString());
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
        Frame f = new Frame("Sortieren");
        f.setVisible(true);
    }
}
