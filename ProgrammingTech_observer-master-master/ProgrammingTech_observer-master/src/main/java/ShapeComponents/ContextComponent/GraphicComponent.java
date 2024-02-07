package ShapeComponents.ContextComponent;

import ObserverComponents.Observer;
import ShapeComponents.factory.IFactory;
import ShapeComponents.factory.ShapeFactory;
import javafx.scene.canvas.GraphicsContext;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class GraphicComponent implements Observer {
    private IFactory factory;
    private GraphicsContext context;
    private List<String> shapes = List.of("Круг","Квадрат");
    public GraphicComponent(GraphicsContext context){
        this.context = context;
        factory = new ShapeFactory();
    }

    @Override
    public void update() {
        var dateFormat = new SimpleDateFormat("HH:mm:ss");
        if (dateFormat.getCalendar().get(Calendar.SECOND) % 3 == 0){
            var shape = factory.createShape(shapes.get(new Random().nextInt(0,2)));
            var x = new Random().nextInt(1, (int) this.context.getCanvas().getHeight());
            var y = new Random().nextInt(1, (int) this.context.getCanvas().getWidth());
            shape.setXY(x,y);
            shape.draw(this.context);
        }
    }
}
