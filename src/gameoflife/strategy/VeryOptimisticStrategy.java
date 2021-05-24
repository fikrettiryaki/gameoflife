package gameoflife.strategy;

public class VeryOptimisticStrategy implements Strategy {
    @Override
    public boolean shouldStayAlive(int neighbourCount) {
        return neighbourCount == 2 || neighbourCount == 3 || neighbourCount == 4;
    }

    @Override
    public boolean shouldBecomeAlive(int neighbourCount) {
        return neighbourCount == 3 || neighbourCount == 4;
    }
}
