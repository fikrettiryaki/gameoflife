package gameoflife.display;

import java.awt.*;

public class DisplayUtil {
    public static Color getScaledColor(boolean now, boolean old, Color selectedColor, int stepCount, int stepLength){
        if(old && now){
            return selectedColor;
        }
        float multiplier = (float) stepCount /(float)(stepLength/2);

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
