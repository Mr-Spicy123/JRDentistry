package Misc;

public class Tool {

  int x, y, width, height;
  public static boolean intersecting;

  public Tool(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public Tool() {
    this(0, 0, 0, 0);
  }

  public boolean intersects(Plaque p) {
    //these two if statements create a sort of "hit box"
    if (this.x >= p.x && this.x <= p.x+p.width) {
      if (this.y >= p.y && this.y <= p.y+p.height) {
        intersecting = true;
        return true;
      }
    }
    intersecting = false;
    return false;
  }

  public void update(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
