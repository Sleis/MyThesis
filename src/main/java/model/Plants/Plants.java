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
public class Plants {

    private Soils[] soil;
    private PlantingAndPicking planting;
    private String[] care;
    private PlantingAndPicking picking;

    public Soils[] getSoil() {
        return soil;
    }

    public PlantingAndPicking getPlanting() {
        return planting;
    }

    public String[] getCare() {
        return care;
    }

    public PlantingAndPicking getPicking() {
        return picking;
    }

    public void setSoil(Soils[] soil) {
        this.soil = soil;
    }

    public void setPlanting(PlantingAndPicking planting) {
        this.planting = planting;
    }

    public void setCare(String[] care) {
        this.care = care;
    }

    public void setPicking(PlantingAndPicking picking) {
        this.picking = picking;
    }


    public Plants(Soils[] soil, PlantingAndPicking planting, String[] care, PlantingAndPicking picking) {
        super();
        this.soil = soil;
        this.planting = planting;
        this.care = care;
        this.picking = picking;
    }
    
    

}
