package gameoflife.strategy;

import gameoflife.creature.Cell;

import java.util.ArrayList;
import java.util.List;

public interface Strategy {
    void iterateCell(Cell[][] cells, int i, int j);

    default int countAliveNeighbours(Cell[][] cells, int i, int j){
        int neighbour=0;
        if(i>0 && cells[i-1][j].isAlive()){
            neighbour++;
        }
        if(i>0 && j>0 && cells[i-1][j-1].isAlive()){
            neighbour++;
        }
        if(i>0 && j<cells[i].length-1 && cells[i-1][j+1].isAlive()){
            neighbour++;
        }
        if(i<cells.length-1 && cells[i+1][j].isAlive()){
            neighbour++;
        }
        if(i<cells.length-1 && j>0 && cells[i+1][j-1].isAlive()){
            neighbour++;
        }
        if(i<cells.length-1 && j<cells[i].length-1 && cells[i+1][j+1].isAlive()){
            neighbour++;
        }
        if(j>0 && cells[i][j-1].isAlive()){
            neighbour++;
        }
        if(j<cells[i].length-1 && cells[i][j+1].isAlive()){
            neighbour++;
        }

        return neighbour;
    }

    default List<Cell> getDeadCells(Cell[][] cells, int i, int j){
        List<Cell> deadCells = new ArrayList<>();
        if(i>0 && !cells[i-1][j].isAlive()){
            deadCells.add(cells[i-1][j]);
        }
        if(i>0 && j>0 && !cells[i-1][j-1].isAlive()){
            deadCells.add(cells[i-1][j-1]);
        }
        if(i>0 && j<cells[i].length-1 && !cells[i-1][j+1].isAlive()){
            deadCells.add(cells[i-1][j+1]);
        }
        if(i<cells.length-1 && !cells[i+1][j].isAlive()){
            deadCells.add(cells[i+1][j]);
        }
        if(i<cells.length-1 && j>0 && !cells[i+1][j-1].isAlive()){
            deadCells.add(cells[i+1][j-1]);
        }
        if(i<cells.length-1 && j<cells[i].length-1 && !cells[i+1][j+1].isAlive()){
            deadCells.add(cells[i+1][j+1]);
        }
        if(j>0 && !cells[i][j-1].isAlive()){
            deadCells.add(cells[i][j-1]);
        }
        if(j<cells[i].length-1 && !cells[i][j+1].isAlive()){
            deadCells.add(cells[i][j+1]);
        }

        return deadCells;
    }
}
