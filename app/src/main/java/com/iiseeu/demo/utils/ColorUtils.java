package com.iiseeu.demo.utils;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by housong on 2016/6/14.
 */
public class ColorUtils {

    public static int getRandomColor() {
        Random random = new Random();
        int red = random.nextInt(200) + 30;
        int green = random.nextInt(200) + 30;
        int blue = random.nextInt(200) + 30;
        return Color.rgb(red, green, blue);
    }
}
