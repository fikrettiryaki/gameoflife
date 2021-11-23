package gameoflife.display;

import gameoflife.creature.Cell;
import gameoflife.display.menu.GameMenuBar;
import gameoflife.options.OptionManager;
import gameoflife.options.Preferences;
import gameoflife.options.color.ColorManager;
import gameoflife.options.size.SizeManager;
import gameoflife.options.other.OtherManager;
import gameoflife.options.speed.SpeedManager;
import gameoflife.options.strategy.StrategyManager;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Grid extends JFrame {
    private GameMenuBar mb;
    private GamePane gamePane;


    public Grid() throws HeadlessException {
        setPreferredSize(new Dimension(Preferences.getPreferences().getWidth() * Preferences.getPreferences().getScale(), Preferences.getPreferences().getHeight() * Preferences.getPreferences().getScale()));
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.darkGray);
        gamePane = new GamePane();
        add(gamePane);
        java.util.List<OptionManager> managers = Arrays.asList(new SpeedManager(), new ColorManager(), new StrategyManager(), new SizeManager(), new OtherManager());
        mb = new GameMenuBar(this, managers);
        setJMenuBar(mb);

    }


    public void sizeChanged() {
        this.remove(gamePane);
        Cell[][] old = gamePane.getCells();
        gamePane = new GamePane();
        gamePane.cloneWorld(old);
        this.add(gamePane);
        this.setSize(new Dimension(Preferences.getPreferences().getWidth() * Preferences.getPreferences().getScale(), Preferences.getPreferences().getHeight() * Preferences.getPreferences().getScale()));
    }

    public void clear() {
        gamePane.clear();
    }

    public void transition() {
        gamePane.setTransition();
    }

}