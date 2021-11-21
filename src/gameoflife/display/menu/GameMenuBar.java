package gameoflife.display.menu;

import gameoflife.display.Grid;

import javax.swing.*;

public class GameMenuBar extends JMenuBar {
    public GameMenuBar(Grid grid) {

        add(new SpeedMenu(grid));
        add(new ColorMenu(grid));
        add(new OptionsMenu(grid));
        add(new SizeMenu(grid));
    }
}
