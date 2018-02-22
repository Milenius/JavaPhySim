import processing.core.PApplet;

public class Simulation extends PApplet{
    public static void main(String[] args) {
        PApplet.main("Simulation");
        //String ver = System.getProperty("java.version");
        //System.out.println(ver);
    }

    int gridSize;

    public void settings(){
        size(1280,720);
    }

    public void setup(){
        background(255);
        gridSize = width/16;
    }

    public void draw(){
        drawGrid();
    }

    void drawGrid(){
      fill(65);
      strokeWeight(5);
      for (int i = 0; i <= 16; i++) {
        for (int j = 0; j <= 9; j++) {
          point(gridSize*i, gridSize*j);
        }
      }
    }

}
