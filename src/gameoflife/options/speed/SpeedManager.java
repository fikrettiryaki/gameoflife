package gameoflife.options.speed;

import gameoflife.display.Grid;
import gameoflife.options.Option;
import gameoflife.options.OptionManager;
import gameoflife.options.Preferences;

import java.util.Arrays;
import java.util.List;

public class SpeedManager  implements OptionManager {

    List<Option> speeds = Arrays.asList(new Speed("Paused", 0),
            new Speed("1", 1),
            new Speed("3", 3),
            new Speed("10", 10),
            new Speed("50", 50),
            new Speed("1000", 1000)
            );

    @Override
    public String getMenuName() {
        return "Speed";
    }

    @Override
    public List<Option> getOptions() {
        return speeds;
    }

    @Override
    public void executeAction(int value, Grid grid) {
        Preferences.getPreferences().setSelectedSpeed((Speed)speeds.get(value));
    }


    public static class Speed implements Option {
        private final String name;
        private final int value;

        public Speed(String name, int value){
            this.name = name;
            this.value = value;
        }

        @Override
        public String getMenuName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
