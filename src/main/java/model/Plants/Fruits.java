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
    private Produce produce;


    public void setProduce(Produce produce) {
        this.produce = produce;
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


    public Fruits(String name, int lifetime, Soils[] soil, Interval planting, String[] care, Interval picking, Produce produce) {
        super(name, soil, planting, care, picking);
        this.lifetime = lifetime;
        this.produce = produce;
    }

}
