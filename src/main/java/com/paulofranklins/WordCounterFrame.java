package com.paulofranklins;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterFrame extends JFrame {
    private JTextArea jTextArea;
    private JButton jButton;

    public WordCounterFrame() {
        initializeFrame();
        initializeComponents();
        addComponentsToFrame();
    }

    private void initializeFrame() {
        setTitle("World Counter");
        setLayout(null);
        setBounds(100, 100, 500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        jTextArea = new JTextArea();
        jTextArea.setBounds(50, 50, 400, 200);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        jButton = new JButton("Check ");
        jButton.setBounds(180, 300, 100, 30);
        jButton.addActionListener(new WordCountActionListener());
    }

    private void addComponentsToFrame() {
        add(jTextArea);
        add(jButton);
    }

    private class WordCountActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = jTextArea.getText();
            if (!text.isEmpty()) {
                String[] words = text.split("\\s");
                JOptionPane.showMessageDialog(WordCounterFrame.this, "Total Words: " + words.length);
            } else {
                JOptionPane.showMessageDialog(WordCounterFrame.this, "Invalid Words");
            }
        }
    }
}
