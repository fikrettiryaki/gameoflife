package gameoflife.strategy;

import gameoflife.creature.Cell;

public class Conways implements Strategy {

    @Override
    public void iterateCell(Cell[][] cells, int i, int j) {
        int neighbourCount = countAliveNeighbours(cells, i, j);
        if(neighbourCount==3){
            cells[i][j].setWillBeAlive(true);
            return;
        }
        if(neighbourCount==2 && cells[i][j].isAlive()){
            cells[i][j].setWillBeAlive(cells[i][j].isAlive());
            return;
        }
        cells[i][j].setWillBeAlive(false);
    }
}
