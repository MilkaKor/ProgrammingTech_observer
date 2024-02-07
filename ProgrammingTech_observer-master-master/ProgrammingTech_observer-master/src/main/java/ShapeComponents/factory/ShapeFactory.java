package ShapeComponents.factory;

import ShapeComponents.Circle;
import ShapeComponents.Shape;
import ShapeComponents.Square;

public class ShapeFactory implements IFactory{
    @Override
    public Shape createShape(String name) {
        return switch (name) {
            case "Круг" -> new Circle();
            case "Квадрат" -> new Square();
            default -> null;
        };
    }
}