package org.bank.demo.servises.Currency;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValCurs {
    @JsonProperty("Date")
    private String date;

    @JsonProperty("Valute")
    private List<Valute> valutes;
    @JsonGetter("Date")
    public String getDate() {
        return date;
    }
    @JsonSetter("Date")
    public void setDate(String date) {
        this.date = date;
    }
    @JsonGetter("Valute")
    public List<Valute> getValutes() {
        return valutes;
    }
    @JsonSetter("Valute")
    public void setValutes(List<Valute> valutes) {
        this.valutes = valutes;
    }

    public ValCurs(String date, List<Valute> valutes) {
        this.date = date;
        this.valutes = valutes;
    }

    public ValCurs() {
    }
}
