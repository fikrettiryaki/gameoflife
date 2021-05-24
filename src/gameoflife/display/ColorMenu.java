package gameoflife.display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorMenu extends JMenu implements ActionListener {
    private final Grid grid;
    private final JMenuItem colorRed;
    private final JMenuItem colorPink;
    private final JMenuItem colorBlue;
    private final JMenuItem colorYellow;
    private final JMenuItem colorOrange;

    public ColorMenu(Grid grid) {
        super("Color");
        this.grid = grid;

        colorOrange = new JMenuItem("orange");
        colorOrange.addActionListener(this);
        colorBlue = new JMenuItem("blue");
        colorBlue.addActionListener(this);
        colorPink = new JMenuItem("pink");
        colorPink.addActionListener(this);
        colorRed = new JMenuItem("red");
        colorRed.addActionListener(this);
        colorYellow = new JMenuItem("yellow");
        colorYellow.addActionListener(this);
        add(colorOrange);
        add(colorBlue);
        add(colorPink);
        add(colorRed);
        add(colorYellow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == colorOrange) {
            grid.setColor(Color.ORANGE);
        }
        if (e.getSource() == colorBlue) {
            grid.setColor(Color.BLUE);
        }
        if (e.getSource() == colorPink) {
            grid.setColor(Color.PINK);
        }
        if (e.getSource() == colorRed) {
            grid.setColor(Color.RED);
        }
        if (e.getSource() == colorYellow) {
            grid.setColor(Color.YELLOW);
        }
    }
}
