package gameoflife.creature;

import gameoflife.options.Preferences;

public class Thematrix {

    int width;
    int height;

    public Cell[][] getCells() {
        return cells;
    }

    public void setFromOld(Cell[][] oldCells) {
        for(int i = 0; i<oldCells.length && i<cells.length; i++){
            for(int j = 0; j<cells[0].length && j<oldCells[0].length; j++){
                cells[i][j] = oldCells[i][j];
            }
        }
    }

    private Cell[][] cells;

    public Thematrix(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell();
            }
        }
    }



    public void iterate() {
        for(int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            cells[i][j].setWasAlive(cells[i][j].willBeAlive);
            cells[i][j].willBeAlive = false;
        }
    }
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Preferences.getPreferences().getStrategy().iterateCell(cells, i, j);
            }
        }

    }

    public void clear() {
        Cell [][] newCells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newCells[i][j] = new Cell();
            }
        }
        cells = newCells;

    }

    public boolean willBeDead(int x, int y) {
        return !cells[x][y].isWillBeAlive();
    }

    public boolean wasDead(int x, int y) {
        return !cells[x][y].isWasAlive();
    }

    public void setWasAlive(int x, int y, boolean selected) {
        cells[x][y].setWasAlive(selected);
    }
    public void setWillBeAlive(int x, int y, boolean selected) {
        cells[x][y].setWillBeAlive(selected);
    }
}
