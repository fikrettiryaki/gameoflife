package gameoflife.options.strategy;

import gameoflife.display.Grid;
import gameoflife.options.Option;
import gameoflife.options.OptionManager;
import gameoflife.options.Preferences;

import java.util.Arrays;
import java.util.List;

public class StrategyManager implements OptionManager {
    private List<Option> strategies = Arrays.asList(new Experimental(), new Conways(), new HungryBacteria(), new InterestingStrategy(), new OptimisticStrategy(), new VeryOptimisticStrategy());

    @Override
    public String getMenuName() {
        return "Strategy";
    }

    @Override
    public List<Option> getOptions() {
        return strategies;
    }

    @Override
    public void executeAction(int value, Grid grid) {
        Preferences.getPreferences().setSelectedStrategy((Strategy) this.strategies.get(value));

    }
}


