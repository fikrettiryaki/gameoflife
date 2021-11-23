package gameoflife.options;

import gameoflife.display.Grid;

import java.util.List;

public interface OptionManager {
     String getMenuName();
     List<Option> getOptions();

     void executeAction(int value, Grid grid);
}
