package gameoflife;

import gameoflife.display.Grid;

import java.awt.*;

public class App {
    public static void main(String[] args) {
        Grid grid = new Grid(1, 1800, 600);
        grid.pack();
        grid.setBackground(Color.BLACK);
        grid.setLocationRelativeTo(null);
        grid.createBufferStrategy(2);
        grid.setVisible(true);

    }
}
