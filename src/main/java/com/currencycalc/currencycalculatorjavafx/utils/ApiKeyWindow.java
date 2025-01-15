package com.currencycalc.currencycalculatorjavafx.utils;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Utility class for displaying a modal window where users can enter their API key.
 * This window is invoked when the API key is not available or needs to be set up.
 *
 * The modal ensures that the user cannot interact with other parts of the application
 * until the API key is provided and saved.
 *
 * @author Tim Platzer
 * @version 1.0.0
 */
public class ApiKeyWindow
{
    /**
     * Displays the modal window for entering the API key.
     * The window contains an input field, a "Save" button, and an instructional label.
     * The "Save" button is enabled only when the input field is not empty.
     *
     * @return The API key entered by the user, or {@code null} if no key was provided.
     */
    public static String show()
    {
        // Thread-safe reference to store the API key
        AtomicReference<String> apiKey = new AtomicReference<>();

        // Set up the stage (modal window)
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); // Block interaction with other windows
        window.setTitle("API Key Setup");

        // Create UI components
        Label instructionLabel = new Label("Please enter your API key:");
        TextField apiKeyField = new TextField();
        Button saveButton = new Button("Save");
        saveButton.setDisable(true); // Initially disabled

        // Disable focus traversal for better user experience
        instructionLabel.setFocusTraversable(false);
        apiKeyField.setFocusTraversable(false);
        saveButton.setFocusTraversable(false);

        // Enable the save button only when the input field is not empty
        apiKeyField.textProperty().addListener((observable, oldValue, newValue) ->
                saveButton.setDisable(newValue.trim().isEmpty()));

        // Save the API key and close the window when the save button is clicked
        saveButton.setOnAction(e ->
        {
            apiKey.set(apiKeyField.getText());
            window.close();
        });

        // Layout and styling
        VBox layout = new VBox(10, instructionLabel, apiKeyField, saveButton);
        layout.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(layout, 300, 150);
        window.setScene(scene);

        // Display the modal window and wait for it to close
        window.showAndWait();

        // Return the API key entered by the user
        return apiKey.get();
    }
}
