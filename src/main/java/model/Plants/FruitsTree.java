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
public class FruitsTree extends Fruits {

    private Crowns crown;
    private Area crownArea;

    public Crowns getCrown() {
        return crown;
    }

    public Area getCrownArea() {
        return crownArea;
    }

    public void setCrown(Crowns crown) {
        this.crown = crown;
    }

    public void setCrownArea(Area crownArea) {
        this.crownArea = crownArea;
    }

    public FruitsTree(Crowns crown, Area crownArea, int lifetime, String[][] diseaseAndProtection, Soils[] soil, PlantingAndPicking planting, String[] care, PlantingAndPicking picking, Produce produce) {
        super(lifetime, diseaseAndProtection, soil, planting, care, picking, produce);
        this.crown = crown;
        this.crownArea = crownArea;
    }

}
