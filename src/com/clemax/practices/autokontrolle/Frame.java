package com.clemax.practices.autokontrolle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Frame extends JFrame {
    private Verkehrskontrolle verkehrskontrolle;

    private String windowTitle = "Autokontrolle Simulation";

    private JPanel mainPanel;

    private JMenuBar mainMenuBar;
    private JMenu fileMenu;
    private JMenu fileNewMenu;
    private JMenuItem fileNewVehicleMenuItem;
    private JLabel headingLabel;
    private JLabel firstFahrzeugLabel;
    private JButton herauswinkenButton;

    private Verkehrskontrolle v;

    public Frame() {
        initComponents();

        String inputMaxAnzahlAutos = JOptionPane.showInputDialog(null, "Gebe eine maximale Anzahl von kontrollierenden Fahrzeugen an:", windowTitle, JOptionPane.INFORMATION_MESSAGE);
        String inputMinAnzahlMaengel = JOptionPane.showInputDialog(null, "Gebe eine minimale Anzahl von mangelhaften Fahrzeugen an:", windowTitle, JOptionPane.INFORMATION_MESSAGE);

        int maxAnzahlAutos;
        try {
            maxAnzahlAutos = Integer.parseInt(inputMaxAnzahlAutos);
        } catch (Exception ex) {
            maxAnzahlAutos = 100;
        }

        int minAnzahlMaengel = 100;
        try {
            minAnzahlMaengel = Integer.parseInt(inputMinAnzahlMaengel);
        } catch (Exception ignored) { }

        verkehrskontrolle = new Verkehrskontrolle(maxAnzahlAutos, minAnzahlMaengel);
    }

    private void initComponents() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            setMacOSMenuBarStyle();
        }

        this.setTitle("Autokontrolle Simulation");

        mainPanel = new JPanel();
        mainMenuBar = new JMenuBar();
        fileMenu = new JMenu("Datei");
        fileNewMenu = new JMenu(("Neu"));
        fileNewVehicleMenuItem = new JMenuItem("Fahrzeug...");
        headingLabel = new JLabel();
        firstFahrzeugLabel = new JLabel();
        herauswinkenButton = new JButton();

        // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.setLayout(new GridLayout(3, 1));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        fileNewVehicleMenuItem.addActionListener(new ActionListener() {
            private JFrame newVehicleFrame;
            private JPanel newVehiclePanel;

            private JLabel modellDescriptionLabel;
            private JLabel farbeDescriptionLabel;
            private JLabel kennzeichenDescriptionLabel;
            private JLabel verkehrstauglichLabel;

            private JTextField modellTextField;
            private JComboBox<String> farbeComboBox;
            private JTextField kennzeichenTextField;
            private JCheckBox verkehrstauglichkeitCheckBox;

            private JButton createNewVehicleButton;
            private JButton cancelButton;

            @Override
            public void actionPerformed(ActionEvent e) {
                newVehicleFrame = new JFrame();

                initComponents();

                newVehicleFrame.setVisible(true);
            }

            private void initComponents() {
                newVehicleFrame.setTitle("Autokontrolle Simulation / Neues Fahrzeug");

                newVehiclePanel = new JPanel();

                modellDescriptionLabel = new JLabel();
                farbeDescriptionLabel = new JLabel();
                kennzeichenDescriptionLabel = new JLabel();
                verkehrstauglichLabel = new JLabel();

                modellTextField = new JTextField();
                farbeComboBox = new JComboBox<>(new String[] { "-", "Blau", "Rot", "Grün", "Gelb" });
                kennzeichenTextField = new JTextField();
                verkehrstauglichkeitCheckBox = new JCheckBox();

                createNewVehicleButton = new JButton();
                cancelButton = new JButton();

                newVehiclePanel.setLayout(new GridLayout(5, 2));

                modellDescriptionLabel.setFont(new Font("Loma", Font.PLAIN, 12));
                modellDescriptionLabel.setHorizontalAlignment(SwingConstants.LEADING);
                modellDescriptionLabel.setText("Modellname: ");

                farbeDescriptionLabel.setFont(new Font("Loma", Font.PLAIN, 12));
                farbeDescriptionLabel.setHorizontalAlignment(SwingConstants.LEADING);
                farbeDescriptionLabel.setText("Farbe: ");

                kennzeichenDescriptionLabel.setFont(new Font("Loma", Font.PLAIN, 12));
                kennzeichenDescriptionLabel.setHorizontalAlignment(SwingConstants.LEADING);
                kennzeichenDescriptionLabel.setText("Kennzeichen: ");

                verkehrstauglichLabel.setFont(new Font("Loma", Font.PLAIN, 12));
                verkehrstauglichLabel.setHorizontalAlignment(SwingConstants.LEADING);
                verkehrstauglichLabel.setText("Verkehrstauglich: ");

                createNewVehicleButton.setText("Neues Fahrzeug erstellen");
                createNewVehicleButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addNewFahrzeug(modellTextField.getText(), Objects.requireNonNull(farbeComboBox.getSelectedItem()).toString(), kennzeichenTextField.getText(), verkehrstauglichkeitCheckBox.isSelected());

                        newVehicleFrame.dispose();
                    }
                });

                cancelButton.setText("Abbrechen");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        newVehicleFrame.dispose();
                    }
                });

                newVehiclePanel.add(modellDescriptionLabel);
                newVehiclePanel.add(modellTextField);
                newVehiclePanel.add(farbeDescriptionLabel);
                newVehiclePanel.add(farbeComboBox);
                newVehiclePanel.add(kennzeichenDescriptionLabel);
                newVehiclePanel.add(kennzeichenTextField);
                newVehiclePanel.add(verkehrstauglichLabel);
                newVehiclePanel.add(verkehrstauglichkeitCheckBox);
                newVehiclePanel.add(createNewVehicleButton);
                newVehiclePanel.add(cancelButton);

                newVehicleFrame.add(newVehiclePanel);

                newVehicleFrame.pack();
            }
        });

        fileNewMenu.add(fileNewVehicleMenuItem);
        fileMenu.add(fileNewMenu);
        mainMenuBar.add(fileMenu);

        headingLabel.setFont(new Font("Loma", Font.BOLD, 48));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setText("Autokontrolle Simulation");

        firstFahrzeugLabel.setFont(new Font("Loma", Font.PLAIN, 12));
        firstFahrzeugLabel.setHorizontalAlignment(SwingConstants.CENTER);
        firstFahrzeugLabel.setText("<html><code>Kein Fahrzeug ist in der Kontrolle</code></html>");

        herauswinkenButton.setText("Herauswinken");
        herauswinkenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verkehrskontrolle.herauswinken();

                updateInformationLabels();
            }
        });

        mainPanel.add(headingLabel);
        mainPanel.add(firstFahrzeugLabel);
        mainPanel.add(herauswinkenButton);

        this.setJMenuBar(mainMenuBar);
        this.add(mainPanel);

        this.pack();
    }

    public void updateInformationLabels() {
        if (!verkehrskontrolle.fahrzeugeIsEmpty()) {
            String modell = (!verkehrskontrolle.getFirstFahrzeug().getModell().equals("")) ? verkehrskontrolle.getFirstFahrzeug().getModell() : "N/A";
            String farbe = (!verkehrskontrolle.getFirstFahrzeug().getFarbe().equals("")) ? verkehrskontrolle.getFirstFahrzeug().getFarbe() : "N/A";
            String kennzeichen = (!verkehrskontrolle.getFirstFahrzeug().getKennzeichen().equals("")) ? verkehrskontrolle.getFirstFahrzeug().getKennzeichen() : "N/A";
            String verkehrstauglich = (verkehrskontrolle.getFirstFahrzeug().isVerkehrstauglich()) ? "Ja" : "Nein";

            firstFahrzeugLabel.setText("<html><code>" + kennzeichen + " [ " + modell + ", " + farbe + " ]; Verkehrstauglich: " + verkehrstauglich + "</code></html>");
        } else {
            firstFahrzeugLabel.setText("<html><code>Kein Fahrzeug ist in der Kontrolle.</code></html>");
        }
    }

    public void addNewFahrzeug(String modell, String farbe, String kennzeichen, boolean verkehrstauglich) {
        verkehrskontrolle.addFahrzeug(new Fahrzeug(modell, farbe, kennzeichen, verkehrstauglich));

        updateInformationLabels();
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
        Frame f = new Frame();
        f.setVisible(true);
    }
}
