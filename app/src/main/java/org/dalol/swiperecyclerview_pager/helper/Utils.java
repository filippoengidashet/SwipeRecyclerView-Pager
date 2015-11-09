package org.dalol.swiperecyclerview_pager.helper;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * @author Filippo Ash
 * @version 1.0.0
 * @date 9/26/2015
 */
public class Utils {
    /**
     * This is a helper static method that allow to get display dimensions in pixels
     *
     * @param context
     * @return Point
     */
    public static Point getWindowSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point screenSize = new Point();
        display.getSize(screenSize);
        return screenSize;
    }
}
