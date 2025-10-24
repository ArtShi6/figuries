package org.example.view;

import org.example.controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private MyPanel myPanel;
    private JButton rectangleButton;
    private JButton ellipseButton;

    public MyFrame(MyPanel myPanel, Controller controller) {
        this.myPanel = myPanel;
        initialize(controller);
    }

    private void initialize(Controller controller) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Создаем панель кнопок
        JPanel controlPanel = createControlPanel(controller);

        add(controlPanel, BorderLayout.NORTH);
        add(myPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createControlPanel(Controller controller) {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        rectangleButton = new JButton("Квадрат");
        ellipseButton = new JButton("Круг");

        // Настраиваем кнопки
        setupButton(rectangleButton);
        setupButton(ellipseButton);

        // Добавляем обработчики
        rectangleButton.addActionListener(e -> {
            controller.setRectangleMode();
        });

        ellipseButton.addActionListener(e -> {
            controller.setEllipseMode();
        });

        panel.add(rectangleButton);
        panel.add(ellipseButton);

        return panel;
    }

    private void setupButton(JButton button) {
        button.setPreferredSize(new Dimension(100, 30));
    }

}
