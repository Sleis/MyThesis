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
public class TheMap {

    private Cell[][] cell;
    private final int[] rate = new int[2];
    private int[] area = new int[2];
    private int width;
    private int heigth;

    public TheMap() {
        rate[0] = 1;
        rate[1] = 1;
        area[0] = 1;
        area[1] = 1;
    }

    public Cell[][] getCell() {
        return cell;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public int getWidthRate() {
        return rate[0];
    }

    public int getHeigthRate() {
        return rate[1];
    }

    public int[] getArea() {
        return area;
    }

    public void setCell(Cell[][] c) {
        this.cell = c;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setWidthRate(int rate) {
        this.rate[0] = rate;
    }

    public void setHeightRate(int rate) {
        this.rate[1] = rate;
    }

    public void setArea(int[] area) {
        this.area = area;
    }

    public void setArea(int a, int b) {
        this.area[0] = a;
        this.area[1] = b;
    }

    public void setHeigth(int h) {
        this.heigth = h;
    }

    public int evenOrNotTheAreasValues() {
        if (this.getArea()[0] % 2 != 0) {
            if (this.getArea()[1] % 2 != 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (this.getArea()[1] % 2 != 0) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    public void ifBothEven(int x, int y, boolean status, CellType celltype) {
        for (int k = -1 * this.getArea()[0] / 2; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status);
                }
            }
        }
    }

    public void ifXisEvenAndYisAdd(int x, int y, boolean status, CellType celltype) {
        for (int k = -1 * this.getArea()[0] / 2; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2 + 1; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status);
                }
            }
        }
    }

    public void ifXisAddAndYisEven(int x, int y, boolean status, CellType celltype) {
        for (int k = -1 * this.getArea()[0] / 2 + 1; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status);
                }
            }
        }
    }

    public void ifBothAdd(int x, int y, boolean status, CellType celltype) {
        for (int k = -1 * this.getArea()[0] / 2 + 1; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2 + 1; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status);
                }
            }
        }
    }

    public void ifBothEven(int x, int y, boolean status, CellType celltype, int id) {
        for (int k = -1 * this.getArea()[0] / 2; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status, id);
                }
            }
        }
    }

    public void ifXisEvenAndYisAdd(int x, int y, boolean status, CellType celltype, int id) {
        for (int k = -1 * this.getArea()[0] / 2; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2 + 1; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status, id);
                }
            }
        }
    }

    public void ifXisAddAndYisEven(int x, int y, boolean status, CellType celltype, int id) {
        for (int k = -1 * this.getArea()[0] / 2 + 1; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status, id);
                }
            }
        }
    }

    public void ifBothAdd(int x, int y, boolean status, CellType celltype, int id) {
        for (int k = -1 * this.getArea()[0] / 2 + 1; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2 + 1; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == false)) {
                    this.getCell()[x + k][y + j].setCell(celltype, status, id);
                }
            }
        }
    }

    public void coloring(int x, int y, boolean status, CellType celltype) {
        switch (evenOrNotTheAreasValues()) {
            case 0:
                ifBothEven(x, y, status, celltype);
                break;
            case 1:
                ifXisEvenAndYisAdd(x, y, status, celltype);
                break;
            case 2:
                ifXisAddAndYisEven(x, y, status, celltype);
                break;
            case 3:
                ifBothAdd(x, y, status, celltype);
                break;
        }
    }

    public void coloring(int x, int y, boolean status, CellType celltype, int id) {
        switch (evenOrNotTheAreasValues()) {
            case 0:
                ifBothEven(x, y, status, celltype, id);
                break;
            case 1:
                ifXisEvenAndYisAdd(x, y, status, celltype, id);
                break;
            case 2:
                ifXisAddAndYisEven(x, y, status, celltype, id);
                break;
            case 3:
                ifBothAdd(x, y, status, celltype, id);
                break;
        }
    }

    public boolean doTheAreaGoOut(int x, int y) {
        return ((x * 2 + 3) <= this.getArea()[0]) || (((this.getWidth() - x - 1) * 2 + 2) <= this.getArea()[0]) || ((y * 2 + 3) <= this.getArea()[1]) || (((this.getWidth() - y - 1) * 2 + 2) <= this.getArea()[1]);
    }

    public boolean doOverlapOneAnother(int x, int y) {
        switch (evenOrNotTheAreasValues()) {
            case 0:
                return doOverlapOneAnotherifBothEven(x, y);
            case 1:
                return doOverlapOneAnotherifXisEvenAndYisAdd(x, y);
            case 2:
                return doOverlapOneAnotherifXisAddAndYisEven(x, y);
            case 3:
                return doOverlapOneAnotherifBothAdd(x, y);
        }

        return false;
    }

    public boolean doOverlapOneAnotherifBothEven(int x, int y) {
        for (int k = -1 * this.getArea()[0] / 2; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doOverlapOneAnotherifXisEvenAndYisAdd(int x, int y) {
        for (int k = -1 * this.getArea()[0] / 2; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2 + 1; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doOverlapOneAnotherifBothAdd(int x, int y) {
        for (int k = -1 * this.getArea()[0] / 2 + 1; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2 + 1; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doOverlapOneAnotherifXisAddAndYisEven(int x, int y) {
        for (int k = -1 * this.getArea()[0] / 2 + 1; k <= (this.getArea()[0] / 2); k++) {
            for (int j = -1 * this.getArea()[1] / 2; j <= (this.getArea()[1] / 2); j++) {
                if (((x + k) >= 0) && ((x + k) < this.getWidth()) && ((y + j) >= 0) && ((y + j) < this.getHeigth()) && (this.getCell()[x + k][y + j].getStatus() == true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void reset() {
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeigth(); j++) {
                this.getCell()[i][j].setDefaultIfStatusZero();
            }
        }
    }

    public void checkAll(int id) {
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeigth(); j++) {
                if (this.getCell()[i][j].getID() == id) {
                    this.getCell()[i][j].setDefault();
                }
            }
        }
    }
}
