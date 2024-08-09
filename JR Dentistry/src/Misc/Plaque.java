package Misc;

import Threads.ElimAnimation;

import javax.swing.*;

public class Plaque {

  int x, y ,width, height;
  JLabel label;
  public boolean alive;
  public boolean inProg;

  public Plaque() {
    this(0, 0, 0, 0, null);
  }

  public Plaque(int x, int y, int width, int height, JLabel label) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.label = label;
    alive = true;
    inProg = false;
  }

  //this method handles what happens when a collision is detected
  public void Collide(JLayeredPane pane) {
    if (!inProg && alive) {
      new ElimAnimation(this, label, pane);
      //pane.remove(label);
    }
  }

}
