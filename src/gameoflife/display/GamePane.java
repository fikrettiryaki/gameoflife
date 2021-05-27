package gameoflife.display;

import gameoflife.creature.Thematrix;
import gameoflife.strategy.Conways;
import gameoflife.strategy.Strategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.time.Instant;

public  class GamePane extends JPanel {
    private boolean painting;
    private int lastX = -1;
    private int lastY = -1;

    private int scale, size;

    private  Color selectedColor = Color.PINK;
    private  int speed = 1;
    private  boolean paused = true;
    private boolean transition = true;

    Instant lastTimeIterate = Instant.now();

    private final Thematrix thematrix;

    public GamePane(int scale, int size) {
        this.scale = scale;
        this.size = size;

        thematrix = new Thematrix(new Conways(), size);
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                painting = true;
                tryAdjustValue(e.getPoint(), SwingUtilities.isLeftMouseButton(e));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                painting = false;
                lastX = -1;
                lastY = -1;
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                tryAdjustValue(e.getPoint(), SwingUtilities.isLeftMouseButton(e));
            }

            public void mouseMoved(MouseEvent e) {
                tryAdjustValue(e.getPoint(), SwingUtilities.isLeftMouseButton(e));
            }
        });
        final Timer timer = new Timer(50, e -> checkDraw());
        timer.start();
    }

    private void checkDraw() {
        if (painting || paused) {
            return;
        }
        paused = true;
        Instant now = Instant.now();
        long diff = now.toEpochMilli() - lastTimeIterate.toEpochMilli();
        int inverseSpeed = 1000/speed;
        int iterateCount = (int)(diff/inverseSpeed);

        if(iterateCount>0){
            while(iterateCount>0){
                iterateCount--;
                thematrix.iterate();
            }
            lastTimeIterate = now;
        }

        repaint();

        paused=false;
    }

    private boolean isInRange(int val) {
        return val >= 0 && val < size;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();

        Instant now = Instant.now();
        long diff = now.toEpochMilli() - lastTimeIterate.toEpochMilli();

        Color newColor = DisplayUtil.getScaledColor(true, false, selectedColor, speed, diff);
        Color oldColor = DisplayUtil.getScaledColor(false, true, selectedColor, speed, diff);
        Color sameColor = DisplayUtil.getScaledColor(true, true, selectedColor, speed, diff);

        for (int x = 0; x < size; ++x) {
            for (int y = 0; y < size; ++y) {
                if (thematrix.getMyworld()[x][y] || (!paused && transition && thematrix.getOldworld()[x][y])) {
                    Color c = sameColor;
                    if (transition && !thematrix.getMyworld()[x][y]) {
                        c = oldColor;
                    }
                    if (transition && !thematrix.getOldworld()[x][y]) {
                        c = newColor;
                    }
                    g2d.setColor(c);
                    g2d.fillRect(x * scale, y * scale, scale, scale);
                }
            }
        }
        g2d.dispose();
    }


    private void tryAdjustValue(Point pt, boolean selected) {
        int newX = pt.x / scale;
        int newY = pt.y / scale;

        if (painting && isInRange(newX) && isInRange(newY) && (newX != lastX || newY != lastY)) {
            thematrix.getCells()[newX][newY].setAlive(selected);
            thematrix.getMyworld()[newX][newY]=selected;
            lastX = newX;
            lastY = newY;
            repaint();
        }
    }

    public void setColor(Color color) {
        this.selectedColor = color;
    }

    public void setPaused(boolean paused) {
        if(!paused){
            lastTimeIterate = Instant.now();
        }
        this.paused = paused;

    }

    public void setTransition() {
        transition = !transition;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrategy(Strategy strategy) {
        this.thematrix.setStrategy(strategy);
    }

    public void clear() {
        thematrix.clear();
    }
}


