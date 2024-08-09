package Misc;

import javax.swing.*;
import java.awt.*;

public class ImageIconScaler {
  public static ImageIcon scaleImageIcon(ImageIcon originalIcon, int targetWidth, int targetHeight) {
    if (originalIcon == null || originalIcon.getImage() == null) {
      System.err.println("Error: Original ImageIcon is null or does not contain a valid Image.");
      return null;
    }

    Image originalImage = originalIcon.getImage();
    Image scaledImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
    return new ImageIcon(scaledImage);
  }
}