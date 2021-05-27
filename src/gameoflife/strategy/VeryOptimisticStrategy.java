package gameoflife.strategy;

import gameoflife.creature.Cell;

public class VeryOptimisticStrategy implements Strategy {
    @Override
    public void iterateCell(Cell[][] cells, int i, int j) {
        int neighbourCount = countAliveNeighbours(cells, i, j);
        if(neighbourCount==3){
            cells[i][j].setAlive(true);
            return;
        }
        if(neighbourCount==2 && cells[i][j].isAlive()){
            return;
        }
        cells[i][j].setAlive(false);
    }
}
