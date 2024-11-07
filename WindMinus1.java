package Minys1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class WindMinus1 {

    public static int enteredNumber;

    public static void main(String[] args) {
        
        // Создаем основное окно
        JFrame frame = new JFrame("Minus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Создаем панель
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout()); // Устанавливаем FlowLayout для панели

        JLabel label = new JLabel("Добро пожаловать в игру 'спички.'", SwingConstants.CENTER);
        panel.add(label);

        JButton nextButton = new JButton("Далее");

        // Добавляем обработчик нажатия на кнопку
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Закрываем текущее окно
                frame.setVisible(false);

                // Открываем следующее окно
                openNextWindow();
            }
        });
        panel.add(nextButton); // Добавляем кнопку в панель
        frame.add(panel); // Добавляем панель в главное окно
        frame.setVisible(true); // Делаем окно видимым
    }

    private static void openNextWindow() {
        // Создаем следующее окно
        JFrame nextFrame = new JFrame("Next Window");
        nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextFrame.setSize(400, 200);
        JLabel label = new JLabel("Игра началась! Введите количество ходов!", SwingConstants.CENTER);
        nextFrame.add(label);
        // Создаем текстовое поле
        JTextField textField = new JTextField(20); // Указываем 20 символов шириной
        JPanel panel = new JPanel();
        panel.add(textField); // Добавляем текстовое поле в панель
        textField.setVisible(true);
        nextFrame.setVisible(true); // Делаем следующее окно видимым
        nextFrame.add(panel);
//        JButton recordButton = new JButton("Записать");
        JButton nextButton2 = new JButton("Далее");
        nextFrame.add(panel); // Добавляем панель в главное окно
        nextFrame.setVisible(true); // Делаем окно видимым

//        recordButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//            }
//        });
        nextButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enteredNumber = Integer.parseInt(textField.getText()); // Получаем текст из текстового поля
                // Закрываем текущее окно
                nextFrame.setVisible(false);
                // Открываем следующее окно
                openNextWindow2();
            }
        });
        panel.add(nextButton2); // Добавляем кнопку в панель
        nextFrame.add(panel); // Добавляем панель в главное окно
        nextFrame.setVisible(true); // Делаем окно видимым
    }

    public static void openNextWindow2() {

        JFrame nextFrame2 = new JFrame("Next Window 2");
        nextFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nextFrame2.setSize(400, 200);
        nextFrame2.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Ваш ход. Введите число от 1 до 3:");
        JTextField textField = new JTextField(5);
        JButton button = new JButton("Ввод");

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        nextFrame2.add(panel, BorderLayout.CENTER);

        Random random = new Random();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playerMove;
                try {
                    playerMove = Integer.parseInt(textField.getText());
                } catch (NumberFormatException ex) {
                    label.setText("Некорректный ввод. Введите число от 1 до 3:");
                    textField.setText("");
                    return;
                }

                if (playerMove < 1 || playerMove > 3) {
                    label.setText("Некорректный ввод. Введите число от 1 до 3:");
                    textField.setText("");
                    return;
                }

                enteredNumber -= playerMove;
                label.setText("Вы вычли " + playerMove + ". Оставшееся значение: " + enteredNumber);

                if (enteredNumber <= 1) {
                    label.setText("БОТ остался с 1. Вы выиграли!");
                    textField.setEnabled(false);
                    button.setEnabled(false);
                    return;
                }

                int botMove = random.nextInt(3) + 1;
                enteredNumber -= botMove;
                label.setText("Бот вычел " + botMove + ". Оставшееся значение: " + enteredNumber);

                if (enteredNumber <= 1) {
                    label.setText("Игрок остался с 1. БОТ выиграл!");
                    textField.setEnabled(false);
                    button.setEnabled(false);
                }

                textField.setText(""); // Очистка поля ввода
            }
        });

        // Создаем кнопку "Назад"
        JButton backButton = new JButton("Назад");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Закрываем текущее окно
                nextFrame2.setVisible(false);

                // Открываем следующее окно
                openNextWindow();
            }
        });

        // Создаем кнопку "Выход"
        JButton exitButton = new JButton("Выход");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Завершаем программу
                System.exit(0);
            }
        });


        panel2.add(backButton);
        panel2.add(exitButton);
        nextFrame2.add(panel2, BorderLayout.SOUTH);


        // Добавляем панель в окно
        nextFrame2.add(panel);

        nextFrame2.setVisible(true); // Делаем окно видимым
    }

}




