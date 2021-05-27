package gameoflife.strategy;

import gameoflife.creature.Cell;

import java.util.List;
import java.util.Random;

public class HungryBacteria implements Strategy {
    private int maxAge = 600;


    @Override
    public void iterateCell(Cell[][] cells, int i, int j) {
        if (!cells[i][j].isAlive()) {
            return;
        }

        if(cells[i][j].getToxicity() > 1) {

            Random rand = new Random();

            if( rand.nextInt(2000)<cells[i][j].getToxicity()){
                cells[i][j].setWillBeAlive(false);
                return;
            }
        }

        int neighbourCount = countAliveNeighbours(cells, i, j);

        if (neighbourCount < 3) {

            processLessNeighbour(cells, i, j);

        } else if (neighbourCount < 6) {
            processMidNeighbour(cells, i, j);
        } else {
            cells[i][j].setAge(cells[i][j].getAge() + neighbourCount);
        }


        cells[i][j].setWillBeAlive(cells[i][j].getAge() < maxAge);
    }

    private void processMidNeighbour(Cell[][] cells, int i, int j) {

        if(cells[i][j].getAge()<maxAge/5){
            cells[i][j].setAge(cells[i][j].getAge()+10);
            return;
        }
        if(cells[i][j].getAge()<maxAge/3){
            cells[i][j].setAge(cells[i][j].getAge()+maxAge/3);
            List<Cell> deads = getDeadCells(cells,i,j);
            if(deads.size()<=0){
                return;
            }
            Random rand = new Random();

            birth(deads.get(rand.nextInt(deads.size())));
            return;
        }
        cells[i][j].setAge(cells[i][j].getAge()+5);
    }

    void processLessNeighbour(Cell[][] cells, int i, int j){

        if(cells[i][j].getAge()<maxAge/5){
            cells[i][j].setAge(cells[i][j].getAge()+15);
            return;
        }
        if(cells[i][j].getAge()<maxAge/2){
            cells[i][j].setAge(cells[i][j].getAge()+maxAge/5);
            List<Cell> deads = getDeadCells(cells,i,j);
            if(deads.size()<=0){
                return;
            }
            Random rand = new Random();
            birth(deads.get(rand.nextInt(deads.size())));
            return;
        }
        cells[i][j].setAge(cells[i][j].getAge()+3);
    }

    private void birth(Cell c){
        c.setWillBeAlive(true);
        c.setAge(0);
    }




}
