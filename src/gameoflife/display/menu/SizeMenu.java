package gameoflife.display.menu;

import gameoflife.display.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SizeMenu extends JMenu implements ActionListener {
    Grid grid;

    private List<WrappedMenuItem> items = List.of(new WrappedMenuItem(10, 10, 10, "10:10x10", this),
            new WrappedMenuItem(10, 10, 10, "10:10x10", this),
            new WrappedMenuItem(10, 100, 100, "10:100x100", this),
            new WrappedMenuItem(5, 200, 200, "5:200x200", this),
            new WrappedMenuItem(3, 600, 200, "3:600x200", this),
            new WrappedMenuItem(1, 1600, 800, "1:1600x800", this)





            );

    public SizeMenu(Grid grid) {

        super("Grid Size");
        this.grid = grid;

        for(WrappedMenuItem item : items){
            this.add(item);
        }
        items.get(0).setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (WrappedMenuItem item : items) {
            if (e.getSource() == item) {
                grid.setSize(item.scale, item.width, item.height);
                item.setEnabled(false);

            } else {
                item.setEnabled(true);
            }
        }
    }

    private static class WrappedMenuItem extends JMenuItem {
        int scale;
        int width;
        int height;
        public WrappedMenuItem(int scale,int width, int height, String title, ActionListener actionListener) {
            super(title);
            this.scale = scale;
            this.height = height;
            this.width = width;
            this.addActionListener(actionListener);
        }
    }
}
