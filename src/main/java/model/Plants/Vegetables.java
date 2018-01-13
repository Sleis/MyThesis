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
public class Vegetables extends Plants {

    private Needs heatNeed;
    private Needs waterNeed;
    private Needs lightNeed;
    private String[] forecrops;
    private int minRowSpacing;
    private Produce produce;

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    public Produce getProduce() {
        return produce;
    }

    public Needs getHeatNeed() {
        return heatNeed;
    }

    public Needs getWaterNeed() {
        return waterNeed;
    }

    public Needs getLightNeed() {
        return lightNeed;
    }

    public String[] getForecrops() {
        return forecrops;
    }

    public int getMinRowSpacing() {
        return minRowSpacing;
    }

    public void setHeatNeed(Needs heatNeed) {
        this.heatNeed = heatNeed;
    }

    public void setWaterNeed(Needs waterNeed) {
        this.waterNeed = waterNeed;
    }

    public void setLightNeed(Needs lightNeed) {
        this.lightNeed = lightNeed;
    }

    public void setForecrops(String[] forecrops) {
        this.forecrops = forecrops;
    }

    public void setMinRowSpacing(int minRowSpacing) {
        this.minRowSpacing = minRowSpacing;
    }

    public Vegetables(Needs heatNeed, Needs waterNeed, Needs lightNeed, String[] forecrops, int minRowSpacing, Soils[] soil, PlantingAndPicking planting, String[] care, PlantingAndPicking picking, Produce produce) {
        super(soil, planting, care, picking);
        this.heatNeed = heatNeed;
        this.waterNeed = waterNeed;
        this.lightNeed = lightNeed;
        this.forecrops = forecrops;
        this.minRowSpacing = minRowSpacing;
        this.produce = produce;
    }

}
