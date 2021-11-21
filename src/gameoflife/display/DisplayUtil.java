package gameoflife.display;

import java.awt.*;

public class DisplayUtil {
    public static Color getScaledColor(boolean now, boolean old, Color selectedColor, int speed, long timeSinceRefresh,  boolean transition, boolean paused){

        if(old && now){
            return selectedColor;
        }

        if(speed>5||speed ==0){
            transition = false;
        }

        if(!transition || paused) {
            if(old) {
                return Color.BLACK;
            }
            return selectedColor;
        }

        long timeInterval = 1000/speed;

        float multiplier = (float) timeSinceRefresh /(float)(timeInterval);

        if(multiplier<0){
            multiplier=0;
        }
        if(multiplier>1){
            multiplier=1;
        }

        multiplier = (float)Math.sin( Math.toRadians((int)(multiplier*90)));
        if(old){
            multiplier = 1f-multiplier;
        }

        return new Color((int)(multiplier*selectedColor.getRed()),
                (int)(multiplier*selectedColor.getGreen()),
                (int)(multiplier*selectedColor.getBlue()));
    }
}
