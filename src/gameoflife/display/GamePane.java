package gameoflife.display;

import gameoflife.creature.Thematrix;
import gameoflife.strategy.ClassicStrategy;
import gameoflife.strategy.Strategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public  class GamePane extends JPanel {
    private boolean painting;
    private int lastX = -1;
    private int lastY = -1;

    private int scale, size;

    private  Color selectedColor = Color.PINK;
    private  int speed = 1;
    private  int stepCount = 0;
    private  int stepLength = 100;
    private  boolean paused;
    private boolean transition = true;

    private final Thematrix thematrix;

    public GamePane(int scale, int size) {
        this.scale = scale;
        this.size = size;

        thematrix = new Thematrix(new ClassicStrategy(), size);
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override

            public void mousePressed(MouseEvent e) {
                painting = true;
                stepCount=stepLength;
                tryAdjustValue(e.getPoint(), e.getButton() == MouseEvent.BUTTON1);
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
                tryAdjustValue(e.getPoint(), e.getButton() == MouseEvent.BUTTON1);
            }

            public void mouseMoved(MouseEvent e) {
                tryAdjustValue(e.getPoint(), e.getButton() == MouseEvent.BUTTON1);
            }
        });
        final Timer timer = new Timer(10, e -> checkDraw());
        timer.start();
    }

    private void checkDraw() {
        if (painting || paused) {
            return;
        }
        stepCount += speed;

        if (stepCount >= stepLength) {
            thematrix.iterate();
            stepCount = 0;
            repaint();
        } else {
            if(transition){
                repaint();
            }
        }


    }


    private boolean isInRange(int val) {
        return val >= 0 && val < size;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();


        Color newColor = DisplayUtil.getScaledColor(true, false, selectedColor, stepCount, stepLength);
        Color oldColor = DisplayUtil.getScaledColor(false, true, selectedColor, stepCount, stepLength);
        Color sameColor = DisplayUtil.getScaledColor(true, true, selectedColor, stepCount, stepLength);

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
            thematrix.getMyworld()[newX][newY] = selected;
            lastX = newX;
            lastY = newY;
            repaint();
        }
    }

    public void setColor(Color color) {
        this.selectedColor = color;
    }

    public void setPaused(boolean paused) {
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


