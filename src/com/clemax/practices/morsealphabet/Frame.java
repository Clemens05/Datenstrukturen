package com.clemax.practices.morsealphabet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Frame extends JFrame {
    private BufferedImage image;

    private String windowTitle;

    private JPanel mainPanel;
    private JTextField textTextField;
    private JTextArea textTextArea;
    private JLabel imageLabel;
    private JTextField morseTextField;

    private final Font textFont = new Font(Font.SERIF, Font.PLAIN, 11);
    private final Font bigTextFont = new Font(Font.SERIF, Font.PLAIN, 15);
    private final Font monospacedTextFont = new Font(Font.MONOSPACED, Font.PLAIN, 15);
    private final Font headingFont = new Font("Loma", Font.BOLD, 48);
    private final Font subheadingFont = new Font(Font.SERIF, Font.BOLD, 24);

    public Frame(String windowTitle) {
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
        textTextField = new JTextField();
        textTextArea = new JTextArea();
        imageLabel = null;
        morseTextField = new JTextField();

        mainPanel.setLayout(new GridLayout(1, 3));

        textTextField.setFont(bigTextFont);
        textTextField.setHorizontalAlignment(SwingConstants.CENTER);
        textTextField.setText("HALLO");
        textTextField.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String input = textTextField.getText();
                System.out.println("Text updated: " + input);
            }
        });

        textTextArea.setFont(bigTextFont);

        textTextArea.setText("HALLO");

        try {
            image = ImageIO.read(new File("2_arrows.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image != null) {
            imageLabel = new JLabel(new ImageIcon(image));
        }

        morseTextField.setFont(monospacedTextFont);
        morseTextField.setHorizontalAlignment(SwingConstants.CENTER);
        morseTextField.setText("····/·-/·-··/·-··/---");
        morseTextField.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String input = morseTextField.getText();
                System.out.println("Morse updated: " + input);
            }
        });

        mainPanel.add(textTextField);
        mainPanel.add(imageLabel);
        mainPanel.add(morseTextField);
        this.add(mainPanel);

        this.pack();
    }

    private void updateAll() {

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
        Frame f = new Frame("Morse Parse");
        f.setVisible(true);
    }
}

