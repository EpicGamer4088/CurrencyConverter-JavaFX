package com.currencycalc.currencycalculatorjavafx;

import com.currencycalc.currencycalculatorjavafx.model.CurrencyData;
import com.currencycalc.currencycalculatorjavafx.utils.ApiKeyManager;
import com.currencycalc.currencycalculatorjavafx.utils.ApiKeyWindow;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Handles communication with the FreeCurrencyAPI to retrieve real-time exchange rates.
 * This class manages the initialization and usage of the API key, as well as making HTTP requests to the API.
 *
 * @author Tim Platzer
 * @version 1.0.0
 */
public class CurrencyClient
{
    /**
     * The base URL for the FreeCurrencyAPI, including a placeholder for the API key.
     */
    private final String BASE_URL = "https://api.freecurrencyapi.com/v1/latest?apikey={{API_KEY}}";

    /**
     * The API key used to authenticate requests to the FreeCurrencyAPI.
     */
    private String apiKey;

    /**
     * Constructs a new {@code CurrencyClient} instance and initializes the API key.
     * If the API key is not found, the user is prompted to enter a new one.
     */
    public CurrencyClient()
    {
        setApiKey(initializeApiKey());
    }

    /**
     * Fetches the latest currency exchange data from the FreeCurrencyAPI.
     *
     * @return A {@link CurrencyData} object containing the exchange rates.
     * @throws IOException If an I/O error occurs during the HTTP request.
     * @throws InterruptedException If the request is interrupted.
     */
    public CurrencyData fetchCurrencyData() throws IOException, InterruptedException
    {
        Gson gson = new Gson();
        String rawJson = makeRequest();
        return gson.fromJson(rawJson, CurrencyData.class);
    }

    /**
     * Makes an HTTP GET request to the FreeCurrencyAPI and retrieves the response.
     *
     * @return The raw JSON response from the API as a string.
     * @throws IOException If an I/O error occurs during the request.
     * @throws InterruptedException If the request is interrupted.
     */
    private String makeRequest() throws IOException, InterruptedException
    {
        // Replace the placeholder in the base URL with the actual API key
        String requestUri = BASE_URL.replace("{{API_KEY}}", getApiKey());

        try (HttpClient httpClient = HttpClient.newHttpClient())
        {
            // Build and send the HTTP GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUri))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
    }

    /**
     * Initializes the API key. Attempts to load the API key from storage.
     * If the key is not found, prompts the user to enter a new one.
     *
     * @return The initialized API key.
     * @throws RuntimeException If no API key is provided or saving the key fails.
     */
    private String initializeApiKey()
    {
        String tempApiKey;

        try
        {
            // Attempt to load the API key from storage
            tempApiKey = ApiKeyManager.loadApiKey();
        } catch (IOException | ClassNotFoundException e)
        {
            // If loading fails, prompt the user to enter the API key
            tempApiKey = ApiKeyWindow.show();

            if (tempApiKey == null || tempApiKey.trim().isEmpty())
            {
                throw new RuntimeException("API key was not provided.");
            }

            // Save the new API key for future use
            try
            {
                ApiKeyManager.saveApiKey(tempApiKey);
            } catch (IOException ex)
            {
                throw new RuntimeException("Failed to save API key.", ex);
            }
        }

        return tempApiKey;
    }


    /**
     * Retrieves the current API key.
     *
     * @return The API key as a string.
     */
    public String getApiKey()
    {
        return apiKey;
    }

    /**
     * Sets the API key.
     *
     * @param apiKey The API key to set.
     */
    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }
}
