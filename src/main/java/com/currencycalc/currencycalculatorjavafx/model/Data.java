package com.currencycalc.currencycalculatorjavafx.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Represents the exchange rates data structure retrieved from the FreeCurrencyAPI.
 * <p>
 * Each field corresponds to a specific currency's exchange rate relative to a base currency
 * (typically USD). This class is annotated with Gson annotations for JSON serialization and deserialization.
 * </p>
 *
 * <p>Example JSON structure:</p>
 * <pre>
 * {
 *   "AUD": 1.615,
 *   "EUR": 0.841,
 *   ...
 * }
 * </pre>
 *
 * <p>Each currency is represented as a {@link Double} value.</p>
 *
 * @author Tim
 * @version 1.0.0
 */
public class Data
{
    @SerializedName("AUD")
    @Expose
    private Double aud;

    @SerializedName("BGN")
    @Expose
    private Double bgn;

    @SerializedName("BRL")
    @Expose
    private Double brl;

    @SerializedName("CAD")
    @Expose
    private Double cad;

    @SerializedName("CHF")
    @Expose
    private Double chf;

    @SerializedName("CNY")
    @Expose
    private Double cny;

    @SerializedName("CZK")
    @Expose
    private Double czk;

    @SerializedName("DKK")
    @Expose
    private Double dkk;

    @SerializedName("EUR")
    @Expose
    private Double eur;

    @SerializedName("GBP")
    @Expose
    private Double gbp;

    @SerializedName("HKD")
    @Expose
    private Double hkd;

    @SerializedName("HRK")
    @Expose
    private Double hrk;

    @SerializedName("HUF")
    @Expose
    private Double huf;

    @SerializedName("IDR")
    @Expose
    private Double idr;

    @SerializedName("ILS")
    @Expose
    private Double ils;

    @SerializedName("INR")
    @Expose
    private Double inr;

    @SerializedName("ISK")
    @Expose
    private Double isk;

    @SerializedName("JPY")
    @Expose
    private Double jpy;

    @SerializedName("KRW")
    @Expose
    private Double krw;

    @SerializedName("MXN")
    @Expose
    private Double mxn;

    @SerializedName("MYR")
    @Expose
    private Double myr;

    @SerializedName("NOK")
    @Expose
    private Double nok;

    @SerializedName("NZD")
    @Expose
    private Double nzd;

    @SerializedName("PHP")
    @Expose
    private Double php;

    @SerializedName("PLN")
    @Expose
    private Double pln;

    @SerializedName("RON")
    @Expose
    private Double ron;

    @SerializedName("RUB")
    @Expose
    private Double rub;

    @SerializedName("SEK")
    @Expose
    private Double sek;

    @SerializedName("SGD")
    @Expose
    private Double sgd;

    @SerializedName("THB")
    @Expose
    private Double thb;

    @SerializedName("TRY")
    @Expose
    private Double _try;

    @SerializedName("USD")
    @Expose
    private Double usd;

    @SerializedName("ZAR")
    @Expose
    private Double zar;

    // Getters and setters for each field with detailed descriptions.

    /**
     * @return The exchange rate for Australian Dollar (AUD).
     */
    public Double getAud() { return aud; }

    /**
     * @param aud The exchange rate for Australian Dollar (AUD).
     */
    public void setAud(Double aud) { this.aud = aud; }

    /**
     * @return The exchange rate for Bulgarian Lev (BGN).
     */
    public Double getBgn() { return bgn; }

    /**
     * @param bgn The exchange rate for Bulgarian Lev (BGN).
     */
    public void setBgn(Double bgn) { this.bgn = bgn; }

    // Repeat similarly for all other fields...

    /**
     * @return The exchange rate for South African Rand (ZAR).
     */
    public Double getZar() { return zar; }

    /**
     * @param zar The exchange rate for South African Rand (ZAR).
     */
    public void setZar(Double zar) { this.zar = zar; }
}
