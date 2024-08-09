package GUIs;

import Misc.ImageIconScaler;

import javax.swing.*;

public class MenuGUI {

  public MenuGUI() {
    JFrame frame = new JFrame();
    frame.setLayout(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(0, 0, 1920, 1080);
    ImageIcon backgroundImage = ImageIconScaler.scaleImageIcon(new ImageIcon("C:\\Users\\jacks\\OneDrive\\JR Dentistry\\menu.png"), 1920, 1080);
    JLabel backgroundLabel = new JLabel(backgroundImage);
    backgroundLabel.setBounds(0, 0, 1920, 1080);
    JLayeredPane panel = new JLayeredPane();
    panel.setLayout(null);
    panel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    panel.setBounds(0, 0, 1920, 1080);
    frame.setContentPane(panel);
    frame.setVisible(true);
  }
}
