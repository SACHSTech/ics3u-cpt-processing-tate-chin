import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
	
  PImage player;
  float playerX = 300;
  float playerY = 70;
  float speed = 6;
  float gravity = 3;

  boolean keyLeft, keyRight;

  public void settings() {
    size(600, 600);
  }

  public void setup() {
    // PLAYER
    player = loadImage("floppa.png");
  }

  public void draw() {
    background(201, 222, 255);

    changePosition();
    // DRAWING PLATFORMS
    rect(100, 100, 100, 10);
    rect(300, 150, 100, 10);
    rect(200, 300, 100, 10);
    rect(150, 400, 100, 10);
    rect(450, 300, 100, 10);
    rect(300, 500, 100, 10);
    
    // DRAWING PLAYER
    image(player, playerX, playerY, width/7, height/7);
    
    // GRAVITY
    
    // COLLISIONS WITH PLATFORMS

    // DRAWING SPIKES
    stroke(0);
    triangle(0, 600, 100, 550, 125, 600);
    triangle(125, 600, 200, 550, 250, 600);
    triangle(250, 600, 300, 550, 370, 600);
    triangle(375, 600, 400, 550, 450, 600);
    triangle(470, 600, 500, 550, 600, 600);

    // IF PLAYER HITS A SPIKE THEN IT TRIGGERS A GAME OVER SCREEN
    if(playerY > 500){
      background(0);
      text("Game Over", 300, 300);
      text("Restart The Screen", 300, 400);
      
    }
  }

  void changePosition() {
    if(keyLeft) playerX-=speed;
    if(keyRight) playerX+=speed;
  }

  @Override
  public void keyPressed() {
  
      if(keyCode == LEFT){
        keyLeft = true;
      }
      else if(keyCode == RIGHT){
        keyRight = true;
      }
      super.keyPressed();
  }
  @Override
  public void keyReleased() {

    if (keyCode == LEFT) {
      keyLeft = false;
    }
    else if (keyCode == RIGHT) {
      keyRight = false;
    }
      super.keyReleased();
  }
}
