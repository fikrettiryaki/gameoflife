package gameoflife.creature;

public class Cell {
    boolean wasAlive;
    int toxicity;
    int age;
    boolean willBeAlive;

    public boolean isWasAlive() {
        return wasAlive;
    }

    public void setWasAlive(boolean wasAlive) {
        this.wasAlive = wasAlive;
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
        this.willBeAlive = willBeAlive;
    }
}
