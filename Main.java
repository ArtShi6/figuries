package org.example;

import org.example.controller.Controller;
import org.example.model.Model;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        MyPanel panel = new MyPanel();
        Controller controller = new Controller(model, panel);

        MyFrame frame = new MyFrame(panel,controller);
    }
}