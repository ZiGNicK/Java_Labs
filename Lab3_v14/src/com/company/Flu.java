package com.company;

/**
 * <h1>Flu</h1>
 * Класс-наследник от Illness, который представляет типичный грипп
 * @author Nikolai Dik
 * @version 1.2
 * @since 2-04-2018
 */

public class Flu extends Illness {

    public Flu(Patient patient) {
        symptoms = "flu";
        CauseCough(patient);
    }

    /**
     * <h1>CauseCough</h1>
     * Метод, благодаря которому грипп воздействует на легкие
     * @author Nikolai Dik
     * @version 1.2
     * @since 2-04-2018
     * @param patient пациент с этой болезнью
     */
    public void CauseCough(Patient patient){
        patient.setLungsStatus("INFECTED!");
    }
}
