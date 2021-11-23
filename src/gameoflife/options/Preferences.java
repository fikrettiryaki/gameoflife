package gameoflife.options;

import gameoflife.options.color.ColorManager;
import gameoflife.options.size.SizeManager;
import gameoflife.options.speed.SpeedManager;
import gameoflife.options.strategy.Conways;
import gameoflife.options.strategy.Strategy;

import java.awt.*;

public class Preferences {

    private static Preferences instance;

    private Strategy selectedStrategy = new Conways();
    private SizeManager.Size selectedSize = new SizeManager.Size(10, 100, 100, "100");
    private SpeedManager.Speed selectedSpeed = new SpeedManager.Speed("osm", 10);
    private ColorManager.Color selectedColor = new ColorManager.Color("",Color.CYAN );

    private Preferences(){

    }

    public static Preferences getPreferences(){
        if(instance == null) {
            instance = new Preferences();
        }
        return instance;
    }

    public int getWidth() {
        return selectedSize.getWidth();
    }

    public int getHeight() {
        return selectedSize.getHeight();
    }

    public int getScale() {
        return selectedSize.getScale();
    }

    public int getSpeed() {
        return selectedSpeed.getValue();
    }

    public void setSelectedSize(SizeManager.Size selectedSize) {
        this.selectedSize = selectedSize;
    }

    public void setSelectedColor(ColorManager.Color color) {
        selectedColor = color;
    }

    public void setSelectedSpeed(SpeedManager.Speed speed){
        this.selectedSpeed = speed;
    }

    public void setSelectedStrategy(Strategy strategy) {
        this.selectedStrategy = strategy;
    }

    public Color getColor() {
        return selectedColor.getValue();
    }

    public Strategy getStrategy() {
        return selectedStrategy;
    }

    public void toggleTransient() {
    }
}
