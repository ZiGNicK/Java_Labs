package com.company;

public class Doctor extends Man{

    private Medicine medicine;

    public Doctor(String name, int age, String specialty) {
        super(name, age);
        this.medicine = new Medicine(specialty);
    }

    public void Diagnose(Patient patient, String symptoms){
        if (symptoms.equals(medicine.getSymptoms()))
            Heal(patient);
    }

    public void Heal(Patient patient){
        patient.TakeMedicine(medicine);
    }
}
