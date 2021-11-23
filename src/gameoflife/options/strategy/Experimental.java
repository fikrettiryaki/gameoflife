package gameoflife.options.strategy;

import gameoflife.creature.Cell;

public class Experimental implements Strategy {

    @Override
    public String getMenuName() {
        return "Experimental bacteria";
    }

    @Override
    public void iterateCell(Cell[][] cells, int i, int j) {
        int neighbourCount = countAliveNeighbours(cells, i, j);
        if(neighbourCount==1 && !cells[i][j].isWasAlive()){
            cells[i][j].setWillBeAlive(true);
            return;
        }
        if(neighbourCount==2 && cells[i][j].isWasAlive()){
            cells[i][j].setWillBeAlive(true);
            return;
        }
        cells[i][j].setWillBeAlive(false);
    }

}
