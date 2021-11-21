package gameoflife.strategy;

import gameoflife.creature.Cell;

public class OptimisticStrategy implements Strategy {

    @Override
    public String getMenuTitle() {
        return "Sticky bacteria";
    }

    @Override
    public void iterateCell(Cell[][] cells, int i, int j) {
        int neighbourCount = countAliveNeighbours(cells, i, j);
        if(neighbourCount==2 || neighbourCount==1){
            cells[i][j].setWillBeAlive(true);
            return;
        }
        if(neighbourCount==3 && cells[i][j].isWasAlive()){
            return;
        }
        cells[i][j].setWasAlive(false);
    }
}
