package com.clemax.practices.vokabeltrainer;

import com.clemax.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    Vokabeltrainer vokabeltrainer = new Vokabeltrainer(
            new Sprache("de", "Deutsch"),
            new Sprache("en", "Englisch")
    );

    private final Font textFont = new Font("Serif", Font.PLAIN, 11);
    private final Font subheadingFont = new Font("Serif", Font.BOLD, 24);

    private String windowTitle;

    private JPanel mainPanel;
    private JPanel homePanel;
    private JPanel vokabelnPanel;
    private JTabbedPane tabbedPane;
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
        homePanel = new JPanel();
        vokabelnPanel = new JPanel();
        headingLabel = new JLabel();
        tabbedPane = new JTabbedPane();

        mainPanel.setLayout(new GridLayout(3, 1));

        headingLabel.setFont(new Font("Loma", Font.BOLD, 48));
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headingLabel.setText(windowTitle);

        this.initHomePanel();
        new VokabelnPanel();

        tabbedPane.addTab("Home", null, homePanel, "Startbereich");
        tabbedPane.addTab("Vokabeln", null, vokabelnPanel, "Vokabelbereich");

        mainPanel.add(headingLabel);
        mainPanel.add(tabbedPane);

        this.add(mainPanel);

        this.pack();
    }

    private void initHomePanel() {
        JLabel explanationLabel = new JLabel();

        homePanel.setLayout(new GridLayout(3, 11));

        explanationLabel.setFont(textFont);
        explanationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        explanationLabel.setText("Navigiere zwischen Tabs, um zu verschiedenen Seiten zu kommen.");

        homePanel.add(explanationLabel);
    }

    private class VokabelnPanel {
        JPanel vokabellistePanel;
        JButton addVokabelButton;

        public VokabelnPanel() {
            homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));

            addVokabelButton = new JButton();
            addVokabelButton.setText("Hinzufügen");
            addVokabelButton.setForeground(Color.green);
            addVokabelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("Vokabel hinzufügen");
                    JPanel mainPanel = new JPanel();
                    JTextField language1TextField;
                    JTextField language2TextField;
                    JButton cancelButton;
                    JButton okButton;

                    mainPanel.setLayout(new GridLayout(2, 1));

                    language1TextField = new JTextField();
                    language1TextField.setFont(textFont);
                    language1TextField.setHorizontalAlignment(SwingConstants.CENTER);
                    language1TextField.setText("");

                    language2TextField = new JTextField();
                    language2TextField.setFont(textFont);
                    language2TextField.setHorizontalAlignment(SwingConstants.CENTER);
                    language2TextField.setText("");

                    cancelButton = new JButton();
                    cancelButton.setText("Abbrechen");
                    cancelButton.setForeground(Color.red);
                    cancelButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.dispose();
                        }
                    });

                    okButton = new JButton();
                    okButton.setText("Ok");
                    okButton.setForeground(Color.blue);
                    okButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vokabeltrainer.addVokabel(
                                    language1TextField.getText(),
                                    language2TextField.getText()
                            );

                            frame.dispose();
                            rebuild();
                        }
                    });

                    mainPanel.add(language1TextField);
                    mainPanel.add(language2TextField);
                    mainPanel.add(cancelButton);
                    mainPanel.add(okButton);

                    frame.add(mainPanel);
                    frame.pack();
                    frame.setVisible(true);
                }
            });

            // START TEST
            vokabeltrainer.addVokabel("Haus", "house");
            vokabeltrainer.addVokabel("Tier", "animal");
            vokabeltrainer.addVokabel("Auto", "car");
            vokabeltrainer.addVokabel("Garten", "garden");
            // END TEST

            build();
        }

        private void build() {
            if (!vokabeltrainer.isEmpty()) {
                this.vokabellistePanel = new JPanel();
                JPanel vokabelkarte = null;
                String vokabelkarteHeading;
                JLabel vokabelkartelanguage1;
                JLabel vokabelkartelanguage2;
                JButton editVokabelButton;
                JButton deleteVokabelButton;

                vokabellistePanel.setLayout(new GridLayout(0, 3));

                vokabeltrainer.setToFirst();
                Vokabel firstVokabel = vokabeltrainer.getCurrentVokabel();

                do {
                    int id = vokabeltrainer.getCurrentVokabel().getId();
                    String word1 = vokabeltrainer.getCurrentVokabel().getWord1();
                    String word2 = vokabeltrainer.getCurrentVokabel().getWord2();

                    vokabelkarteHeading = "Vokabel #" + id;

                    vokabelkarte = new JPanel();
                    vokabelkarte.setLayout(new BoxLayout(vokabelkarte, BoxLayout.Y_AXIS));
                    vokabelkarte.setBorder(BorderFactory.createTitledBorder(vokabelkarteHeading));

                    vokabelkartelanguage1 = new JLabel();
                    vokabelkartelanguage1.setFont(textFont);
                    vokabelkartelanguage1.setHorizontalAlignment(SwingConstants.CENTER);
                    vokabelkartelanguage1.setText(vokabeltrainer.getCurrentVokabel().getWord1());

                    vokabelkartelanguage2 = new JLabel();
                    vokabelkartelanguage2.setFont(textFont);
                    vokabelkartelanguage2.setHorizontalAlignment(SwingConstants.CENTER);
                    vokabelkartelanguage2.setText(vokabeltrainer.getCurrentVokabel().getWord2());

                    editVokabelButton = new JButton();
                    editVokabelButton.setText("Bearbeiten");
                    editVokabelButton.setForeground(Color.blue);
                    editVokabelButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int id = vokabeltrainer.getCurrentVokabel().getId();
                            String word1 = vokabeltrainer.getCurrentVokabel().getWord1();
                            String word2 = vokabeltrainer.getCurrentVokabel().getWord2();

                            JFrame frame = new JFrame("Vokabel bearbeiten");
                            JPanel mainPanel = new JPanel();
                            JTextField language1TextField;
                            JTextField language2TextField;
                            JButton cancelButton;
                            JButton okButton;

                            mainPanel.setLayout(new GridLayout(2, 1));

                            language1TextField = new JTextField();
                            language1TextField.setFont(textFont);
                            language1TextField.setHorizontalAlignment(SwingConstants.CENTER);
                            language1TextField.setText(word1);

                            language2TextField = new JTextField();
                            language2TextField.setFont(textFont);
                            language2TextField.setHorizontalAlignment(SwingConstants.CENTER);
                            language2TextField.setText(word2);

                            cancelButton = new JButton();
                            cancelButton.setText("Abbrechen");
                            cancelButton.setForeground(Color.red);
                            cancelButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    frame.dispose();
                                }
                            });

                            okButton = new JButton();
                            okButton.setText("Ok");
                            okButton.setForeground(Color.blue);
                            okButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    vokabeltrainer.editVokabelById(
                                            language1TextField.getText(),
                                            language2TextField.getText(),
                                            id
                                    );

                                    frame.dispose();
                                    rebuild();
                                }
                            });

                            mainPanel.add(language1TextField);
                            mainPanel.add(language2TextField);
                            mainPanel.add(cancelButton);
                            mainPanel.add(okButton);

                            frame.add(mainPanel);
                            frame.pack();
                            frame.setVisible(true);
                        }
                    });

                    deleteVokabelButton = new JButton();
                    deleteVokabelButton.setText("Löschen");
                    deleteVokabelButton.setForeground(Color.red);
                    deleteVokabelButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vokabeltrainer.removeVokabelById(id);

                            rebuild();
                        }
                    });

                    vokabelkarte.add(vokabelkartelanguage1);
                    vokabelkarte.add(vokabelkartelanguage2);
                    vokabelkarte.add(editVokabelButton);
                    vokabelkarte.add(deleteVokabelButton);

                    vokabellistePanel.add(vokabelkarte);

                    vokabeltrainer.setToNext();
                } while (vokabeltrainer.getCurrentVokabel() != firstVokabel);
                vokabelnPanel.add(addVokabelButton);
                vokabelnPanel.add(vokabellistePanel);
            }
        }

        private void rebuild() {
            vokabellistePanel.removeAll();
            this.build();
        }
    }

    private void initVokabelnPanel() {
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));

        // START TEST
        vokabeltrainer.addVokabel("Haus", "house");
        vokabeltrainer.addVokabel("Tier", "animal");
        vokabeltrainer.addVokabel("Auto", "car");
        vokabeltrainer.addVokabel("Garten", "garden");
        // END TEST

        if (!vokabeltrainer.isEmpty()) {
            JPanel vokabellistePanel = new JPanel();
            JPanel vokabelkarte = null;
            String vokabelkarteHeading;
            JLabel vokabelkartelanguage1;
            JLabel vokabelkartelanguage2;
            JButton editVokabelButton;
            JButton deleteVokabelButton;

            vokabellistePanel.setLayout(new GridLayout(0, 3));

            vokabeltrainer.setToFirst();
            Vokabel firstVokabel = vokabeltrainer.getCurrentVokabel();

            do {
                System.out.println(vokabeltrainer.getCurrentVokabel().getWord1());

                vokabelkarteHeading = "Vokabel #" + vokabeltrainer.getCurrentVokabel().getId();

                vokabelkarte = new JPanel();
                vokabelkarte.setLayout(new BoxLayout(vokabelkarte, BoxLayout.Y_AXIS));
                vokabelkarte.setBorder(BorderFactory.createTitledBorder(vokabelkarteHeading));

                vokabelkartelanguage1 = new JLabel();
                vokabelkartelanguage1.setFont(textFont);
                vokabelkartelanguage1.setHorizontalAlignment(SwingConstants.CENTER);
                vokabelkartelanguage1.setText(vokabeltrainer.getCurrentVokabel().getWord1());

                vokabelkartelanguage2 = new JLabel();
                vokabelkartelanguage2.setFont(textFont);
                vokabelkartelanguage2.setHorizontalAlignment(SwingConstants.CENTER);
                vokabelkartelanguage2.setText(vokabeltrainer.getCurrentVokabel().getWord2());

                editVokabelButton = new JButton();
                editVokabelButton.setText("Bearbeiten");
                editVokabelButton.setForeground(Color.blue);

                deleteVokabelButton = new JButton();
                deleteVokabelButton.setText("Löschen");
                deleteVokabelButton.setForeground(Color.red);
                deleteVokabelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(vokabeltrainer.getCurrentVokabel().getWord1());
                        vokabeltrainer.removeCurrentVokabel();
                        System.out.println(vokabeltrainer.getCurrentVokabel().getWord1());
                    }
                });

                vokabelkarte.add(vokabelkartelanguage1);
                vokabelkarte.add(vokabelkartelanguage2);
                vokabelkarte.add(editVokabelButton);
                vokabelkarte.add(deleteVokabelButton);

                vokabellistePanel.add(vokabelkarte);

                vokabeltrainer.setToNext();
            } while (vokabeltrainer.getCurrentVokabel() != firstVokabel);
            vokabelnPanel.add(vokabellistePanel);
        }
    }

    private void setMacOSMenuBarStyle() {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.textantialiasing", "true");
            System.setProperty("apple.awt.application.name", windowTitle);
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
        Frame f = new Frame("Vokabeltrainer");
        f.setVisible(true);
    }
}
