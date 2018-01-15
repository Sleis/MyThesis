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
public class IndustrialCrops extends Plants {

    private String[] forecropes;
    private int minRowSpacing;
    private int plantingDepth;

    public String[] getForecrope() {
        return forecropes;
    }

    public int getMinRowSpacing() {
        return minRowSpacing;
    }

    public int getPlantingDepth() {
        return plantingDepth;
    }

    public void setForecrope(String[] forecropes) {
        this.forecropes = forecropes;
    }

    public void setMinRowSpacing(int minRowSpacing) {
        this.minRowSpacing = minRowSpacing;
    }

    public void setPlantingDepth(int plantingDepth) {
        this.plantingDepth = plantingDepth;
    }

    public IndustrialCrops(String[] forecropes, int minRowSpacing, int plantingDepth, Soils[] soil, PlantingAndPicking planting, String[] care, PlantingAndPicking picking) {
        super(soil, planting, care, picking);
        this.forecropes = forecropes;
        this.minRowSpacing = minRowSpacing;
        this.plantingDepth = plantingDepth;
    }

}
