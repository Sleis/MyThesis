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

    private String name;
    private Soils[] soil;
    private Interval planting;
    private String[] care;
    private Interval picking;

    public Soils[] getSoil() {
        return soil;
    }

    public Interval getPlanting() {
        return planting;
    }

    public String[] getCare() {
        return care;
    }

    public Interval getPicking() {
        return picking;
    }

    public void setSoil(Soils[] soil) {
        this.soil = soil;
    }

    public void setPlanting(Interval planting) {
        this.planting = planting;
    }

    public void setCare(String[] care) {
        this.care = care;
    }

    public void setPicking(Interval picking) {
        this.picking = picking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public Plants(String name,Soils[] soil, Interval planting, String[] care, Interval picking) {
        super();
        this.name = name;
        this.soil = soil;
        this.planting = planting;
        this.care = care;
        this.picking = picking;
    }
    
    

}
