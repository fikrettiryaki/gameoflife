package gameoflife.display;

import gameoflife.strategy.Strategy;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    private static final int SCALE = 10;
    private static final int SIZE = 100;
    private JMenuBar mb;

private GamePane gamePane;


    public Grid() throws HeadlessException {
        setPreferredSize(new Dimension(SIZE * SCALE, SIZE * SCALE));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        gamePane = new GamePane(SCALE, SIZE);
        add(gamePane);
        mb = new JMenuBar();

        mb.add(new SpeedMenu(this));
        mb.add(new ColorMenu(this));
        mb.add(new OptionsMenu(this));

        setJMenuBar(mb);

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
}