package Misc;

import GUIs.MouthGUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;

public class ImageGetter {


  public static ImageIcon getImage(String imageName) {
    try {
      // Get the path of the JAR file
      String jarPath = new File(ImageGetter.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();

      // Reference the image file
      File imageFile = new File(jarPath + File.separator + "Images" + File.separator + imageName);
      BufferedImage image = ImageIO.read(imageFile);
      return new ImageIcon(image);
      // Now you can use 'image' in your application

    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    return null;
  }

}
