package gameoflife.creature;

public class Cell {
    boolean isAlive;
    int toxicity;
    int age;
    boolean willBeAlive;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getToxicity() {
        return toxicity;
    }

    public void setToxicity(int toxicity) {
        this.toxicity = toxicity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWillBeAlive() {
        return willBeAlive;
    }

    public void setWillBeAlive(boolean willBeAlive) {
        if(willBeAlive == false && isAlive){
            toxicity++;
        }
        this.willBeAlive = willBeAlive;
    }
}
