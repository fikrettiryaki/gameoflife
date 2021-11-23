package gameoflife.options.color;

import gameoflife.display.Grid;
import gameoflife.options.Option;
import gameoflife.options.OptionManager;
import gameoflife.options.Preferences;

import java.util.Arrays;
import java.util.List;

public class ColorManager  implements OptionManager {

    List<Option> colors = Arrays.asList(

            new Color("MAGENTA", java.awt.Color.MAGENTA),
            new Color("ORANGE", java.awt.Color.ORANGE),
            new Color("GRAY", java.awt.Color.GRAY),
            new Color("YELLOW", java.awt.Color.YELLOW),
            new Color("GREEN", java.awt.Color.GREEN),
            new Color("BLUE", java.awt.Color.BLUE),
            new Color("WHITE", java.awt.Color.WHITE)
    );

    @Override
    public String getMenuName() {
        return "Color";
    }

    @Override
    public List<Option> getOptions() {
        return colors;
    }

    @Override
    public void executeAction(int value, Grid grid) {
        Preferences.getPreferences().setSelectedColor((Color)colors.get(value));
    }
    public static class Color implements Option {
        private final String name;
        private final java.awt.Color value;

        public Color(String name, java.awt.Color value){
            this.name = name;
            this.value = value;
        }

        @Override
        public String getMenuName() {
            return name;
        }

        public java.awt.Color getValue() {
            return value;
        }
    }
}
