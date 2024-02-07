package com.example.programmingtech_observable;

import ClockComponents.ClockComponent;
import ImageComponent.ImagePane;
import ShapeComponents.ContextComponent.GraphicComponent;
import ShapeComponents.factory.IFactory;
import ShapeComponents.factory.ShapeFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import ObserverComponents.TimeServer;

import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    @FXML
    public StackPane ImagePane;
    @FXML
    public BorderPane TimerText;
    @FXML
    public BorderPane ShapePage;
    public Canvas Sheet;
    private GraphicsContext context;
    private TimeServer timeServer;
    private ClockComponent clockComponent;
    private ImageComponent.ImagePane imageComponentPane;
    private GraphicComponent graphicComponent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        context = this.Sheet.getGraphicsContext2D();
        timeServer = new TimeServer();
        imageComponentPane = new ImagePane();
        clockComponent = new ClockComponent();
        graphicComponent = new GraphicComponent(context);
        

        timeServer.attach(imageComponentPane);
        timeServer.attach(clockComponent);
        timeServer.attach(graphicComponent);

        this.TimerText.setCenter(clockComponent.getClock());
        this.ImagePane.getChildren().add(imageComponentPane.buildMeme());

    }
}