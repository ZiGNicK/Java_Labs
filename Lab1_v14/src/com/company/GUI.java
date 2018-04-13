package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Класс, в котором содержатся все компоненты, нужные для интерфеса
 */

public class GUI extends JFrame
{
    /**
     * Здесь инициализированы все элементы для работы
     */
    private JLabel yearLabel = new JLabel("Год: ");
    private JTextField yearTextField = new JTextField("2018",7);
    private JLabel daysCountLabel = new JLabel("Количество дней: 365");
    private JButton calculateButton = new JButton("Проверить");
            //calculateButton.setPreferredSize(new Dimension(100, 20));
    private JLabel leapYearLabel = new JLabel("Високосный: Нет");


    /**
     * Конструктор, в котором задаются размеры окна, его центрирование по центру экрана, условие выхода.
     * Также инициализирован менеджер компоновки и в него добавлены и настроены элементы, объявленные ранее.
     * Настроена работа кнопки через событие е.
     */
    public GUI()
    {
        super("Is It a Leap Year?");
        this.setBounds(200, 200, 350, 120);
        this.setLocationRelativeTo(null);
        this.setResizable(false);  //запрещает равертывание формы
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridBagLayout());

        super.add(yearLabel, new GridBagConstraints(0,0,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10,20,2,2),0,0));
        super.add(yearTextField, new GridBagConstraints(1,0,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10,2,2,2),120,0));
        super.add(daysCountLabel, new GridBagConstraints(2,0,1,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(10,2,2,10),0,0));
        super.add(calculateButton, new GridBagConstraints(0,1,2,1,
                1,1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2,20,10,2),0,0));
        super.add(leapYearLabel, new GridBagConstraints(2,1,1,1,
                1,1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(2,2,17,10),0,0));
/*
        Container container = this.getContentPane();
        this.setLayout(null);

        yearLabel.setBounds(10, 5, 40, 20);
        container.add(yearLabel);
        yearTextField.setBounds(40, 5, 120, 20);
        container.add(yearTextField);
        daysCountLabel.setBounds(170, 5, 160, 20);
        container.add(daysCountLabel);

        calculateButton.setBounds(10, 30, 150, 20);
        container.add(calculateButton);
        leapYearLabel.setBounds(170, 30, 160, 20);
        container.add(leapYearLabel);
*/
        calculateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    if (Integer.parseInt(yearTextField.getText()) % 4 != 0) {
                        daysCountLabel.setText("Количество дней: 365");
                        leapYearLabel.setText("Високосный: Нет");
                    } else {
                        daysCountLabel.setText("Количество дней: 366");
                        leapYearLabel.setText("Високосный: Да");

                    }
                }
                catch (Exception el){
                JOptionPane.showMessageDialog(new JFrame(),"You've entered something WRONG",
                        "OH NO!!!!!!111!",
                    JOptionPane.WARNING_MESSAGE);
                yearTextField.setText("");
                }
            }
        });
    }
}
