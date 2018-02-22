import processing.core.PApplet;

public class Simulation extends PApplet{
    public static void main(String[] args) {
        PApplet.main("Simulation");
        //String ver = System.getProperty("java.version");
        //System.out.println(ver);
    }

    int gridSize;

    public void settings(){
        size(1280,800);
    }

    public void setup(){
        background(255);
        gridSize = width/16;
    }

    public void draw(){
      background(255);
      drawGrid();
      drawB(2, 1, 9, 4);    //Filter Magnetfeld
      drawB(12, 1, 4, 9);   //Ablenk Magnetfeld
      drawE(2, 0, 9, 5);

      fill(65);                                                                             //Schirm
      rect(width-height/2-gridSize/8, 0, gridSize/8, gridSize*2.45f);                       //  --
      rect(width-height/2-gridSize/8, gridSize*2.55f, gridSize/8, height-gridSize*2.55f);   //  --

      line(0, height/2, width, height/2);
      //line(width-height/2, 0, width-height/2, height);
    }

    void drawGrid(){
      fill(0);
      strokeWeight(2);
      for (int i = 0; i <= 17; i++) {
        for (int j = 0; j <= 10; j++) {
          point(gridSize*i, gridSize*j);
        }
      }
    }

    void drawB(int startXG, int startYG, int widthG, int heightG){
      fill(65);
      strokeWeight(2);
      for (int i = startXG; i < startXG+widthG; i++) {
        for (int j = startYG; j < startYG+heightG; j++) {
          line((gridSize*i)-5, (gridSize*j)-5, (gridSize*i)+5, (gridSize*j)+5);
          line((gridSize*i)+5, (gridSize*j)-5, (gridSize*i)-5, (gridSize*j)+5);
          point(gridSize*i, gridSize*j);
        }
      }
    }

    void drawE(int startXG, int startYG, int widthG, int heightG){
      float pkWidth = gridSize/4;

      fill(65);
      strokeWeight(2);
      stroke(0, 80);
      for (int i = startXG; i < startXG+widthG-1; i++) {
        line(gridSize*i+gridSize/2, gridSize*startYG+pkWidth, gridSize*i+gridSize/2, gridSize*(startYG+heightG)-pkWidth);
        line(gridSize*i+gridSize/2-5, gridSize*(startYG+heightG)-pkWidth-10, gridSize*i+gridSize/2, gridSize*(startYG+heightG)-pkWidth);
        line(gridSize*i+gridSize/2+5, gridSize*(startYG+heightG)-pkWidth-10, gridSize*i+gridSize/2, gridSize*(startYG+heightG)-pkWidth);
      }
      stroke(0);

      strokeWeight(1);
      fill(200, 0, 0);
      rect(gridSize*startXG, gridSize*startYG, gridSize*(widthG-1), pkWidth);                             //Obere Kondensatorplatte
      fill(0, 0, 200);
      rect(gridSize*startXG, gridSize*heightG-pkWidth, gridSize*(widthG-1), pkWidth);      //Untere Kondensatorplatte
    }

}
