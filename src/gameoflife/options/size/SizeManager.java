package gameoflife.options.size;

import gameoflife.display.Grid;
import gameoflife.options.Option;
import gameoflife.options.OptionManager;
import gameoflife.options.Preferences;

import java.util.Arrays;
import java.util.List;

public class SizeManager  implements OptionManager {

    List<Option> sizes = Arrays.asList(
            new Size(10,20,20,"SQUARE S"),
            new Size(10,50,50,"SQUARE M"),
            new Size(5,100,100,"SQUARE L"),
            new Size(5,200,200,"SQUARE XL"),
            new Size(1,600,600,"SQUARE XXL"),
            new Size(1,1200,1200,"SQUARE XXXL"),
            new Size(10,40,20,"WIDE S"),
            new Size(10,100,50,"WIDE M"),
            new Size(5,200,100,"WIDE L"),
            new Size(5,400,200,"WIDE XL"),
            new Size(1,1200,600,"WIDE XXL"),
            new Size(1,2400,1200,"WIDE XXXL")
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
        Preferences.getPreferences().setSelectedSize((Size)sizes.get(value));
        grid.sizeChanged();
    }
    public static class Size implements Option {
        private final String name;
        private final int scale;
        private final int width;
        private final int height;


        public Size(int scale, int width, int height, String name) {
            this.name = name;
            this.scale = scale;
            this.width = width;
            this.height = height;
        }

        @Override
        public String getMenuName() {
            return name;
        }

        public int getScale() {
            return scale;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
