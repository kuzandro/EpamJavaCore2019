package ru.epam.javacore.lesson_6_collections.lesson.a_1_anonymous_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo {

    private static int clickedNumber = 0;
    private static final String DEFAULT_CAPTION = "Click me";
    private static JButton button;

    private static class BtnClickLstnr implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            button.setText(DEFAULT_CAPTION + " " + (++clickedNumber));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello world");
        frame.setSize(new Dimension(640, 480));
        frame.setLayout(new FlowLayout());

        button = new JButton(DEFAULT_CAPTION);
        button.addActionListener(new BtnClickLstnr());
        /*button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText(DEFAULT_CAPTION + " " + (++clickedNumber));
            }
        });*/

       /* button.addActionListener( new BtnClickLstnr(){
            @Override
            public void actionPerformed(ActionEvent e) {
                super.actionPerformed(e);
            }
        });
        */
        button.setSize(new Dimension(100, 100));
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
