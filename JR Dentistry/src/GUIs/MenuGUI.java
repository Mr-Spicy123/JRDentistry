package GUIs;

import Misc.ImageIconScaler;
import Misc.ScalePos;
import Misc.ScreenInfo;
import Misc.SwingSetup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuGUI {

  ActionListener listener;

  JFrame frame;

  public MenuGUI() {

    listener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
          JButton button = (JButton) e.getSource();
          switch (button.getText()) {
            case "play":
              frame.dispose();
              new MouthGUI();
              break;
          }
        }
      }
    };

    int scrWid = ScreenInfo.screenWidth;
    int scrHgt = ScreenInfo.screenHeight;
    frame = new JFrame();
    frame.setLayout(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(0, 0, scrWid, scrHgt);
    ImageIcon backgroundImage = ImageIconScaler.scaleImageIcon(new ImageIcon("JR Dentistry/out/Images/menu.png"), ScalePos.scaleWidth(1920), ScalePos.scaleHeight(1080));
    JLabel backgroundLabel = new JLabel(backgroundImage);
    backgroundLabel.setBounds(0, 0, scrWid, scrHgt);
    JLayeredPane panel = new JLayeredPane();
    panel.setLayout(null);
    panel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    panel.setBounds(0, 0, scrWid, scrHgt);
    frame.setContentPane(panel);
    frame.setVisible(true);

    JButton play = new JButton("play");
    SwingSetup.setupButton(play, panel, listener, 490, 500, 285, 125, false, false);
  }
}
