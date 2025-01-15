package com.currencycalc.currencycalculatorjavafx;

import com.currencycalc.currencycalculatorjavafx.model.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The controller class for the Currency Calculator JavaFX application.
 * This class manages user interactions, handles input validation, and processes
 * currency conversions using data fetched from the FreeCurrencyAPI.
 *
 * @author Tim Platzer
 * @version 1.0.0
 */
public class MainController
{
    /**
     * The button that triggers the currency conversion process.
     * When clicked, it validates the input, fetches exchange rates,
     * and displays the converted amount.
     */
    @FXML
    private Button convertButton;

    /**
     * The dropdown menu for selecting the target currency.
     * This allows users to choose the currency into which they want to convert the source amount.
     */
    @FXML
    private ChoiceBox<String> targetCurrencyDropdown;

    /**
     * The dropdown menu for selecting the source currency.
     * This allows users to choose the currency from which they want to convert the amount.
     */
    @FXML
    private ChoiceBox<String> sourceCurrencyDropdown;

    /**
     * The input field where the user enters the amount to be converted.
     * The value is validated to ensure it is a numeric input and supports both dots and commas
     * as decimal separators.
     */
    @FXML
    private TextField amountInputField;

    /**
     * The output field where the converted amount is displayed.
     * After the conversion process is completed, the result is formatted to two decimal places
     * and shown here.
     */
    @FXML
    private TextField convertedAmountField;

    /**
     * The {@link CurrencyClient} instance responsible for communicating with the FreeCurrencyAPI.
     * This client is used to fetch real-time exchange rate data.
     */
    private final CurrencyClient currencyClient = new CurrencyClient();

    /**
     * A map of currency codes to their corresponding full names.
     * This map is used to populate dropdown menus with user-friendly currency names
     * while maintaining the ability to work with currency codes internally.
     * <p>
     * Example:
     * <ul>
     *     <li>{@code "AUD"}: "Australian Dollar"</li>
     *     <li>{@code "EUR"}: "Euro"</li>
     *     <li>{@code "USD"}: "US Dollar"</li>
     * </ul>
     * </p>
     * <p>
     * The map is implemented as a {@link LinkedHashMap} to preserve the order of insertion.
     * </p>
     */
    private final Map<String, String> currencyMap = new LinkedHashMap<>()
    {{
        put("AUD", "Australian Dollar");
        put("BGN", "Bulgarian Lev");
        put("BRL", "Brazilian Real");
        put("CAD", "Canadian Dollar");
        put("CHF", "Swiss Franc");
        put("CNY", "Chinese Yuan");
        put("CZK", "Czech Koruna");
        put("DKK", "Danish Krone");
        put("EUR", "Euro");
        put("GBP", "British Pound Sterling");
        put("HKD", "Hong Kong Dollar");
        put("HRK", "Croatian Kuna");
        put("HUF", "Hungarian Forint");
        put("IDR", "Indonesian Rupiah");
        put("ILS", "Israeli New Shekel");
        put("INR", "Indian Rupee");
        put("ISK", "Icelandic Krona");
        put("JPY", "Japanese Yen");
        put("KRW", "South Korean Won");
        put("MXN", "Mexican Peso");
        put("MYR", "Malaysian Ringgit");
        put("NOK", "Norwegian Krone");
        put("NZD", "New Zealand Dollar");
        put("PHP", "Philippine Peso");
        put("PLN", "Polish Zloty");
        put("RON", "Romanian Leu");
        put("RUB", "Russian Ruble");
        put("SEK", "Swedish Krona");
        put("SGD", "Singapore Dollar");
        put("THB", "Thai Baht");
        put("TRY", "Turkish Lira");
        put("USD", "US Dollar");
        put("ZAR", "South African Rand");
    }};

    /**
     * Initializes the controller.
     * Populates the dropdown menus with currency names, sets up input validation,
     * and configures button states.
     */
    public void initialize()
    {
        getSourceCurrencyDropdown().getItems().addAll(getCurrencyMap().values());

        getTargetCurrencyDropdown().getItems().addAll(getCurrencyMap().values());

        getAmountInputField().textProperty().addListener((observable, oldValue, newValue) ->
        {
            String input = getAmountInputField().getText();
            getConvertButton().setDisable(input.isEmpty() || !input.matches("-?\\d+([.,]\\d+)?")
            );
        });
    }

