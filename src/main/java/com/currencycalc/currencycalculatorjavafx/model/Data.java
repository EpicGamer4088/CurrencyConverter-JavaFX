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
    public Double getAud()
    {
        return aud;
    }

    /**
     * @param aud The exchange rate for Australian Dollar (AUD).
     */
    public void setAud(Double aud)
    {
        this.aud = aud;
    }

    /**
     * @return The exchange rate for Bulgarian Lev (BGN).
     */
    public Double getBgn()
    {
        return bgn;
    }

    /**
     * @param bgn The exchange rate for Bulgarian Lev (BGN).
     */
    public void setBgn(Double bgn)
    {
        this.bgn = bgn;
    }

    // Repeat similarly for all other fields...

    /**
     * @return The exchange rate for South African Rand (ZAR).
     */
    public Double getZar()
    {
        return zar;
    }

    /**
     * @param zar The exchange rate for South African Rand (ZAR).
     */
    public void setZar(Double zar)
    {
        this.zar = zar;
    }

    /**
     * Gets the exchange rate for the Brazilian Real (BRL).
     *
     * @return the exchange rate for BRL.
     */
    public Double getBrl()
    {
        return brl;
    }

    /**
     * Sets the exchange rate for the Brazilian Real (BRL).
     *
     * @param brl the exchange rate to set for BRL.
     */
    public void setBrl(Double brl)
    {
        this.brl = brl;
    }

    /**
     * Gets the exchange rate for the Canadian Dollar (CAD).
     *
     * @return the exchange rate for CAD.
     */
    public Double getCad()
    {
        return cad;
    }

    /**
     * Sets the exchange rate for the Canadian Dollar (CAD).
     *
     * @param cad the exchange rate to set for CAD.
     */
    public void setCad(Double cad)
    {
        this.cad = cad;
    }

    /**
     * Gets the exchange rate for the Swiss Franc (CHF).
     *
     * @return the exchange rate for CHF.
     */
    public Double getChf()
    {
        return chf;
    }

    /**
     * Sets the exchange rate for the Swiss Franc (CHF).
     *
     * @param chf the exchange rate to set for CHF.
     */
    public void setChf(Double chf)
    {
        this.chf = chf;
    }

    /**
     * Gets the exchange rate for the Chinese Yuan (CNY).
     *
     * @return the exchange rate for CNY.
     */
    public Double getCny()
    {
        return cny;
    }

    /**
     * Sets the exchange rate for the Chinese Yuan (CNY).
     *
     * @param cny the exchange rate to set for CNY.
     */
    public void setCny(Double cny)
    {
        this.cny = cny;
    }

    /**
     * Gets the exchange rate for the US Dollar (USD).
     *
     * @return the exchange rate for USD.
     */
    public Double getUsd()
    {
        return usd;
    }

    /**
     * Sets the exchange rate for the US Dollar (USD).
     *
     * @param usd the exchange rate to set for USD.
     */
    public void setUsd(Double usd)
    {
        this.usd = usd;
    }

    /**
     * Gets the exchange rate for the Turkish Lira (TRY).
     *
     * @return the exchange rate for TRY.
     */
    public Double get_try()
    {
        return _try;
    }

    /**
     * Sets the exchange rate for the Turkish Lira (TRY).
     *
     * @param _try the exchange rate to set for TRY.
     */
    public void set_try(Double _try)
    {
        this._try = _try;
    }

    /**
     * Gets the exchange rate for the Thai Baht (THB).
     *
     * @return the exchange rate for THB.
     */
    public Double getThb()
    {
        return thb;
    }

    /**
     * Sets the exchange rate for the Thai Baht (THB).
     *
     * @param thb the exchange rate to set for THB.
     */
    public void setThb(Double thb)
    {
        this.thb = thb;
    }

    /**
     * Gets the exchange rate for the Singapore Dollar (SGD).
     *
     * @return the exchange rate for SGD.
     */
    public Double getSgd()
    {
        return sgd;
    }

    /**
     * Sets the exchange rate for the Singapore Dollar (SGD).
     *
     * @param sgd the exchange rate to set for SGD.
     */
    public void setSgd(Double sgd)
    {
        this.sgd = sgd;
    }

    /**
     * Gets the exchange rate for the Swedish Krona (SEK).
     *
     * @return the exchange rate for SEK.
     */
    public Double getSek()
    {
        return sek;
    }

    /**
     * Sets the exchange rate for the Swedish Krona (SEK).
     *
     * @param sek the exchange rate to set for SEK.
     */
    public void setSek(Double sek)
    {
        this.sek = sek;
    }

    /**
     * Gets the exchange rate for the Russian Ruble (RUB).
     *
     * @return the exchange rate for RUB.
     */
    public Double getRub()
    {
        return rub;
    }

    /**
     * Sets the exchange rate for the Russian Ruble (RUB).
     *
     * @param rub the exchange rate to set for RUB.
     */
    public void setRub(Double rub)
    {
        this.rub = rub;
    }

    /**
     * Gets the exchange rate for the Romanian Leu (RON).
     *
     * @return the exchange rate for RON.
     */
    public Double getRon()
    {
        return ron;
    }

    /**
     * Sets the exchange rate for the Romanian Leu (RON).
     *
     * @param ron the exchange rate to set for RON.
     */
    public void setRon(Double ron)
    {
        this.ron = ron;
    }

    /**
     * Gets the exchange rate for the Polish Zloty (PLN).
     *
     * @return the exchange rate for PLN.
     */
    public Double getPln()
    {
        return pln;
    }

    /**
     * Sets the exchange rate for the Polish Zloty (PLN).
     *
     * @param pln the exchange rate to set for PLN.
     */
    public void setPln(Double pln)
    {
        this.pln = pln;
    }

    /**
     * Gets the exchange rate for the Philippine Peso (PHP).
     *
     * @return the exchange rate for PHP.
     */
    public Double getPhp()
    {
        return php;
    }

    /**
     * Sets the exchange rate for the Philippine Peso (PHP).
     *
     * @param php the exchange rate to set for PHP.
     */
    public void setPhp(Double php)
    {
        this.php = php;
    }

    /**
     * Gets the exchange rate for the New Zealand Dollar (NZD).
     *
     * @return the exchange rate for NZD.
     */
    public Double getNzd()
    {
        return nzd;
    }

    /**
     * Sets the exchange rate for the New Zealand Dollar (NZD).
     *
     * @param nzd the exchange rate to set for NZD.
     */
    public void setNzd(Double nzd)
    {
        this.nzd = nzd;
    }

    /**
     * Gets the exchange rate for the Norwegian Krone (NOK).
     *
     * @return the exchange rate for NOK.
     */
    public Double getNok()
    {
        return nok;
    }

    /**
     * Sets the exchange rate for the Norwegian Krone (NOK).
     *
     * @param nok the exchange rate to set for NOK.
     */
    public void setNok(Double nok)
    {
        this.nok = nok;
    }

    /**
     * Gets the exchange rate for the Malaysian Ringgit (MYR).
     *
     * @return the exchange rate for MYR.
     */
    public Double getMyr()
    {
        return myr;
    }

    /**
     * Sets the exchange rate for the Malaysian Ringgit (MYR).
     *
     * @param myr the exchange rate to set for MYR.
     */
    public void setMyr(Double myr)
    {
        this.myr = myr;
    }

    /**
     * Gets the exchange rate for the Mexican Peso (MXN).
     *
     * @return the exchange rate for MXN.
     */
    public Double getMxn()
    {
        return mxn;
    }

    /**
     * Sets the exchange rate for the Mexican Peso (MXN).
     *
     * @param mxn the exchange rate to set for MXN.
     */
    public void setMxn(Double mxn)
    {
        this.mxn = mxn;
    }

    /**
     * Gets the exchange rate for the South Korean Won (KRW).
     *
     * @return the exchange rate for KRW.
     */
    public Double getKrw()
    {
        return krw;
    }

    /**
     * Sets the exchange rate for the South Korean Won (KRW).
     *
     * @param krw the exchange rate to set for KRW.
     */
    public void setKrw(Double krw)
    {
        this.krw = krw;
    }

    /**
     * Gets the exchange rate for the Japanese Yen (JPY).
     *
     * @return the exchange rate for JPY.
     */
    public Double getJpy()
    {
        return jpy;
    }

    /**
     * Sets the exchange rate for the Japanese Yen (JPY).
     *
     * @param jpy the exchange rate to set for JPY.
     */
    public void setJpy(Double jpy)
    {
        this.jpy = jpy;
    }

    /**
     * Gets the exchange rate for the Icelandic Krona (ISK).
     *
     * @return the exchange rate for ISK.
     */
    public Double getIsk()
    {
        return isk;
    }

    /**
     * Sets the exchange rate for the Icelandic Krona (ISK).
     *
     * @param isk the exchange rate to set for ISK.
     */
    public void setIsk(Double isk)
    {
        this.isk = isk;
    }

    /**
     * Gets the exchange rate for the Indian Rupee (INR).
     *
     * @return the exchange rate for INR.
     */
    public Double getInr()
    {
        return inr;
    }

    /**
     * Sets the exchange rate for the Indian Rupee (INR).
     *
     * @param inr the exchange rate to set for INR.
     */
    public void setInr(Double inr)
    {
        this.inr = inr;
    }

    /**
     * Gets the exchange rate for the Israeli New Shekel (ILS).
     *
     * @return the exchange rate for ILS.
     */
    public Double getIls()
    {
        return ils;
    }

    /**
     * Sets the exchange rate for the Israeli New Shekel (ILS).
     *
     * @param ils the exchange rate to set for ILS.
     */
    public void setIls(Double ils)
    {
        this.ils = ils;
    }

    /**
     * Gets the exchange rate for the Indonesian Rupiah (IDR).
     *
     * @return the exchange rate for IDR.
     */
    public Double getIdr()
    {
        return idr;
    }

    /**
     * Sets the exchange rate for the Indonesian Rupiah (IDR).
     *
     * @param idr the exchange rate to set for IDR.
     */
    public void setIdr(Double idr)
    {
        this.idr = idr;
    }

    /**
     * Gets the exchange rate for the Hungarian Forint (HUF).
     *
     * @return the exchange rate for HUF.
     */
    public Double getHuf()
    {
        return huf;
    }

    /**
     * Sets the exchange rate for the Hungarian Forint (HUF).
     *
     * @param huf the exchange rate to set for HUF.
     */
    public void setHuf(Double huf)
    {
        this.huf = huf;
    }

    /**
     * Gets the exchange rate for the Croatian Kuna (HRK).
     *
     * @return the exchange rate for HRK.
     */
    public Double getHrk()
    {
        return hrk;
    }

    /**
     * Sets the exchange rate for the Croatian Kuna (HRK).
     *
     * @param hrk the exchange rate to set for HRK.
     */
    public void setHrk(Double hrk)
    {
        this.hrk = hrk;
    }

    /**
     * Gets the exchange rate for the Hong Kong Dollar (HKD).
     *
     * @return the exchange rate for HKD.
     */
    public Double getHkd()
    {
        return hkd;
    }

    /**
     * Sets the exchange rate for the Hong Kong Dollar (HKD).
     *
     * @param hkd the exchange rate to set for HKD.
     */
    public void setHkd(Double hkd)
    {
        this.hkd = hkd;
    }

    /**
     * Gets the exchange rate for the British Pound Sterling (GBP).
     *
     * @return the exchange rate for GBP.
     */
    public Double getGbp()
    {
        return gbp;
    }

    /**
     * Sets the exchange rate for the British Pound Sterling (GBP).
     *
     * @param gbp the exchange rate to set for GBP.
     */
    public void setGbp(Double gbp)
    {
        this.gbp = gbp;
    }

    /**
     * Gets the exchange rate for the Euro (EUR).
     *
     * @return the exchange rate for EUR.
     */
    public Double getEur()
    {
        return eur;
    }

    /**
     * Sets the exchange rate for the Euro (EUR).
     *
     * @param eur the exchange rate to set for EUR.
     */
    public void setEur(Double eur)
    {
        this.eur = eur;
    }

    /**
     * Gets the exchange rate for the Danish Krone (DKK).
     *
     * @return the exchange rate for DKK.
     */
    public Double getDkk()
    {
        return dkk;
    }

    /**
     * Sets the exchange rate for the Danish Krone (DKK).
     *
     * @param dkk the exchange rate to set for DKK.
     */
    public void setDkk(Double dkk)
    {
        this.dkk = dkk;
    }

    /**
     * Gets the exchange rate for the Czech Koruna (CZK).
     *
     * @return the exchange rate for CZK.
     */
    public Double getCzk()
    {
        return czk;
    }

    /**
     * Sets the exchange rate for the Czech Koruna (CZK).
     *
     * @param czk the exchange rate to set for CZK.
     */
    public void setCzk(Double czk)
    {
        this.czk = czk;
    }
}
