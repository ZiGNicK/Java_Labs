package com.company;

/**
 * <h1>Medicine</h1>
 * Класс, который описывает лекарство
 * @author Nikolai Dik
 * @version 1.2
 * @since 2-04-2018
 */

public class Medicine {
    private String symptoms;

    public Medicine(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getSymptoms() {
        return symptoms;
    }
}
