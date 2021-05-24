package gameoflife;

import gameoflife.display.Grid;

import java.awt.*;

public class App {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.pack();
        grid.setBackground(Color.BLACK);
        grid.setLocationRelativeTo(null);
        grid.createBufferStrategy(2);
        grid.setVisible(true);

    }
}
