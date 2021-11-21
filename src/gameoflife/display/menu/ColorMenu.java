package gameoflife.display.menu;

import gameoflife.display.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColorMenu extends JMenu implements ActionListener {
    Grid grid;

    private List<WrappedMenuItem> items = List.of(new WrappedMenuItem(Color.BLUE, "Blue", this),
            new WrappedMenuItem(Color.GREEN, "Green", this),
            new WrappedMenuItem(Color.YELLOW, "Yellow", this),
            new WrappedMenuItem(Color.PINK, "Pink", this),
            new WrappedMenuItem(Color.GRAY, "Gray", this),
            new WrappedMenuItem(Color.RED, "Red", this),
            new WrappedMenuItem(Color.ORANGE, "Orange", this),
            new WrappedMenuItem(Color.MAGENTA, "Magenta", this)


            );

    public ColorMenu(Grid grid) {

        super("Color");
        this.grid = grid;

        for(WrappedMenuItem item : items){
            this.add(item);
        }
        items.get(0).setEnabled(false);
        grid.setColor(items.get(0).value);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (WrappedMenuItem item : items) {
            if (e.getSource() == item) {
                grid.setColor(item.value);
                item.setEnabled(false);

            } else {
                item.setEnabled(true);
            }
        }
    }

    private static class WrappedMenuItem extends JMenuItem {
        Color value;
        public WrappedMenuItem(Color value, String title, ActionListener actionListener) {
            super(title);
            this.value = value;
            this.addActionListener(actionListener);
        }
    }
}
