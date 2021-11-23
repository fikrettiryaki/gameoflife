package gameoflife.options.strategy;

import gameoflife.creature.Cell;
import gameoflife.options.Option;

import java.util.ArrayList;
import java.util.List;

public interface Strategy extends Option {

    void iterateCell(Cell[][] cells, int i, int j);

    default int countAliveNeighbours(Cell[][] cells, int i, int j){
        int neighbour=0;

        if(cells[getX(cells,i-1)][j].isWasAlive()){
            neighbour++;
        }
        if(cells[getX(cells, i-1)][getY(cells, j-1)].isWasAlive()){
            neighbour++;
        }
        if(cells[getX(cells, i-1)][getY(cells,j+1)].isWasAlive()){
            neighbour++;
        }
        if(cells[getX(cells, i+1)][j].isWasAlive()){
            neighbour++;
        }
        if(cells[getX(cells, i+1)][getY(cells,j-1)].isWasAlive()){
            neighbour++;
        }
        if(cells[getX(cells, i+1)][getY(cells,j+1)].isWasAlive()){
            neighbour++;
        }
        if(cells[i][getY(cells, j-1)].isWasAlive()){
            neighbour++;
        }
        if(cells[i][getY(cells, j+1)].isWasAlive()){
            neighbour++;
        }

        return neighbour;
    }

    default int getY(Cell[][] cells, int i){
        return (cells[0].length + i )%cells[0].length;
    }

    default int getX(Cell[][] cells, int i) {
       return (cells.length + i )%cells.length;

    }

    default List<Cell> getDeadCells(Cell[][] cells, int i, int j){
        List<Cell> deadCells = new ArrayList<>();
        if(i>0 && !cells[i-1][j].isWasAlive()){
            deadCells.add(cells[i-1][j]);
        }
        if(i>0 && j>0 && !cells[i-1][j-1].isWasAlive()){
            deadCells.add(cells[i-1][j-1]);
        }
        if(i>0 && j<cells[i].length-1 && !cells[i-1][j+1].isWasAlive()){
            deadCells.add(cells[i-1][j+1]);
        }
        if(i<cells.length-1 && !cells[i+1][j].isWasAlive()){
            deadCells.add(cells[i+1][j]);
        }
        if(i<cells.length-1 && j>0 && !cells[i+1][j-1].isWasAlive()){
            deadCells.add(cells[i+1][j-1]);
        }
        if(i<cells.length-1 && j<cells[i].length-1 && !cells[i+1][j+1].isWasAlive()){
            deadCells.add(cells[i+1][j+1]);
        }
        if(j>0 && !cells[i][j-1].isWasAlive()){
            deadCells.add(cells[i][j-1]);
        }
        if(j<cells[i].length-1 && !cells[i][j+1].isWasAlive()){
            deadCells.add(cells[i][j+1]);
        }

        return deadCells;
    }
}
