package gameoflife.display;

import gameoflife.display.menu.GameMenuBar;
import gameoflife.strategy.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Grid extends JFrame {
    private GameMenuBar mb;
    private GamePane gamePane;
    private List<Strategy> strategies = Arrays.asList(new Conways(), new HungryBacteria(), new InterestingStrategy(), new OptimisticStrategy(), new VeryOptimisticStrategy());


    public Grid(int scale, int width, int height) throws HeadlessException {
        setPreferredSize(new Dimension(width * scale, height * scale));
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        gamePane = new GamePane(scale, width, height);
        add(gamePane);
        mb = new GameMenuBar(this);
        setJMenuBar(mb);

    }


    public void setSize(int scale, int width, int height) {
        this.remove(gamePane);
        gamePane = new GamePane(scale, width, height);
        this.add(gamePane);
        this.setSize(new Dimension(width * scale, height * scale));
    }

    public void setSpeed(int speed) {

        gamePane.setSpeed(speed);
        gamePane.setPaused(speed==0);
    }

    public void setColor(Color color) {
        gamePane.setColor(color);
    }

    public void setStrategy(Strategy strategy) {
        gamePane.setStrategy(strategy);
    }

    public void clear() {
        gamePane.clear();
    }

    public void transition() {
        gamePane.setTransition();
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }
}