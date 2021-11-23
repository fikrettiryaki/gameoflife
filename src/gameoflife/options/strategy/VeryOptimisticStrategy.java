package gameoflife.options.strategy;

import gameoflife.creature.Cell;

public class VeryOptimisticStrategy implements Strategy {
    @Override
    public String getMenuName() {
        return "Fikrets game of shapes";
    }

    @Override
    public void iterateCell(Cell[][] cells, int i, int j) {
        int neighbourCount = countAliveNeighbours(cells, i, j);
        if(neighbourCount==1){
            cells[i][j].setWillBeAlive(true);
            return;
        }
        if(neighbourCount==2){
            cells[i][j].setWillBeAlive(cells[i][j].isWasAlive());
            return;
        }
        cells[i][j].setWillBeAlive(false);
    }
}
