package com.example.programmingtech_observable;

import ClockComponents.ClockComponent;
import ImageComponent.ImagePane;
import PlayerComponents.PlayerComponent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import ObserverComponents.TimeServer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    @FXML
    public StackPane ImagePane;
    @FXML
    public BorderPane TimerText;
    @FXML
    public BorderPane MediaPage;
    private TimeServer timeServer;
    private ClockComponent clockComponent;
    private ImageComponent.ImagePane imageComponentPane;
    private PlayerComponent mediaPlayerComponent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeServer = new TimeServer();
        imageComponentPane = new ImagePane();
        clockComponent = new ClockComponent();

        timeServer.attach(imageComponentPane);
        timeServer.attach(clockComponent);

        this.TimerText.setCenter(clockComponent.getClock());
        this.ImagePane.getChildren().add(imageComponentPane.buildMeme());

    }
}