package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Manager extends Application {
    public static final String TITLE = "F1 Manager";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/splash.fxml"));
        Scene scene = new Scene(root, 1200, 800);

        primaryStage.setTitle(TITLE);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setOnCloseRequest((arg) -> System.exit(0));

        File file = new File(System.getProperty("user.dir") + "/src/main/resources/media/sound/backgroundmusic.wav");
        AudioInputStream sound = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();
        //clip.open(sound);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        //clip.start();

        primaryStage.show();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/views/load-game.fxml"));
                    Stage stage = (Stage) scene.getWindow();
                    stage.getScene().setRoot(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
