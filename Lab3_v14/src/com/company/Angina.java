package com.company;

public class Angina extends Illness {

    public Angina(Patient patient) {
        symptoms = "angina";
        CauseSoreThroat(patient);
    }

    public void CauseSoreThroat(Patient patient){
        patient.setThroatStatus("INFECTED!");
    }
}
