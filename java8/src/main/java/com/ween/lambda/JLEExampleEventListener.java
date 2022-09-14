package com.ween.lambda;

import javax.swing.*;

/**
 * @author weenhall
 */
public class JLEExampleEventListener {
    public static void main(String[] args) {
        JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton jButton = new JButton("click");
        jButton.setBounds(80, 100, 70, 30);

        //lambda expression implementing here
        jButton.addActionListener(e -> {
            tf.setText("hello swing");
        });
        JFrame jFrame = new JFrame();
        jFrame.add(tf);
        jFrame.add(jButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setSize(300, 200);
        jFrame.setVisible(true);

    }
}
