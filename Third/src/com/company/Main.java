package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args)
    throws InterruptedException
    {
        //String a = JOptionPane.showInputDialog("Хуйня какая-то");
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //действие после нажатия "крестика"

        frame.setTitle("Hello, there!");    //название формы
        //frame.getContentPane().setBackground(new Color(100,0,55));
        frame.setLocationRelativeTo(null); //форма посередине экрана
        frame.setResizable(true);  //запрещает равертывание формы
        frame.setLayout(null);
        frame.setLayout(new BorderLayout());

        Cursor waitCursor = new Cursor(Cursor.WAIT_CURSOR);


        JButton btn1 = new JButton("Count");
        btn1.setSize(80,30);
        btn1.setBackground(Color.BLACK);
        btn1.setForeground(Color.white);
        btn1.setCursor(waitCursor);
        //btn1.setLocation(100,20);

        frame.add(btn1, BorderLayout.LINE_END);

        JTextField textField = new JTextField("0",5);
        //textField.setLocation(10,10);
        //frame.add(textField);
        frame.add(textField, BorderLayout.NORTH);

        JRadioButton radioButton = new JRadioButton("prifd");
        frame.add(radioButton, BorderLayout.PAGE_END);
        JSpinner spinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "HH:mm:ss");
        spinner.setEditor(dateEditor);
        frame.add(spinner, BorderLayout.LINE_START);

        frame.setSize(500,500); //размеры формы
        frame.setVisible(true);



	// write your code here
    }
}
