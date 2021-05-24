package gameoflife.strategy;

public class PessimisticStrategy implements Strategy {
    @Override
    public boolean shouldStayAlive(int neighbourCount) {
        return neighbourCount == 2 ;
    }

    @Override
    public boolean shouldBecomeAlive(int neighbourCount) {
        return neighbourCount == 3 ;
    }
}
