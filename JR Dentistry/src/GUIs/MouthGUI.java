package GUIs;

import Misc.ImageIconScaler;
import Misc.Plaque;
import Misc.SwingSetup;
import Misc.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.Random;

public class MouthGUI implements MouseMotionListener {

  static Random rand = new Random();
  static int minTeeth = 3;
  static int maxTeeth = 15;
  static int numTeeth = rand.nextInt(minTeeth, maxTeeth+1);

  static int[][] teethPlacement = {
          {390, 230, 50, 50},   //x, y, width, height 1st tooth
          {445, 220, 50, 50},   //x, y, width, height 2nd tooth
          {490, 175, 130, 130}, //...
          {625, 200, 120, 120}, //...
          {780, 190, 160, 160}, //...
          {980, 190, 160, 160}, //...
          {1172, 200, 120,120}, //...
          {1310, 200, 95, 95},  //...
          {1420, 220, 50, 50},  //...
          {1475, 240, 50, 50},  //...
          {430, 490, 60, 60},   //...
          {480, 550, 60, 60},   //...
          {510, 610, 55, 55},   //...
          {525, 675, 75, 75},   //...
          {605, 765, 75, 75},   //...
          {710, 800, 95, 95},   //...
          {840, 810, 105, 105}, //...
          {975, 810, 105, 105}, //...
          {1115, 805, 95 ,95},  //...
          {1235, 760, 85, 85},  //...
          {1305, 670, 85, 85},  //...
          {1375, 620, 65, 65},  //...
          {1390, 550, 70, 70},  //x, y, width, height 23rd tooth
          {1425, 490, 60, 60},  //x, y, width, height 24th tooth
  };

  static Plaque[] plaqueArr = new Plaque[maxTeeth];
  static int plaqueArrIndex = 0;

  static JFrame mainFrame;

  static Tool t;

  static JLabel toolLabel;

  static JLayeredPane layeredFrame;

  public MouthGUI() {

    mainFrame = new JFrame("Jr. Dentistry");
    mainFrame.setLayout(null);
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainFrame.setBounds(0, 0, 1920, 1080);

    layeredFrame = new JLayeredPane();
    layeredFrame.setPreferredSize(new Dimension(1920, 1080));
    layeredFrame.addMouseMotionListener(this);

    ImageIcon mouthImage = ImageIconScaler.scaleImageIcon(new ImageIcon("JR Dentistry/out/Images/e.png"), 1920, 1080);
    JLabel mouthLabel = new JLabel(mouthImage);
    mouthLabel.setBounds(0, 0, 1920 ,1080);
    layeredFrame.add(mouthLabel, JLayeredPane.DEFAULT_LAYER);

    ImageIcon toolImage = ImageIconScaler.scaleImageIcon(new ImageIcon("JR Dentistry/out/Images/DentalTool.png"), 300, 300);
    toolLabel = new JLabel(toolImage);
    toolLabel.setBounds(1600, 400, 300, 300);
    t = new Tool(1600, 400, 300, 300);
    layeredFrame.add(toolLabel, JLayeredPane.PALETTE_LAYER);

    ImageIcon plaqueImage1 = new ImageIcon("JR Dentistry/out/Images/plaque1.png");
    ImageIcon plaqueImage2 = new ImageIcon("JR Dentistry/out/Images/plaque2.png");
    ImageIcon plaqueImage3 = new ImageIcon("JR Dentistry/out/Images/plaque3.png");
    ImageIcon plaqueImage4 = new ImageIcon("JR Dentistry/out/Images/plaque4.png");

    ImageIcon[] plaqueImagesArr = {plaqueImage1, plaqueImage2, plaqueImage3, plaqueImage4};

    int[] usedTeeth = new int[24];
    for (int i = 0; i < usedTeeth.length; i++) {
      usedTeeth[i] = -1;
    }
    int indexUsedTeeth = -1;

    for (int i = 0; i < numTeeth; i++) {
      int tooth = rand.nextInt(0, 24);
      indexUsedTeeth++;
      tooth = toothCheck(tooth, usedTeeth);
      JLabel plaqueLabel;
      usedTeeth[indexUsedTeeth] = tooth;
      int image = rand.nextInt(0, 4);
      ImageIcon plaqueImage = ImageIconScaler.scaleImageIcon(plaqueImagesArr[image], teethPlacement[tooth][2], teethPlacement[tooth][3]);
      plaqueLabel = new JLabel(plaqueImage);
      plaqueLabel.setBounds(teethPlacement[tooth][0], teethPlacement[tooth][1], teethPlacement[tooth][2], teethPlacement[tooth][3]);
      layeredFrame.add(plaqueLabel, JLayeredPane.PALETTE_LAYER);
      createPlaque(tooth, plaqueLabel);
    }
    mainFrame.setContentPane(layeredFrame);

    mainFrame.setVisible(true);
    boolean run = true;
    runGame(run, t);
  }


  public static int toothCheck(int tooth, int[] teethArray) {
    for (int i =0; i < teethArray.length; i++) {
      if (tooth == teethArray[i]) {
        tooth = rand.nextInt(0, 24);
        tooth = toothCheck(tooth, teethArray);
        return tooth;
      }
    }
    return tooth;
  }

  public static void runGame(boolean run, Tool t) {
    if (run) {
      delay(1);
      detect(t);
      if (gameOver()) {
        run = false;
        mainFrame.setVisible(false);
      }
      runGame(run, t);
    }
  }

  public static void delay(int mills) {
    try {
      Thread.sleep(mills);
    }catch (InterruptedException e){
    }
  }

  public static void createPlaque(int tooth, JLabel label) {
    int x = teethPlacement[tooth][0];
    int y = teethPlacement[tooth][1];
    int width = teethPlacement[tooth][2];
    int height = teethPlacement[tooth][3];
    Plaque p = new Plaque(x, y, width, height, label);
    plaqueArr[plaqueArrIndex] = p;
    plaqueArrIndex++;
  }

  public static boolean detect(Tool t) {
    for (int i = 0; i < plaqueArrIndex; i++) {
      Plaque p = plaqueArr[i];
      if (t.intersects(p)) {
        p.Collide(layeredFrame);
        layeredFrame.repaint();
        return true;
      }
    }
    return false;
  }




  @Override
  public void mouseDragged(MouseEvent e) {
    toolLabel.setBounds(e.getX(), e.getY(),300, 300);
    t.update(e.getX(), e.getY());
    layeredFrame.repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    //System.out.println("X: " + e.getX() + " Y: " + e.getY());
    toolLabel.setBounds(e.getX(), e.getY(),300, 300);
    t.update(e.getX(), e.getY());
    layeredFrame.repaint();
  }

  public static boolean gameOver() {
    for (int i = 0; i < plaqueArrIndex; i++) {
      if (plaqueArr[i].alive) {
        return false;
      }
    }
    delay(1000);
    return true;
  }
}

//TO DO:
/*
make 'run' boolean in runGame false after all plaque have been eliminated
add menu/home screen

add back button to game screen

add restart button to game screen
* */

