package com.company;

/**
 * <h1>Doctor</h1>
 * Класс, описывающий доктора, который и будет лечить пациентов.
 * Наследуется от "человек"
 * @author Nikolai Dik
 * @version 1.0
 * @since 25-03-2018
 */

public class Doctor extends Man
{
    public Doctor() {
    }

    public Doctor(String name, int age) {
        super(name, age);
    }

    public void Diagnose(Illness illness)
    {
        //illness.setSymptoms(symptoms);
        Heal(illness.getSymptoms());
    }

    private void Heal(String symptoms)
    {
        System.out.println("Congratulations! \nYou are healthy now!");
    }

}
