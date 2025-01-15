package com.currencycalc.currencycalculatorjavafx;

import com.currencycalc.currencycalculatorjavafx.model.CurrencyData;
import com.currencycalc.currencycalculatorjavafx.model.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainController
{
    @FXML
    private Button convertButton;
    @FXML
    private ChoiceBox<String> targetCurrencyDropdown;
    @FXML
    private ChoiceBox<String> sourceCurrencyDropdown;
    @FXML
    private TextField amountInputField;
    @FXML
    private TextField convertedAmountField;
    private final CurrencyClient currencyClient = new CurrencyClient();

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

    public void convert() throws IOException, InterruptedException
    {
        String sourceCurrencyName = getSourceCurrencyDropdown().getSelectionModel().getSelectedItem();
        String targetCurrencyName = getTargetCurrencyDropdown().getSelectionModel().getSelectedItem();

        String sourceCurrency = getCurrencyCode(sourceCurrencyName);
        String targetCurrency = getCurrencyCode(targetCurrencyName);

        if (sourceCurrency == null || targetCurrency == null)
        {
            getConvertedAmountField().setText("Fehler: Währung nicht ausgewählt");
            return;
        }

        double sourceAmount = Double.parseDouble(getAmountInputField().getText().replace(',', '.'));
        CurrencyData currencyData = getCurrencyClient().fetchCurrencyData();
        Data data = currencyData.getData();

        Double sourceRate = getCurrencyRate(data, sourceCurrency);
        Double targetRate = getCurrencyRate(data, targetCurrency);

        if (sourceRate == null || targetRate == null)
        {
            getConvertedAmountField().setText("Fehler: Ungültige Währungsauswahl");
            return;
        }

        Double convertedAmount = (sourceAmount / sourceRate) * targetRate;
        getConvertedAmountField().setText(String.format("%.2f", convertedAmount));
    }


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

    private String getCurrencyCode(String currencyName)
    {
        return currencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(currencyName))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }


    public ChoiceBox<String> getTargetCurrencyDropdown()
    {
        return targetCurrencyDropdown;
    }

    public ChoiceBox<String> getSourceCurrencyDropdown()
    {
        return sourceCurrencyDropdown;
    }

    public TextField getAmountInputField()
    {
        return amountInputField;
    }

    public TextField getConvertedAmountField()
    {
        return convertedAmountField;
    }

    public CurrencyClient getCurrencyClient()
    {
        return currencyClient;
    }

    public Button getConvertButton()
    {
        return convertButton;
    }

    public Map<String, String> getCurrencyMap()
    {
        return currencyMap;
    }
}
