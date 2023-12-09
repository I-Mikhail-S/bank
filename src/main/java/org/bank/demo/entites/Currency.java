package org.bank.demo.entites;

/**
 * Валюты
 */
public enum Currency {
    SCOIN ("0"),
    RUB ("1"),
    USD ("2"),
    EUR ("3");

    private String title;

    Currency(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                '}';
    }
}
