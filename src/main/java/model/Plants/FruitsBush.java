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
public class FruitsBush extends Fruits {

    private Area area;
    private String cultivationMethod;

    public Area getArea() {
        return area;
    }

    public String getCultivationMethod() {
        return cultivationMethod;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setCultivationMethod(String cultivationMethod) {
        this.cultivationMethod = cultivationMethod;
    }

    public FruitsBush(Area area, String cultivationMethod, int lifetime, String[][] diseaseAndProtection, Soils[] soil, PlantingAndPicking planting, String[] care, PlantingAndPicking picking, Produce produce) {
        super(lifetime, diseaseAndProtection, soil, planting, care, picking, produce);
        this.area = area;
        this.cultivationMethod = cultivationMethod;
    }

}
