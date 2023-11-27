package org.bank.demo.servises.Currency;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Valute {
    private String charCode;
    private String nominal;
    private String name;
    private String value;


    @JsonGetter("CharCode")
    public String getCharCode() {
        return charCode;
    }
    @JsonSetter("CharCode")
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }
    @JsonGetter("Nominal")
    public String getNominal() {
        return nominal;
    }
    @JsonSetter("Nominal")
    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
    @JsonGetter("Name")
    public String getName() {
        return name;
    }
    @JsonSetter("Name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonGetter("Value")
    public String getValue() {
        return value;
    }
    @JsonSetter("Value")
    public void setValue(String value) {
        this.value = value;
    }
    public Valute() {
    }
}

