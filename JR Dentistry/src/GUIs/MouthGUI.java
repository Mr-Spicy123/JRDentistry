package GUIs;

import Misc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.Random;

public class MouthGUI implements MouseMotionListener {

  //static variables
  final Random rand = new Random();
  final int minTeeth = 3;
  final int maxTeeth = 15;
  final int[][] teethPlacement = {
          {ScalePos.scaleWidth(390), ScalePos.scaleHeight(230), ScalePos.scaleWidth(50), ScalePos.scaleHeight(50)},   // x, y, width, height 1st tooth
          {ScalePos.scaleWidth(445), ScalePos.scaleHeight(220), ScalePos.scaleWidth(50), ScalePos.scaleHeight(50)},   // x, y, width, height 2nd tooth
          {ScalePos.scaleWidth(490), ScalePos.scaleHeight(175), ScalePos.scaleWidth(130), ScalePos.scaleHeight(130)},  // x, y, width, height 3rd tooth
          {ScalePos.scaleWidth(625), ScalePos.scaleHeight(200), ScalePos.scaleWidth(120), ScalePos.scaleHeight(120)},  // x, y, width, height 4th tooth
          {ScalePos.scaleWidth(780), ScalePos.scaleHeight(190), ScalePos.scaleWidth(160), ScalePos.scaleHeight(160)},  // x, y, width, height 5th tooth
          {ScalePos.scaleWidth(980), ScalePos.scaleHeight(190), ScalePos.scaleWidth(160), ScalePos.scaleHeight(160)},  // x, y, width, height 6th tooth
          {ScalePos.scaleWidth(1172), ScalePos.scaleHeight(200), ScalePos.scaleWidth(120), ScalePos.scaleHeight(120)}, // x, y, width, height 7th tooth
          {ScalePos.scaleWidth(1310), ScalePos.scaleHeight(200), ScalePos.scaleWidth(95), ScalePos.scaleHeight(95)},   // x, y, width, height 8th tooth
          {ScalePos.scaleWidth(1420), ScalePos.scaleHeight(220), ScalePos.scaleWidth(50), ScalePos.scaleHeight(50)},   // x, y, width, height 9th tooth
          {ScalePos.scaleWidth(1475), ScalePos.scaleHeight(240), ScalePos.scaleWidth(50), ScalePos.scaleHeight(50)},   // x, y, width, height 10th tooth
          {ScalePos.scaleWidth(430), ScalePos.scaleHeight(490), ScalePos.scaleWidth(60), ScalePos.scaleHeight(60)},    // x, y, width, height 11th tooth
          {ScalePos.scaleWidth(480), ScalePos.scaleHeight(550), ScalePos.scaleWidth(60), ScalePos.scaleHeight(60)},    // x, y, width, height 12th tooth
          {ScalePos.scaleWidth(510), ScalePos.scaleHeight(610), ScalePos.scaleWidth(55), ScalePos.scaleHeight(55)},    // x, y, width, height 13th tooth
          {ScalePos.scaleWidth(525), ScalePos.scaleHeight(675), ScalePos.scaleWidth(75), ScalePos.scaleHeight(75)},    // x, y, width, height 14th tooth
          {ScalePos.scaleWidth(605), ScalePos.scaleHeight(765), ScalePos.scaleWidth(75), ScalePos.scaleHeight(75)},    // x, y, width, height 15th tooth
          {ScalePos.scaleWidth(710), ScalePos.scaleHeight(800), ScalePos.scaleWidth(95), ScalePos.scaleHeight(95)},    // x, y, width, height 16th tooth
          {ScalePos.scaleWidth(840), ScalePos.scaleHeight(810), ScalePos.scaleWidth(105), ScalePos.scaleHeight(105)},  // x, y, width, height 17th tooth
          {ScalePos.scaleWidth(975), ScalePos.scaleHeight(810), ScalePos.scaleWidth(105), ScalePos.scaleHeight(105)},  // x, y, width, height 18th tooth
          {ScalePos.scaleWidth(1115), ScalePos.scaleHeight(805), ScalePos.scaleWidth(95), ScalePos.scaleHeight(95)},   // x, y, width, height 19th tooth
          {ScalePos.scaleWidth(1235), ScalePos.scaleHeight(760), ScalePos.scaleWidth(85), ScalePos.scaleHeight(85)},   // x, y, width, height 20th tooth
          {ScalePos.scaleWidth(1305), ScalePos.scaleHeight(670), ScalePos.scaleWidth(85), ScalePos.scaleHeight(85)},   // x, y, width, height 21st tooth
          {ScalePos.scaleWidth(1375), ScalePos.scaleHeight(620), ScalePos.scaleWidth(65), ScalePos.scaleHeight(65)},   // x, y, width, height 22nd tooth
          {ScalePos.scaleWidth(1390), ScalePos.scaleHeight(550), ScalePos.scaleWidth(70), ScalePos.scaleHeight(70)},   // x, y, width, height 23rd tooth
          {ScalePos.scaleWidth(1425), ScalePos.scaleHeight(490), ScalePos.scaleWidth(60), ScalePos.scaleHeight(60)}    // x, y, width, height 24th tooth
  };