    /**
     * Handles the conversion of the entered amount from the source currency to the target currency.
     *
     * @throws IOException If an error occurs during the API request.
     * @throws InterruptedException If the request is interrupted.
     */
    public void convert() throws IOException, InterruptedException
    {
        String sourceCurrencyName = getSourceCurrencyDropdown().getSelectionModel().getSelectedItem();
        String targetCurrencyName = getTargetCurrencyDropdown().getSelectionModel().getSelectedItem();

        // Get currency codes from names
        String sourceCurrency = getCurrencyCode(sourceCurrencyName);
        String targetCurrency = getCurrencyCode(targetCurrencyName);

        // Check if the currencies are valid
        if (sourceCurrency == null || targetCurrency == null)
        {
            getConvertedAmountField().setText("Fehler: Währung nicht ausgewählt");
            return;
        }

        // Parse and convert the entered amount
        double sourceAmount = Double.parseDouble(getAmountInputField().getText().replace(',', '.'));
        Data data = getCurrencyClient().fetchCurrencyData().getData();

        Double sourceRate = getCurrencyRate(data, sourceCurrency);
        Double targetRate = getCurrencyRate(data, targetCurrency);

        // Check if the rates are valid
        if (sourceRate == null || targetRate == null)
        {
            getConvertedAmountField().setText("Fehler: Ungültige Währungsauswahl");
            return;
        }

        // Perform the conversion
        Double convertedAmount = (sourceAmount / sourceRate) * targetRate;
        getConvertedAmountField().setText(String.format("%.2f", convertedAmount));
    }

    /**
     * Retrieves the exchange rate for a specific currency using reflection.
     *
     * @param data The {@link Data} object containing all exchange rates.
     * @param currency The currency code (e.g., "USD").
     * @return The exchange rate for the given currency, or {@code null} if not found.
     */
    private Double getCurrencyRate(Data data, String currency)
    {
        try
        {
            String methodName = "get" + currency.substring(0, 1).toUpperCase() + currency.substring(1).toLowerCase();
            return (Double) Data.class.getMethod(methodName).invoke(data);
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Retrieves the currency code (e.g., "USD") for a given currency name.
     *
     * @param currencyName The full name of the currency (e.g., "US Dollar").
     * @return The currency code, or {@code null} if not found.
     */
    private String getCurrencyCode(String currencyName)
    {
        return currencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(currencyName))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    // Getters for FXML elements and utility methods

    /**
     * Retrieves the target currency dropdown.
     *
     * @return The {@link ChoiceBox} for selecting the target currency.
     */
    public ChoiceBox<String> getTargetCurrencyDropdown()
    {
        return targetCurrencyDropdown;
    }

    /**
     * Retrieves the source currency dropdown.
     *
     * @return The {@link ChoiceBox} for selecting the source currency.
     */
    public ChoiceBox<String> getSourceCurrencyDropdown()
    {
        return sourceCurrencyDropdown;
    }

    /**
     * Retrieves the input field for the amount to be converted.
     *
     * @return The {@link TextField} for entering the amount.
     */
    public TextField getAmountInputField()
    {
        return amountInputField;
    }

    /**
     * Retrieves the output field for the converted amount.
     *
     * @return The {@link TextField} displaying the converted amount.
     */
    public TextField getConvertedAmountField()
    {
        return convertedAmountField;
    }

    /**
     * Retrieves the {@link CurrencyClient} for API communication.
     *
     * @return The {@link CurrencyClient} instance.
     */
    public CurrencyClient getCurrencyClient()
    {
        return currencyClient;
    }

    /**
     * Retrieves the convert button.
     *
     * @return The {@link Button} used to trigger the conversion.
     */
    public Button getConvertButton()
    {
        return convertButton;
    }

    /**
     * Retrieves the map of currency codes and names.
     *
     * @return A {@link Map} containing currency codes as keys and names as values.
     */
    public Map<String, String> getCurrencyMap()
    {
        return currencyMap;
    }
}
