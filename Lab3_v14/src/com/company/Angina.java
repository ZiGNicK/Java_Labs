package com.company;

/**
 * <h1>Angina</h1>
 * Класс-наследник от Illness, который представляет типичную ангину
 * @author Nikolai Dik
 * @version 1.2
 * @since 2-04-2018
 */

public class Angina extends Illness {

    public Angina(Patient patient) {
        symptoms = "angina";
        CauseSoreThroat(patient);
    }

    /**
     * <h1>CauseSoreThroat</h1>
     * Метод, благодаря которому ангина воздействует на горло
     * @author Nikolai Dik
     * @version 1.2
     * @since 2-04-2018
     */
    public void CauseSoreThroat(Patient patient){
        patient.setThroatStatus("INFECTED!");
    }
}
