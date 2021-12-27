package gameoflife.creature;

import gameoflife.options.Preferences;

public class Thematrix {

    private Cell[][] cells;

    public Thematrix() {
        cells = newCells();
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void updateSize() {

        Cell[][] newCells = newCells();

        for(int i = 0; i<newCells.length && i<cells.length; i++){
            for(int j = 0; j<cells[0].length && j<newCells[0].length; j++){
                newCells[i][j] = cells[i][j];
            }
        }
        cells = newCells;
    }

    public void iterate() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j].setWasAlive(cells[i][j].willBeAlive);
                cells[i][j].willBeAlive = false;
            }
        }
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                Preferences.getPreferences().getStrategy().iterateCell(cells, i, j);
            }
        }

    }

    public void clear() {
        cells = newCells();
    }

    private Cell[][] newCells(){
        Cell [][] newCells = new Cell[Preferences.getPreferences().getWidth()][Preferences.getPreferences().getHeight()];
        for (int i = 0; i < newCells.length; i++) {
            for (int j = 0; j < newCells[0].length; j++) {
                newCells[i][j] = new Cell();
            }
        }
        return newCells;
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
