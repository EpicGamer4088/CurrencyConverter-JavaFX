package com.currencycalc.currencycalculatorjavafx.utils;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class ApiKeyWindow
{
    public static String show()
    {
        AtomicReference<String> apiKey = new AtomicReference<>();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("API Key Setup");

        Label instructionLabel = new Label("Please enter your API key:");
        TextField apiKeyField = new TextField();
        Button saveButton = new Button("Save");
        saveButton.setDisable(true);

        apiKeyField.textProperty().addListener((observable, oldValue, newValue) ->
                saveButton.setDisable(newValue.trim().isEmpty()));

        saveButton.setOnAction(e ->
        {
            apiKey.set(apiKeyField.getText());
            window.close();
        });

        VBox layout = new VBox(10, instructionLabel, apiKeyField, saveButton);
        layout.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(layout, 300, 150);
        window.setScene(scene);

        window.showAndWait();

        return apiKey.get();
    }
}
