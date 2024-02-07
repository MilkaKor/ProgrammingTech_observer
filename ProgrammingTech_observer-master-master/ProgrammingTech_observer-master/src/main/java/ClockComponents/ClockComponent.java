package ClockComponents;

import javafx.scene.text.Text;
import ObserverComponents.Observer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockComponent implements Observer {
    private final Text text = new Text();
    @Override
    public void update() {
        var dateFormat = new SimpleDateFormat("HH:mm:ss");
        var currentTime = dateFormat.format(new Date());
        text.setText(currentTime);
    }

    public Text getClock(){
        return this.text;
    }
}