package Threads;

import Misc.ImageIconScaler;
import Misc.Plaque;

import javax.swing.*;

import static GUIs.MouthGUI.delay;

public class StarAnimation extends Thread{

  JLabel label;
  JLayeredPane panel;

  public StarAnimation(JLabel label, JLayeredPane panel) {
    this.panel = panel;
    this.label = label;
    this.start();
  }

  @Override
  public void run() {
    int width = label.getWidth();
    int height = label.getHeight();
    int x = label.getX();
    int y = label.getY();
    ImageIcon temp = ImageGetter.getImage("star.png");
    ImageIcon starImage = ImageIconScaler.scaleImageIcon(temp, 1, 1);
    JLabel starLabel = new JLabel(starImage);
    starLabel.setBounds(x, y, width, height);
    panel.add(starLabel, JLayeredPane.PALETTE_LAYER);
    for (int i = 0; i < width; i++) {
      starImage = ImageIconScaler.scaleImageIcon(temp, starImage.getIconWidth()+1, starImage.getIconHeight()+1);
      //starLabel.setBounds(x, y, starLa, 1);
      starLabel.setIcon(starImage);
      panel.repaint();
      delay(5);
    }
    for (int i = 0; i < width; i++) {
      starImage = ImageIconScaler.scaleImageIcon(temp, starImage.getIconWidth()-1, starImage.getIconHeight()-1);
      starLabel.setIcon(starImage);
      panel.repaint();
      delay(5);
    }
  }
}
