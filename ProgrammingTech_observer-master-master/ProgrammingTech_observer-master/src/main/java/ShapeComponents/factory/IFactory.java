package ShapeComponents.factory;

import ShapeComponents.Shape;

public interface IFactory {
    Shape createShape(String name);
}