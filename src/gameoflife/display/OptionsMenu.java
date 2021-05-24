package gameoflife.display;

import gameoflife.strategy.ClassicStrategy;
import gameoflife.strategy.OptimisticStrategy;
import gameoflife.strategy.PessimisticStrategy;
import gameoflife.strategy.VeryOptimisticStrategy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsMenu extends JMenu implements ActionListener {
    private JMenuItem strategyVeryOptimistic;
    private JMenuItem strategyClassic;
    private JMenuItem strategyOptimistic;
    private JMenuItem strategyPessimistic;
    private final JMenuItem clearGrid;
    private JMenuItem transition;
    Grid grid;

    public OptionsMenu(Grid grid) {
        super("Options");
        this.grid = grid;
        strategyClassic = new JMenuItem("Classic");
        strategyClassic.addActionListener(this);

        strategyOptimistic = new JMenuItem("Optimist");
        strategyOptimistic.addActionListener(this);

        strategyVeryOptimistic = new JMenuItem("Very Optimist");
        strategyVeryOptimistic.addActionListener(this);

        strategyPessimistic = new JMenuItem("Pessimist");
        strategyPessimistic.addActionListener(this);

        clearGrid = new JMenuItem("Clear");
        clearGrid.addActionListener(this);


        transition = new JMenuItem("Transition");
        transition.addActionListener(this);

        add(transition);
        add(clearGrid);
        add(strategyOptimistic);
        add(strategyVeryOptimistic);
        add(strategyPessimistic);
        add(strategyClassic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == strategyOptimistic) {
            grid.setStrategy(new OptimisticStrategy());
        }

        if (e.getSource() == strategyVeryOptimistic) {
            grid.setStrategy(new VeryOptimisticStrategy());
        }

        if (e.getSource() == strategyClassic) {
            grid.setStrategy(new ClassicStrategy());
        }

        if (e.getSource() == strategyPessimistic) {
            grid.setStrategy(new PessimisticStrategy());
        }

        if (e.getSource() == clearGrid) {
            grid.clear();
        }

        if (e.getSource() == transition) {
            grid.transition();
        }
    }
}
