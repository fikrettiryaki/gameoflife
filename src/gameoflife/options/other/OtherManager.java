package gameoflife.options.other;

import gameoflife.display.Grid;
import gameoflife.options.Option;
import gameoflife.options.OptionManager;
import gameoflife.options.Preferences;

import java.util.Arrays;
import java.util.List;

public class OtherManager implements OptionManager {

    List<Option> sizes = Arrays.asList(
            new Other("Clear screen"),
            new Other("Transient Colors")
    );

    @Override
    public String getMenuName() {
        return "Screen Size";
    }

    @Override
    public List<Option> getOptions() {
        return sizes;
    }

    @Override
    public void executeAction(int value, Grid grid) {
        if(value == 0) {
            grid.clear();
        }
        if(value == 1) {
            Preferences.getPreferences().toggleTransient();
        }
    }
    private static class Other implements Option {
        private final String name;

        public Other(String name) {
            this.name = name;
        }

        @Override
        public String getMenuName() {
            return name;
        }
    }
}
