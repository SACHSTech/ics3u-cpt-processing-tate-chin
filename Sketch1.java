import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
	
  PImage player;
  float playerX = 300;
  float playerY = 70;
  float speed = 6;
  float gravity = 5;

  boolean movingRight = false;

  public void settings() {
    size(600, 600);
  }

  public void setup() {
    // PLAYER
    player = loadImage("floppa.png");
  }

  public void draw() {
    background(201, 222, 255);

    // DRAWING PLATFORMS
    rect(100, 100, 100, 10);
    rect(300, 150, 100, 10);
    rect(200, 300, 100, 10);
    rect(150, 400, 100, 10);
    
    // DRAWING PLAYER
    image(player, playerX, playerY, width/7, height/7);
    
    // GRAVITY
    playerY+=gravity;
    
  }

  @Override
  public void keyPressed() {
      
      if(keyCode == LEFT){
        playerX -= speed;
      }
      else if(keyCode == RIGHT){
        playerX += speed;
        movingRight = true;
      }
      super.keyPressed();
  }
  @Override
  public void keyReleased() {

      movingRight = false;
      super.keyReleased();
  }
}
