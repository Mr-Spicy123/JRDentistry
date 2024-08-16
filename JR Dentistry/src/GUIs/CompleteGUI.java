package GUIs;

import Begin.Begin;
import Misc.ImageIconScaler;
import Misc.ScalePos;
import Misc.ScreenInfo;
import Misc.SwingSetup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompleteGUI {

    static ActionListener listener;

    static JFrame frame = new JFrame("complete GUI");

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
        SwingSetup.setupInvisibleButton(rerunButton, panel, listener, ScalePos.scaleWidth(865), ScalePos.scaleHeight(400), ScalePos.scaleWidth(175), ScalePos.scaleHeight(175), false, false);

        JButton exitButton = new JButton("exit");
        SwingSetup.setupInvisibleButton(exitButton, panel, listener, ScalePos.scaleWidth(865), ScalePos.scaleHeight(730), ScalePos.scaleWidth(200), ScalePos.scaleHeight(185), false, false);

        frame.setVisible(true);

    }
}
