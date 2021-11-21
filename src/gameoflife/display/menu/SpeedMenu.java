package gameoflife.display.menu;

import gameoflife.display.Grid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SpeedMenu extends JMenu implements ActionListener {
    private List<WrappedMenuItem> speeds = new ArrayList<>();
    Grid grid;

    public SpeedMenu(Grid grid) {

        super("Speed");
        this.grid = grid;
        WrappedMenuItem item = new WrappedMenuItem(0, "pause", this);
        speeds.add(item);
        item.setSelected(true);
        item.setEnabled(false);
        this.add(item);
        item = new WrappedMenuItem(1, "1X", this);
        speeds.add(item);
        this.add(item);
        item = new WrappedMenuItem(3, "3X", this);
        speeds.add(item);
        this.add(item);
        item = new WrappedMenuItem(10, "10X", this);
        speeds.add(item);
        this.add(item);
        item = new WrappedMenuItem(50, "50X", this);
        speeds.add(item);
        this.add(item);
        item = new WrappedMenuItem(100, "500X", this);
        speeds.add(item);
        item = new WrappedMenuItem(1000, "1000X", this);
        speeds.add(item);
        this.add(item);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (WrappedMenuItem item : speeds) {
            if (e.getSource() == item) {
                grid.setSpeed(item.value);
                item.setEnabled(false);

            } else {
                item.setEnabled(true);
            }
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
