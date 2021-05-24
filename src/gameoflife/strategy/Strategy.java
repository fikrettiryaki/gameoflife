package gameoflife.strategy;

public interface Strategy {

    boolean shouldStayAlive(int neighbourCount);
    boolean shouldBecomeAlive(int neighbourCount);
}
