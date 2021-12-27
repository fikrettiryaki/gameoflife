package gameoflife.display;

import gameoflife.creature.Thematrix;
import gameoflife.options.Preferences;

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

    private boolean transition = true;
    private boolean drawing = false;

    Instant lastTimeIterate = Instant.now();

    private final Thematrix thematrix;

    public GamePane() {

        thematrix = new Thematrix();
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
        if (painting || drawing || Preferences.getPreferences().getSpeed() == 0) {
            return;
        }
        drawing = true;
        Instant now = Instant.now();
        long diff = now.toEpochMilli() - lastTimeIterate.toEpochMilli();
        long iterationLength = 1000 / Preferences.getPreferences().getSpeed();

        if (diff > iterationLength) {
            thematrix.iterate();

            lastTimeIterate = now;
        }

        repaint();
        drawing = false;

    }

    private boolean isInRangeWidth(int val) {
        return val >= 0 && val < Preferences.getPreferences().getWidth();
    }
    private boolean isInRangeHeight(int val) {
        return val >= 0 && val <  Preferences.getPreferences().getHeight();
    }
    public void paint(Graphics g) {
        boolean paused = Preferences.getPreferences().getSpeed() == 0;

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();

        Instant now = Instant.now();
        long diff = now.toEpochMilli() - lastTimeIterate.toEpochMilli();

        Color growingColor = DisplayUtil.getScaledColor(true, false, Preferences.getPreferences().getColor(), Preferences.getPreferences().getSpeed(), diff, transition, paused);
        Color dyingColor = DisplayUtil.getScaledColor(false, true, Preferences.getPreferences().getColor(), Preferences.getPreferences().getSpeed(), diff, transition, paused);
        Color sameColor = DisplayUtil.getScaledColor(true, true, Preferences.getPreferences().getColor(), Preferences.getPreferences().getSpeed(), diff, transition, paused);

        for (int x = 0; x < Preferences.getPreferences().getWidth(); ++x) {
            for (int y = 0; y < Preferences.getPreferences().getHeight(); ++y) {
                if (thematrix.wasDead(x, y) && thematrix.willBeDead(x, y)) {
                    continue;
                }
                Color c = sameColor;

                if (thematrix.willBeDead(x, y)) {
                    c = dyingColor;
                }
                if (thematrix.wasDead(x, y)) {
                    c = growingColor;
                }


                g2d.setColor(c);
                g2d.fillRect(x * Preferences.getPreferences().getScale(), y * Preferences.getPreferences().getScale(), Preferences.getPreferences().getScale(), Preferences.getPreferences().getScale());
            }
        }
        g2d.dispose();
    }

    private void tryAdjustValue(Point pt, boolean selected) {
        int newX = pt.x / Preferences.getPreferences().getScale();
        int newY = pt.y / Preferences.getPreferences().getScale();

        if (painting && isInRangeWidth(newX) && isInRangeHeight(newY) && (newX != lastX || newY != lastY)) {
            thematrix.setWasAlive(newX, newY, selected);
            thematrix.setWillBeAlive(newX, newY, selected);
            lastX = newX;
            lastY = newY;
            repaint();
        }
    }

    public void setTransition() {
        transition = !transition;
    }


    public void clear() {
        thematrix.clear();
    }

    public void updateSize() {
        thematrix.updateSize();
    }
}


