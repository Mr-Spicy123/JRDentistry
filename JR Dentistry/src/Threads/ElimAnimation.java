package Threads;

import Misc.ImageIconScaler;
import Misc.Plaque;
import Misc.Tool;

import javax.swing.*;
import java.awt.*;

public class ElimAnimation extends Thread{

  JLabel label;
  JLayeredPane layeredFrame;
  ImageIcon image;
  Plaque p;

  public ElimAnimation(Plaque p, JLabel label, JLayeredPane layeredFrame) {
    p.inProg = true;
    this.p = p;
    this.label = label;
    this.layeredFrame = layeredFrame;
    image = (ImageIcon) label.getIcon();
    this.start();
  }

  @Override
  public void run() {
    ImageIcon temp = (ImageIcon) label.getIcon();
    //this animation will indicate the elimination of a plaque
    while (Tool.intersecting) {
      image = ImageIconScaler.scaleImageIcon(temp, image.getIconWidth() - 1, image.getIconHeight() - 1);
      label.setIcon(image);
      layeredFrame.repaint();
      delay(5);
      if (image.getIconWidth() <= 25) {
        layeredFrame.remove(label);
        p.alive = false;
        new StarAnimation(label, layeredFrame);
        break;
      }
    }
    p.inProg = false;
  }

  public static void delay(int mills) {
    try {
      Thread.sleep(mills);
    }catch(InterruptedException e) {
    }
  }

}
