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

public class CurrencyClient
{
    private final String BASE_URL = "https://api.freecurrencyapi.com/v1/latest?apikey={{API_KEY}}";
    private String apiKey;

    public CurrencyClient()
    {
        setApiKey(initializeApiKey());
    }

    public CurrencyData fetchCurrencyData() throws IOException, InterruptedException
    {
        Gson gson = new Gson();
        String rawJson = makeRequest();
        return gson.fromJson(rawJson, CurrencyData.class);
    }

    private String makeRequest() throws IOException, InterruptedException
    {
        String requestUri = BASE_URL.replace("{{API_KEY}}", getApiKey());

        try (HttpClient httpClient = HttpClient.newHttpClient())
        {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUri))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
    }

    private String initializeApiKey()
    {
        String tempApiKey;

        try
        {
            tempApiKey = ApiKeyManager.loadApiKey();
        } catch (IOException | ClassNotFoundException e)
        {
            tempApiKey = ApiKeyWindow.show();

            if (tempApiKey == null || tempApiKey.trim().isEmpty())
            {
                throw new RuntimeException("API key was not provided.");
            }

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

    public String getApiKey()
    {
        return apiKey;
    }

    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }
}