  //instance variables
  final ImageIcon plaqueImage1 = new ImageIcon("JR Dentistry/out/Images/plaque1.png");
  final ImageIcon plaqueImage2 = new ImageIcon("JR Dentistry/out/Images/plaque2.png");
  final ImageIcon plaqueImage3 = new ImageIcon("JR Dentistry/out/Images/plaque3.png");
  final ImageIcon plaqueImage4 = new ImageIcon("JR Dentistry/out/Images/plaque4.png");
  final ImageIcon[] plaqueImagesArr = {plaqueImage1, plaqueImage2, plaqueImage3, plaqueImage4};
  final ImageIcon mouthImage = ImageIconScaler.scaleImageIcon(new ImageIcon("JR Dentistry/out/Images/e.png"), ScreenInfo.screenWidth, ScreenInfo.screenHeight);
  final ImageIcon toolImage = ImageIconScaler.scaleImageIcon(new ImageIcon("JR Dentistry/out/Images/DentalTool.png"), 300, 300);
  int numTeeth;
  JFrame mainFrame;
  Plaque[] plaqueArr;
  int plaqueArrIndex;
  Tool t;
  JLabel toolLabel;
  JLayeredPane layeredFrame;
  int[] usedTeeth;
  int indexUsedTeeth;
  MouseMotionListener listener;
  JLabel mouthLabel;

  public MouthGUI() {
    initializeGameVariables();
    initializeGUI();
    mainFrame.setVisible(true);
    mainFrame.revalidate();
    mainFrame.repaint();
    layeredFrame.repaint();
    layeredFrame.revalidate();
    System.out.println("in MouthGUI, variables initialized");
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

    boolean run = true;
    runGame(run, t);
  }


  public int toothCheck(int tooth, int[] teethArray) {
    for (int i = 0; i < teethArray.length; i++) {
      if (tooth == teethArray[i]) {
        tooth = rand.nextInt(0, 24);
        tooth = toothCheck(tooth, teethArray);
        return tooth;
      }
    }
    return tooth;
  }

  public void runGame(boolean run, Tool t) {
    System.out.println("in runGame method");
    while (run) {
      delay(20);
      detect(t);
      if (gameOver()) {
        run = false;
        mainFrame.setVisible(false);
        System.exit(0);
      }
    }
    System.out.println("run boolean is false");
  }

  public void initializeGameVariables() {
    t = new Tool(1600, 400, 300, 300);
    toolLabel = new JLabel(toolImage);
    toolLabel.setBounds(1600, 400, 300, 300);

    mainFrame = new JFrame("gameFrame");
    SwingSetup.setupFrame(mainFrame, 0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight, false, null);

    layeredFrame = new JLayeredPane();
    layeredFrame.setPreferredSize(new Dimension(ScreenInfo.screenWidth, ScreenInfo.screenHeight));

    usedTeeth = new int[24];
    Arrays.fill(usedTeeth, -1);
    indexUsedTeeth = -1;

    numTeeth = rand.nextInt(minTeeth, maxTeeth+1);
    plaqueArr = new Plaque[maxTeeth];
    plaqueArrIndex = 0;

  }

  public void initializeGUI() {
    layeredFrame.addMouseMotionListener(this);
    listener = layeredFrame.getMouseMotionListeners()[0];

    layeredFrame.add(toolLabel, JLayeredPane.PALETTE_LAYER);

    mouthLabel = new JLabel(mouthImage);
    mouthLabel.setBounds(0, 0, ScreenInfo.screenWidth, ScreenInfo.screenHeight);
    layeredFrame.add(mouthLabel, JLayeredPane.DEFAULT_LAYER);

    mainFrame.setContentPane(layeredFrame);

    mainFrame.setVisible(true);
  }

  public static void delay(int mills) {
    try {
      Thread.sleep(mills);
    }catch (InterruptedException e){
    }
  }

  public void createPlaque(int tooth, JLabel label) {
    int x = teethPlacement[tooth][0];
    int y = teethPlacement[tooth][1];
    int width = teethPlacement[tooth][2];
    int height = teethPlacement[tooth][3];
    Plaque p = new Plaque(x, y, width, height, label);
    plaqueArr[plaqueArrIndex] = p;
    plaqueArrIndex++;
  }

  public boolean detect(Tool t) {
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

  public boolean gameOver() {
    for (int i = 0; i < plaqueArrIndex; i++) {
      if (plaqueArr[i].alive) {
        return false;
      }
    }
    delay(1000);
    return true;
  }
}

//TO DO LIST:
/*
make the game work the second time it runs
* */

