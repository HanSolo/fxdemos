package eu.hansolo.fxdemos;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Gauge.SkinType;
import eu.hansolo.medusa.GaugeBuilder;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {
    private static final Random         RND = new Random();
    private              Gauge          gauge;
    private              long           lastTimerCall;
    private              AnimationTimer timer;


    @Override public void init() {
        gauge = GaugeBuilder.create()
                            .skinType(SkinType.GAUGE)
                            .minValue(0)
                            .maxValue(100)
                            .animated(true)
                            .lcdVisible(true)
                            .build();

        lastTimerCall = System.nanoTime();
        timer = new AnimationTimer() {
            @Override public void handle(final long now) {
                if (now > lastTimerCall + 1_000_000_000) {
                    gauge.setValue(RND.nextDouble() * (gauge.getMaxValue() - gauge.getMinValue()));
                    lastTimerCall = now;
                }
            }
        };
    }

    @Override public void start(final Stage stage) {
        StackPane pane = new StackPane(gauge);

        Scene scene = new Scene(pane);

        stage.setTitle("FX Demos");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();

        timer.start();
    }

    @Override public void stop() {
        // Remove event handlers

        // Shutdown
        Platform.exit();
        System.exit(0);
    }


    // ******************** Launching *******************************
    public static void main(final String[] args) {
        launch(args);
    }
}