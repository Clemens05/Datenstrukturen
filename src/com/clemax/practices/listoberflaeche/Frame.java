package com.clemax.practices.listoberflaeche;

import com.clemax.List;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private List<Fahrzeug> fahrzeugliste;

    private String windowTitle;

    private JPanel mainPanel;
    private JLabel headingLabel;

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
        headingLabel = new JLabel();

        mainPanel.setLayout(new GridLayout(3, 1));

        headingLabel.setFont(new Font("Loma", Font.BOLD, 48));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setText(windowTitle);

        mainPanel.add(headingLabel);

        this.add(mainPanel);

        this.pack();
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
        Frame f = new Frame("Fahrzeugliste");
        f.setVisible(true);
    }
}
