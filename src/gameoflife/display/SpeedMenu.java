package gameoflife.display;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpeedMenu extends JMenu implements ActionListener {
    private final JMenuItem pause;
    private JMenuItem speed1;
    private JMenuItem speed5;
    private JMenuItem speed20;
    private JMenuItem speed50;
    private JMenuItem speed100;
    Grid grid;

    public SpeedMenu(Grid grid) {


        super("Speed");
        this.grid = grid;
        pause = new JMenuItem("pause");
        pause.addActionListener(this);
        speed1 = new JMenuItem("1x");
        speed1.addActionListener(this);
        speed5 = new JMenuItem("5x");
        speed5.addActionListener(this);
        speed20 = new JMenuItem("20x");
        speed20.addActionListener(this);
        speed50 = new JMenuItem("50x");
        speed50.addActionListener(this);
        speed100 = new JMenuItem("100x");
        speed100.addActionListener(this);
        this.add(pause);
        add(speed1);
        add(speed5);
        add(speed20);
        add(speed50);
        add(speed100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pause) {
            grid.setPaused(true);
        }
        if (e.getSource() == speed1) {
            grid.setSpeed(1);
            grid.setPaused(false);
        }
        if (e.getSource() == speed5) {
            grid.setSpeed(5);
            grid.setPaused(false);
        }
        if (e.getSource() == speed20) {
            grid.setSpeed(20);
            grid.setPaused(false);
        }
        if (e.getSource() == speed50) {
            grid.setSpeed(50);
            grid.setPaused(false);
        }
        if (e.getSource() == speed100) {
            grid.setSpeed(100);
            grid.setPaused(false);
        }
    }
}
