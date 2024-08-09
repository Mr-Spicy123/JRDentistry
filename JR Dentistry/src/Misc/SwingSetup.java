package Misc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SwingSetup {
  public static void setupFrame(JFrame frame, int x, int y, int width, int height, boolean vis, Object layout) {
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setBounds(x, y, width, height);
    frame.setVisible(vis);
    if (layout == null) {
      frame.setLayout(null);
    }
    else if(layout instanceof LayoutManager) {
      LayoutManager l = (LayoutManager) layout;
      frame.setLayout(l);
    }
    else {
      System.err.println("not a layout");
    }
  }

  public static void setupPanel(JPanel panel, JLabel label, int x, int y,int width, int height) {
    panel.setBounds(x, y, width, height);
    panel.add(label);
  }

  public static void setupPanel(JPanel panel, int x, int y, int width, int height, Object layout, boolean opaque) {
    panel.setBounds(x, y, width, height);
    panel.setOpaque(opaque);
    if (layout == null) {
      panel.setLayout(null);
    }
    else if (layout instanceof LayoutManager) {
      LayoutManager l = (LayoutManager) layout;
      panel.setLayout(l);
    }
    else {
      System.err.println("not a layout");
    }
  }

  public static void setupButton(JButton button, JPanel panel, ActionListener listener, int x, int y, int width, int height, boolean opaque, boolean focusable) {
    panel.add(button);
    button.setBounds(x, y, width, height);
    button.setOpaque(opaque);
    button.setFocusable(focusable);
    button.addActionListener(listener);
  }

  public static void setupInvisibleButton(JButton button, JPanel panel, ActionListener listener, int x, int y, int width, int height, boolean opaque, boolean focusable) {
    button.setOpaque(opaque);
    button.setFocusable(focusable);
    button.setOpaque(false);
    button.setBorder(null);
    button.setContentAreaFilled(false);
    button.setForeground(new Color(0, 0, 0, 0));
    panel.add(button);
    button.setBounds(x, y, width, height);
    button.addActionListener(listener);
  }

  public static void setupTextField(JTextField field, JPanel panel, int x, int y, int width, int height, boolean opaque) {
    panel.add(field);
    field.setBounds(x, y, width, height);
    field.setOpaque(opaque);
  }

  public static void setupLabel(JLabel label, JPanel panel, int x, int y, int width, int height, boolean opaque) {
    panel.add(label);
    label.setBounds(x, y, width, height);
    label.setOpaque(opaque);
  }
}
