package GUIs;

import Misc.ImageIconScaler;
import Misc.ScreenInfo;

import java.awt.*;

import javax.swing.*;

public class MenuGUI {

  public MenuGUI() {
    int scrWid = ScreenInfo.screenWidth;
    int scrHgt = ScreenInfo.screenHeight;
    JFrame frame = new JFrame();
    frame.setLayout(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(0, 0, scrWid, scrHgt);
    ImageIcon backgroundImage = ImageIconScaler.scaleImageIcon(new ImageIcon("JR Dentistry/out/Images/menu.png"), 1920, 1080);
    JLabel backgroundLabel = new JLabel(backgroundImage);
    backgroundLabel.setBounds(0, 0, scrWid, scrHgt);
    JLayeredPane panel = new JLayeredPane();
    panel.setLayout(null);
    panel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    panel.setBounds(0, 0, scrWid, scrHgt);
    frame.setContentPane(panel);
    frame.setVisible(true);
  }
}
