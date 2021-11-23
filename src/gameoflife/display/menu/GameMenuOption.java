package gameoflife.display.menu;

import gameoflife.display.Grid;
import gameoflife.options.Option;
import gameoflife.options.OptionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenuOption extends JMenu implements ActionListener {
    Grid grid;
    OptionManager optionManager;
    public GameMenuOption(Grid grid, OptionManager optionManager) {
        super(optionManager.getMenuName());
        this.grid = grid;
        this.optionManager = optionManager;
        int i = 0;
        for(Option option : optionManager.getOptions()) {
            add( new  WrappedMenuItem(i++, option.getMenuName(), this));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionManager.executeAction(((WrappedMenuItem)e.getSource()).value, grid);

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
