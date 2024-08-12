package Misc;

public class ScalePos {
    //original width and height of screen
    static int originalScreenWidth = 1280;
    static int originalScreenHeight = 720;

    //width and height of screen in use
    static int currentScreenWidth = ScreenInfo.screenWidth;
    static int currentScreenHeight = ScreenInfo.screenHeight;

    //scales for width and height
    //REMEMBER: scales can be used for both positioning and sizing
    static double widthScale = (double) currentScreenWidth / originalScreenWidth;
    static double heightScale = (double) currentScreenHeight / originalScreenHeight;

    public static int scaleWidth(int width) {
        return (int) widthScale * width;
    }

    public static int scaleHeight(int height) {
        return (int) heightScale * height;
    }
}
