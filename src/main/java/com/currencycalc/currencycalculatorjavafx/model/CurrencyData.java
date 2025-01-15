package com.currencycalc.currencycalculatorjavafx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the root structure of the JSON response from the FreeCurrencyAPI.
 * <p>
 * This class encapsulates the exchange rate data within the "data" field of the JSON response.
 * It acts as a container for the {@link Data} object, which holds all individual currency rates.
 * </p>
 *
 * <p>Example JSON structure:</p>
 * <pre>
 * {
 *   "data": {
 *     "USD": 1.0,
 *     "EUR": 0.85,
 *     ...
 *   }
 * }
 * </pre>
 *
 * <p>Used in conjunction with Gson for JSON serialization and deserialization.</p>
 *
 * @author Tim
 * @version 1.0.0
 */
public class CurrencyData
{
    /**
     * The exchange rate data field containing the actual rates for various currencies.
     * <p>
     * This field is mapped to the "data" field in the JSON response using the {@link SerializedName} annotation.
     * </p>
     */
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * Retrieves the exchange rate data.
     *
     * @return The {@link Data} object containing exchange rates for various currencies.
     */
    public Data getData()
    {
        return data;
    }

    /**
     * Sets the exchange rate data.
     *
     * @param data The {@link Data} object containing exchange rates for various currencies.
     */
    public void setData(Data data)
    {
        this.data = data;
    }
}
