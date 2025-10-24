package org.example.model;

import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Model {
    public enum ShapeType {
        RECTANGLE, ELLIPSE
    }

    private Point2D startPoint;
    private Point2D endPoint;
    private RectangularShape shape;
    private ShapeType currentShapeType;

    public Model() {
        this.currentShapeType = ShapeType.RECTANGLE;
        createShapeObject();
    }

    private void createShapeObject() {
        if (currentShapeType == ShapeType.RECTANGLE) {
            shape = new Rectangle2D.Double();
        } else {
            shape = new Ellipse2D.Double();
        }

        // Если есть точки, устанавливаем их в новую фигуру
        if (startPoint != null && endPoint != null) {
            shape.setFrameFromDiagonal(startPoint, endPoint);
        }
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
        this.endPoint = startPoint; // Инициализируем конечную точку
        if (shape != null) {
            shape.setFrameFromDiagonal(startPoint, startPoint);
        }
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
        if (startPoint != null && endPoint != null && shape != null) {
            shape.setFrameFromDiagonal(startPoint, endPoint);
        }
    }

    public RectangularShape getShape() {
        return shape;
    }

    public ShapeType getCurrentShapeType() {
        return currentShapeType;
    }

    public void setCurrentShapeType(ShapeType shapeType) {
        if (this.currentShapeType != shapeType) {
            this.currentShapeType = shapeType;
            createShapeObject();
        }
    }

    public boolean hasShape() {
        return startPoint != null && endPoint != null &&
                !startPoint.equals(endPoint);
    }
}
