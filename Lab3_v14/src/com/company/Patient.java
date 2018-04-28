package com.company;

/**
 * <h1>Patient extends Man</h1>
 * Класс-наследник от Man, который представляет пациента
 * @author Nikolai Dik
 * @version 1.2
 * @since 2-04-2018
 */

public class Patient extends Man {

    private String throatStatus = "Healthy";
    private String lungsStatus = "Healthy";
    private boolean IsHealthy = false;
    private Illness angina = null;
    private Illness flu = null;

    public Patient() {
    }

    public Patient(String name, int age) {
        super(name, age);
        this.angina = new Angina(this);
        this.flu = new Flu(this);
    }

    /**
     * <h1>Complain</h1>
     * Метод для жалобы пациента
     * @author Nikolai Dik
     * @version 1.2
     * @since 2-04-2018
     * @param doctor доктор, к которому обращается пациент
     */
    public void Complain(Doctor doctor){
        if (angina != null)
            doctor.Diagnose(this, angina.symptoms);
        if (flu != null)
            doctor.Diagnose(this, flu.symptoms);
    }

    public void DestroyIllness(Illness illness){
        if (illness.equals(angina)) {
            this.angina = null;
            throatStatus = "Healthy";
        }
        else if (illness.equals(flu)){
            this.flu = null;
            lungsStatus = "Healthy";
        }
    }

    public void TakeMedicine(Medicine medicine){
        if (angina != null && medicine.getSymptoms().equals(angina.getSymptoms())){
            DestroyIllness(angina);
        }
        else  if (flu != null && medicine.getSymptoms().equals(flu.getSymptoms())){
            lungsStatus = "Healthy";
            DestroyIllness(flu);
        }
        checkHealth();
    }

    public void checkHealth(){
        if (throatStatus.equals("Healthy") && lungsStatus.equals("Healthy"))
            IsHealthy = true;
        else IsHealthy = false;
    }

    public String getThroatStatus() {
        return throatStatus;
    }

    public String getLungsStatus() {
        return lungsStatus;
    }

    public Illness getAngina() {
        return angina;
    }

    public Illness getFlu() {
        return flu;
    }

    public String getIsHealthyStr() {
        if (IsHealthy)
            return "true";
        else return "false";
    }

    public boolean getIsHealthy() {
        return IsHealthy;
    }

    public void setThroatStatus(String throatStatus) {
        this.throatStatus = throatStatus;
    }

    public void setLungsStatus(String lungsStatus) {
        this.lungsStatus = lungsStatus;
    }

    public void setAngina(Angina angina) {
        this.angina = angina;
    }

    public void setFlu(Flu flu) {
        this.flu = flu;
    }
}

