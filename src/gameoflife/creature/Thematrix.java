package gameoflife.creature;

import gameoflife.strategy.Strategy;

public class Thematrix {

    int width;
    int height;

    private Cell[][] cells;
    Strategy strategy;

    public Thematrix(Strategy strategy, int width, int height) {
        this.strategy = strategy;
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
                strategy.iterateCell(cells, i, j);
            }
        }
        for(int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j].setWasAlive(cells[i][j].willBeAlive);
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

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
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
