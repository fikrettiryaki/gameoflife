package gameoflife.creature;

import gameoflife.strategy.Strategy;

public class Thematrix {

    int size;

    boolean[][] myworld;
    boolean[][] oldworld;
    Strategy strategy;

    public Thematrix(Strategy strategy, int size) {
        this.strategy = strategy;
        this.size = size;
        this.myworld = new boolean[size][size];
        this.oldworld = new boolean[size][size];
    }

    public void iterate() {
        oldworld = myworld;
        boolean[][] newworld = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j<size; j++) {
                int neighbours = countAliveInfinite(i,j);
                if(myworld[i][j] && strategy.shouldStayAlive(neighbours) ){
                    newworld[i][j] = true;
                }
                if(!myworld[i][j] &&  strategy.shouldBecomeAlive(neighbours)){
                    newworld[i][j] = true;
                }
            }
        }
        myworld = newworld;
    }


    public int countAlive(int i, int j){
        int neighbour=0;
        if(i>0 && myworld[i-1][j]){
            neighbour++;
        }
        if(i>0 && j>0 && myworld[i-1][j-1]){
            neighbour++;
        }
        if(i>0 && j<size-1 && myworld[i-1][j+1]){
            neighbour++;
        }
        if(j>0 && myworld[i][j-1]){
            neighbour++;
        }
        if(j<size-1 && myworld[i][j+1]){
            neighbour++;
        }
        if(i<size-1 && myworld[i+1][j]){
            neighbour++;
        }
        if(i<size-1 && j>0 && myworld[i+1][j-1]){
            neighbour++;
        }
        if(i<size-1 && j<size-1 && myworld[i+1][j+1]){
            neighbour++;
        }
        return neighbour;
    }

    public int countAliveInfinite(int i, int j){
        int neighbour=0;
        if(myworld[(i-1 + size)%size][j]){
            neighbour++;
        }
        if( myworld[(i-1+ size)%size][(j-1+ size)%size]){
            neighbour++;
        }
        if(myworld[(i-1+ size)%size][(j+1)%size]){
            neighbour++;
        }
        if(myworld[i][(j-1+ size)%size]){
            neighbour++;
        }
        if(myworld[i][(j+1)%size]){
            neighbour++;
        }
        if(myworld[(i+1)%size][j]){
            neighbour++;
        }
        if(myworld[(i+1)%size][(j-1+ size)%size]){
            neighbour++;
        }
        if(myworld[(i+1)%size][(j+1)%size]){
            neighbour++;
        }
        return neighbour;
    }


    public void clear() {
        this.myworld = new boolean[size][size];
        this.oldworld = new boolean[size][size];
    }

    public boolean[][] getMyworld() {
        return myworld;
    }

    public void setMyworld(boolean[][] myworld) {
        this.myworld = myworld;
    }

    public boolean[][] getOldworld() {
        return oldworld;
    }

    public void setOldworld(boolean[][] oldworld) {
        this.oldworld = oldworld;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
