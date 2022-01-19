import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {
	
  PImage player;
  float playerX = 300;
  float playerY = 70;
  float speed = 6;
  float gravity = 3;
  
  boolean keyLeft, keyRight;
  boolean isOnLeftSide = false;
  boolean isOnRightSide = false;
  boolean isOnMiddleSide = true;
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

    stroke(0);
    fill(225);
    
    // DRAWING PLAYER
    image(player, playerX, playerY, width/7, height/7);
    
    rect(100, 100, 100, 10);
    rect(300, 150, 100, 10);
    rect(200, 300, 100, 10);
    rect(150, 400, 100, 10);
    rect(450, 300, 100, 10);
    rect(300, 500, 100, 10);

    if(playerX < 0){
      isOnLeftSide = true;
      isOnRightSide = false;
      isOnMiddleSide = false;
      background(254, 207, 255);

      rect(100, 100, 100, 10);
      rect(300, 150, 100, 10);
      rect(200, 300, 100, 10);
      rect(150, 400, 100, 10);
      rect(450, 300, 100, 10);
      rect(300, 500, 100, 10);

    }
    else if(playerX > width){
      isOnRightSide = true;
      isOnLeftSide = false;
      isOnMiddleSide = false;
      background(208, 255, 163);

      rect(100, 100, 100, 10);
      rect(300, 150, 100, 10);
      rect(200, 300, 100, 10);
      rect(150, 400, 100, 10);
      rect(450, 300, 100, 10);
      rect(300, 500, 100, 10);
      
    }
    
    // GRAVITY
    //playerY+=3;
    // COLLISIONS WITH PLATFORMS

    // DRAWING SPIKES
    stroke(235, 52, 70);
    fill(235, 52, 70);

    for (float i = 0; i < 25; i++) {
      triangle(i * 24, 600, (i * 24) + 12, 550, (i + 1) * 24, 600);
    }

    // IF PLAYER HITS A SPIKE THEN IT TRIGGERS A GAME OVER SCREEN
    if(playerY > 500){
      background(0);
      text("Game Over", 300, 300);
      text("Restart The Screen", 300, 400);
      
    }
    // Circle Collections
    stroke(0);
    fill(50, 168, 82);
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