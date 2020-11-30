package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root,800,500);
        stage.setScene(scene);
        stage.show();

        Button button = new Button("Browse");
        button.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null){
                Image image = new Image("file:" + file.getAbsolutePath());
                ImageView imageView = new ImageView(image);
                root.add(imageView,1,1);
            }
        });
        root.add(button,0,0);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
