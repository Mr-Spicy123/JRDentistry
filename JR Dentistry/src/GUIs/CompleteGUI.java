package GUIs;

import Misc.ImageIconScaler;
import Misc.ScalePos;
import Misc.ScreenInfo;
import Misc.SwingSetup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteGUI {

    ActionListener listener;

    JFrame frame = new JFrame();

    public CompleteGUI() {
        this.frame = frame;
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    JButton button = (JButton) e.getSource();
                    switch(button.getText()) {
                        case "rerun":
                            frame.dispose();
                            new MouthGUI();
                            System.out.println("CompleteGUI frame has been disposed");
                            break;
                        case "exit":
                            System.exit(0);
                            break;
                    }
                }
            }
        };
        SwingSetup.setupFrame(frame, 0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight, false, null);

        JLayeredPane panel = new JLayeredPane();
        SwingSetup.setupPanel(panel, 0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight, null, false);
        frame.add(panel);

        ImageIcon bgImage = ImageIconScaler.scaleImageIcon(new ImageIcon("JR Dentistry/out/Images/complete.png"), ScreenInfo.screenWidth, ScreenInfo.screenHeight);
        JLabel bgLabel = new JLabel(bgImage);
        bgLabel.setBounds(0, 0, bgImage.getIconWidth(), bgImage.getIconHeight());
        panel.add(bgLabel, JLayeredPane.DEFAULT_LAYER);

        JButton rerunButton = new JButton("rerun");
        SwingSetup.setupInvisibleButton(rerunButton, panel, listener, ScalePos.scaleWidth(575), ScalePos.scaleHeight(260), ScalePos.scaleWidth(130), ScalePos.scaleHeight(125), false, false);
        frame.setVisible(true);

        JButton exitButton = new JButton("exit");
        SwingSetup.setupInvisibleButton(exitButton, panel, listener, ScalePos.scaleWidth(575), ScalePos.scaleHeight(480), ScalePos.scaleWidth(140), ScalePos.scaleHeight(125), false, false);
        frame.setVisible(true);

    }
}
