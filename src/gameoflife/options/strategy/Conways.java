package gameoflife.options.strategy;

import gameoflife.creature.Cell;
import gameoflife.options.Option;

public class Conways implements Strategy, Option {

    @Override
    public String getMenuName() {
        return "Conways Game Of Life";
    }

    @Override
    public void iterateCell(Cell[][] cells, int i, int j) {
        int neighbourCount = countAliveNeighbours(cells, i, j);
        if(neighbourCount==3){
            cells[i][j].setWillBeAlive(true);
            return;
        }
        if(neighbourCount==2 && cells[i][j].isWasAlive()){
            cells[i][j].setWillBeAlive(cells[i][j].isWasAlive());
            return;
        }
        cells[i][j].setWillBeAlive(false);
    }

}
