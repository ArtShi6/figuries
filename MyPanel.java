package org.example.view;

import org.example.controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private Controller controller;

    public MyPanel() {
        setPreferredSize(new Dimension(500, 450));
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (controller != null && controller.getModel() != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLUE);
            g2.setStroke(new BasicStroke(2));

            // Рисуем только если есть фигура
            if (controller.getModel().hasShape()) {
                g2.draw(controller.getModel().getShape());
            }
        }
    }
}
