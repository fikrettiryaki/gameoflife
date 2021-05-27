package gameoflife.creature;

import gameoflife.strategy.Strategy;

public class Thematrix {

    int size;

    boolean[][] myworld;
    boolean[][] oldworld;
    Cell[][] cells;
    Strategy strategy;

    public Thematrix(Strategy strategy, int size) {
        this.strategy = strategy;
        this.size = size;
        this.myworld = new boolean[size][size];
        this.oldworld = new boolean[size][size];
        cells = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void iterate() {
        oldworld = myworld;
        boolean[][] newworld = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                strategy.iterateCell(cells, i, j);
                newworld[i][j] = cells[i][j].willBeAlive;
            }
        }
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j].setAlive(cells[i][j].willBeAlive);
            }
        }
        myworld = newworld;
    }

    public void clear() {
        this.myworld = new boolean[size][size];
        this.oldworld = new boolean[size][size];
    }

    public boolean[][] getMyworld() {
        return myworld;
    }


    public boolean[][] getOldworld() {
        return oldworld;
    }


    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
