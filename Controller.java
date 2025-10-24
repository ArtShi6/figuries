package org.example.controller;

import org.example.model.Model;
import org.example.view.MyPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Controller {
    private Model model;
    private MyPanel view;
    private boolean isDrawing = false;

    public Controller(Model model, MyPanel view) {
        this.model = model;
        this.view = view;
        setupMouseListeners();
        view.setController(this);
    }

    private void setupMouseListeners() {
        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isDrawing = true;
                model.setStartPoint(e.getPoint());
               view.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (isDrawing) {
                    model.setEndPoint(e.getPoint());
                    isDrawing = false;
                    view.repaint();
                }
            }
        });

        view.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDrawing) {
                    model.setEndPoint(e.getPoint());
                   view.repaint();
                }
            }
        });
    }

    public Model getModel() {
        return model;
    }

    public void setRectangleMode() {
        model.setCurrentShapeType(Model.ShapeType.RECTANGLE);
        System.out.println("Квадрат");
        view.repaint();
    }

    public void setEllipseMode() {
        model.setCurrentShapeType(Model.ShapeType.ELLIPSE);
        System.out.println("Круг");
        view.repaint();
    }
}

