package com.company;

/**
 * <h1>Doctor extends Man</h1>
 * Класс-наследник от Man, который описывает доктора
 * @author Nikolai Dik
 * @version 1.2
 * @since 2-04-2018
 */

public class Doctor extends Man{

    private Medicine medicine;

    public Doctor(String name, int age, String specialty) {
        super(name, age);
        this.medicine = new Medicine(specialty);
    }

    /**
     * <h1>Diagnose</h1>
     * Метод, благодаря которому доктор диагностирует болезнь и начинает лечение пациента
     * @author Nikolai Dik
     * @version 1.2
     * @since 2-04-2018
     * @param patient больной пациент
     * @param symptoms симптомы пациента
     */
    public void Diagnose(Patient patient, String symptoms){
        if (symptoms.equals(medicine.getSymptoms()))
            Heal(patient);
    }

    public void Heal(Patient patient){
        patient.TakeMedicine(medicine);
    }
}
