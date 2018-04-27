package com.company;

/**
 * <h1>Patient</h1>
 * Класс, описывающий пациента, который прищел с какой-то болезнью и может жаловаться на свое состояние здоровья
 * @author Nikolai Dik
 * @version 1.0
 * @since 25-03-2018
 */

public class Patient extends Man
{
    private Illness illness;
    private boolean isHealthy = false;

    public Patient() {
        illness = new Illness();
    }

    public Patient(String name, int age, String symptoms)
    {
        super(name, age);
        illness = new Illness(symptoms);
    }

    /**
     * <h1>Complain</h1>
     * Метод, созданный для реализации жалобы пациента
     * @author Nikolai Dik
     * @version 1.0
     * @since 25-03-2018
     * @param doctor доктор, который будет лечить
     */
    public void Complain(Doctor doctor)
    {
        doctor.Diagnose(this.illness);
    }

    public Illness getIllness() {
        return illness;
    }

    public String getSymptoms() {
        return this.illness.getSymptoms();

    }

    public void setSymptoms(String symptoms) {
        this.illness.setSymptoms(symptoms);
    }

    public String getHealthyStr() {
        if (isHealthy)
            return "true";
        else return "false";
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }
}
