package BuilderComponents;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import Model.Mem;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Builder implements IBuilder {
    private final String fileTopic = new File("src//main//resources//topic//").getAbsolutePath() + "\\";
    private final Mem meme = new Mem();
    private final Text text = new Text();
    private final List<String> jokes = List.of("-Почему карандаш всегда устал? \n" +
                    "-Потому что он весь день в остром состоянии!\n",
            "-Как называется боязнь сидеть на стуле?\n Седафобия.\n",
            "-Как зовут рыбу, которая любит петь?\n Караоке-филе.\n",
            "-Почему у лошадей\n такие длинные ноги? \n-Чтобы они могли\n быстрее бежать от своих проблем!\n",
            "-Что делает пчела, которая\n не любит работать?\n -Пчелится.",
            "-Как называется боязнь\n забыть свой пароль\n от социальной сети?\n -Фейсбуксиофобия."

    );
    private final List<Color> colors = List.of(Color.DEEPPINK,Color.PINK,Color.WHITE,Color.WHITE,Color.WHITE);
    @Override
    public void setImage() {
        Image image = new Image(Paths.get(fileTopic + new Random().nextInt(1,5)  + ".jpg").toUri().toString());
        this.meme.addImage(image);
    }

    @Override
    public void setText() {
        text.setText(jokes.get(new Random().nextInt(0, jokes.size())));
        this.meme.addText(text);
    }

    @Override
    public void setColor(){
        text.setFill(colors.get(new Random().nextInt(0,colors.size())));
    }

    @Override
    public void setDesign(){
        text.fontProperty().setValue(Font.font("Verdana", FontWeight.BOLD, 12));
    }

    @Override
    public Mem build() {
        return this.meme;
    }
}

