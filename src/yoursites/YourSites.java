/*
 * This is a simple program i created. I got tired of looking through my bookmarks
 * in my broswer and wanted to see if I could create an app to have easier access
 * to websites.
 * The fxml file was created with SceneBuilder
 *
 */
package yoursites;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class YourSites extends Application {

    @Override
 public void start(Stage stage) throws Exception {
// Load the FXML file.
    Parent parent = FXMLLoader.load(
            getClass().getResource("YourSites.fxml"));

// Build the scene graph.
    Scene scene = new Scene(parent);

// Display our window, using the scene graph.
    stage.setTitle("");
    stage.setScene(scene);
    stage.show();
 }
    public static void main(String[] args) {
// Launch the application.
        launch(args);
    }
    
}
