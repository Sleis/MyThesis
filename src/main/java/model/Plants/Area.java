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
public class Area {
    private int crownWidth;
    private int crownHigth;

    public int getCrownWidth() {
        return crownWidth;
    }

    public int getCrownHigth() {
        return crownHigth;
    }

    public void setCrownWidth(int crownWidth) {
        this.crownWidth = crownWidth;
    }

    public void setCrownHigth(int crownHigth) {
        this.crownHigth = crownHigth;
    }

    public Area(int crownWidth, int crownHigth) {
        this.crownWidth = crownWidth;
        this.crownHigth = crownHigth;
    }
    
    
}
