package gameoflife.display.menu;

import gameoflife.display.Grid;
import gameoflife.options.OptionManager;

import javax.swing.*;
import java.util.List;

public class GameMenuBar extends JMenuBar {
    public GameMenuBar(Grid grid, List<OptionManager> optionManagers) {
        for(OptionManager optionManager : optionManagers ){
            add(new GameMenuOption(grid, optionManager));
        }
    }
}
