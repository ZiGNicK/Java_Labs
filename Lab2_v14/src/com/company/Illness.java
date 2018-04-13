package com.company;

/**
 * <h1>Illness</h1>
 * Класс, описывающий некоторую болезнь
 * @author Nikolai Dik
 * @version 1.0
 * @since 25-03-2018
 */

public class Illness
{
    private String symptoms;

    public Illness() {
    }

    public Illness(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
