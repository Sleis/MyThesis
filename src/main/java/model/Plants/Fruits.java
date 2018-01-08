/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Plants;

/**
 *
 * @author ivany
 */
public class Fruits extends Plants {

    private int lifetime;
    private String[][] diseaseAndProtection;

    public int getLifetime() {
        return lifetime;
    }

    public String[][] getDiseaseandprotection() {
        return diseaseAndProtection;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public void setDiseaseandprotection(String[][] diseaseAndProtection) {
        this.diseaseAndProtection = diseaseAndProtection;
    }

    public Fruits(int lifetime, String[][] diseaseAndProtection, Soils[] soil, PlantingAndPicking planting, String[] care, PlantingAndPicking picking, Produce produce) {
        super(soil, planting, care, picking, produce);
        this.lifetime = lifetime;
        this.diseaseAndProtection = diseaseAndProtection;
    }

}
