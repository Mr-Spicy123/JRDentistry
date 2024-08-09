package Misc;
import java.awt.*;

public class ScreenInfo {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // Get the width and height of the screen
    public static int screenWidth = (int) screenSize.getWidth();
    public static int screenHeight = (int) screenSize.getHeight();
}
