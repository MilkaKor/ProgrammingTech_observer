package ImageComponent;

import BuilderComponents.Builder;
import BuilderComponents.Director;
import javafx.animation.FadeTransition;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import Model.Mem;
import ObserverComponents.Observer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ImagePane implements Observer {
    private Director memeDirector;
    private final Builder memeBuilder;
    private Mem meme;
    private final FadeTransition fade = new FadeTransition();

    public ImagePane(){
        memeBuilder = new Builder();
        memeDirector = new Director();
        meme = memeDirector.Construct(memeBuilder);
        fade.setNode(this.meme.getPanel());
        fade.setCycleCount(1000);
    }

    public StackPane buildMeme(){
        return meme.getPanel();
    }
    @Override
    public void update() {
        var dateFormat = new SimpleDateFormat("HH:mm:ss");
        if (dateFormat.getCalendar().get(Calendar.SECOND) % 5 == 0){
            fade.setDuration(new Duration(1200));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.play();
            this.meme = new Director().Construct(memeBuilder);
        }
        else{
            fade.stop();
        }
    }
}

