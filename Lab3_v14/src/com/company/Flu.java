package com.company;

public class Flu extends Illness {

    public Flu(Patient patient) {
        symptoms = "flu";
        CauseCough(patient);
    }

    public void CauseCough(Patient patient){
        patient.setLungsStatus("INFECTED!");
    }
}
