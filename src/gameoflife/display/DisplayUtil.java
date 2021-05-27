package gameoflife.display;

import java.awt.*;

public class DisplayUtil {
    public static Color getScaledColor(boolean now, boolean old, Color selectedColor, int speed, long timeTillRefresh){

        if(speed>5||speed ==0){
            return selectedColor;
        }
        if(old && now){
            return selectedColor;
        }
        long timeInterval = 1000/speed;

        float multiplier = (float) timeTillRefresh /(float)(timeInterval/2);

        if(old){
            multiplier = 1f-multiplier;
        }
        if(multiplier<0){
            multiplier=0;
        }
        if(multiplier>1){
            multiplier=1;
        }

        return new Color(selectedColor.getRed(),
                selectedColor.getGreen(),
                selectedColor.getBlue(),
                (int)(multiplier*255));
    }
}
