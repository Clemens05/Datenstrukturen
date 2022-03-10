package com.clemax.practices.morsealphabet;

import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Frame extends JFrame {
    private Translator translator;

    private BufferedImage image;

    private String windowTitle;

    private JPanel mainPanel;
    private JTextArea textTextArea;
    private JLabel imageLabel;
    private JTextArea morseTextArea;

    private final Font textFont = new Font(Font.SERIF, Font.PLAIN, 11);
    private final Font bigTextFont = new Font(Font.SERIF, Font.PLAIN, 15);
    private final Font monospacedTextFont = new Font(Font.MONOSPACED, Font.PLAIN, 15);
    private final Font headingFont = new Font("Loma", Font.BOLD, 48);
    private final Font subheadingFont = new Font(Font.SERIF, Font.BOLD, 24);

    public Frame(String windowTitle) {
        translator = new Translator();
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
        textTextArea = new JTextArea();
        imageLabel = null;
        morseTextArea = new JTextArea();

        mainPanel.setLayout(new GridLayout(1, 3));

        textTextArea.setFont(bigTextFont);
        textTextArea.setLineWrap(true);
        textTextArea.setText("HALLO");
        textTextArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String text = textTextArea.getText();
                System.out.println("Text updated: " + text);

                if (!text.isEmpty()) morseTextArea.setText(translator.codieren(text));
            }
        });

        try {
            image = ImageIO.read(new File("2_arrows.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image != null) {
            imageLabel = new JLabel(new ImageIcon(image));
        }

        morseTextArea.setFont(monospacedTextFont);
        morseTextArea.setLineWrap(true);
        morseTextArea.setText("..../.-/.-../.-../---");
        morseTextArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String morsecode = morseTextArea.getText();
                System.out.println("Morsecode updated: " + morsecode);

                if (!morsecode.isEmpty()) textTextArea.setText(translator.decodieren(morsecode));
            }
        });

        mainPanel.add(textTextArea);
        mainPanel.add(imageLabel);
        mainPanel.add(morseTextArea);
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
        Frame f = new Frame("Morse Übersetzer");
        f.setVisible(true);
    }
}

