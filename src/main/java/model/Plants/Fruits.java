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
    private Produce produce;

    public void setDiseaseAndProtection(String[][] diseaseAndProtection) {
        this.diseaseAndProtection = diseaseAndProtection;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    public String[][] getDiseaseAndProtection() {
        return diseaseAndProtection;
    }

    public Produce getProduce() {
        return produce;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }


    public Fruits(int lifetime, String[][] diseaseAndProtection, Soils[] soil, PlantingAndPicking planting, String[] care, PlantingAndPicking picking, Produce produce) {
        super(soil, planting, care, picking);
        this.lifetime = lifetime;
        this.diseaseAndProtection = diseaseAndProtection;
        this.produce = produce;
    }

}
