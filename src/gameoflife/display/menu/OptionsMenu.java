package gameoflife.display.menu;

import gameoflife.display.Grid;
import gameoflife.strategy.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsMenu extends JMenu implements ActionListener {
    private final WrappedMenuItem clearGrid;
    private final WrappedMenuItem transition;
    Grid grid;

    public OptionsMenu(Grid grid) {
        super("Options");
        this.grid = grid;
        int i = 0;
        for(Strategy strategy : grid.getStrategies()) {
            add( new WrappedMenuItem(i++, strategy.getMenuTitle(), this));
        }
        clearGrid = new WrappedMenuItem(i++ ,"Clear", this);
        transition = new WrappedMenuItem(i ,"Transition", this);
        add(clearGrid);
        add(transition);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((WrappedMenuItem)e.getSource()).value < grid.getStrategies().size()) {
            grid.setStrategy(grid.getStrategies().get(((WrappedMenuItem)e.getSource()).value));
            return;
        }


        if (e.getSource() == clearGrid) {
            grid.clear();
        }

        if (e.getSource() == transition) {
            grid.transition();
        }
    }

    private static class WrappedMenuItem extends JMenuItem {
        int value;

        public WrappedMenuItem(int value, String title, ActionListener actionListener) {
            super(title);
            this.value = value;
            this.addActionListener(actionListener);
        }
    }
}
