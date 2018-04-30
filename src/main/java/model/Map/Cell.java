/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Map;

/**
 *
 * @author ivany
 */
public class Cell {

    private int ID;
    private CellType celltype;
    private boolean status;

    public Cell(CellType ct, boolean stat, int id) {
        celltype = ct;
        status = stat;
        ID = id;
    }

    public void setCell(CellType ct, boolean stat) {
        this.celltype = ct;
        this.status = stat;
    }

    public void setCell(CellType ct, boolean stat, int id) {
        this.celltype = ct;
        this.status = stat;
        this.ID = id;
    }

    public void setCelltype(CellType celltype) {
        this.celltype = celltype;
    }

    public CellType getCelltype() {
        return celltype;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public void setDefault() {
        this.celltype = CellType.DIRT;
        this.status = false;
        this.ID = 0;
    }

    public void setDefaultIfStatusZero() {
        if (this.status == false) {
            this.celltype = CellType.DIRT;
            this.ID = 0;
        }
    }

}
