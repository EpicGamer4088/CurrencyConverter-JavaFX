package com.currencycalc.currencycalculatorjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The main application class for the Currency Calculator.
 * This class initializes and launches the JavaFX application.
 * It sets up the main stage, loads the FXML layout, and applies the application icon.
 *
 * @author Tim Platzer
 * @version 1.0.0
 */
public class App extends Application
{
    /**
     * The entry point of the JavaFX application.
     * This method is called automatically when the application is launched.
     * It sets up the main stage, loads the FXML layout, and applies a custom application icon.
     *
     * @param stage The primary stage for this application.
     * @throws IOException If the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Currency Converter");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResource("icon.png")).toExternalForm()));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method serves as the entry point to the Java application.
     * It launches the JavaFX application by calling the {@code launch()} method.
     *
     * @param args Command-line arguments passed to the application (not used).
     */
    public static void main(String[] args)
    {
        launch();
    }
}
