package gameoflife.strategy;

public class OptimisticStrategy implements Strategy {
    @Override
    public boolean shouldStayAlive(int neighbourCount) {
        return neighbourCount == 2 || neighbourCount == 3;
    }

    @Override
    public boolean shouldBecomeAlive(int neighbourCount) {
        return neighbourCount == 3 || neighbourCount == 4;
    }
}
