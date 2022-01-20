import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  PImage player;
  float playerX = 275;
  float playerY = 450;
  float speed = 4;
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
    
    // DRAWING PLAYER
    image(player, playerX, playerY, width/12, height/12);
    
    stroke(0);
    fill(225);

    rect(275, 500, 50, 5);
    rect(350, 450, 50, 5);
    rect(455, 420, 50, 5);
    rect(455, 340, 50, 5);
    rect(400, 270, 50, 5);
    rect(500, 230, 50, 5);
    rect(380, 170, 50, 5);
    rect(300, 110, 50, 5);
    rect(400, 70, 50, 5);
    rect(550, 500, 50, 5);

    rect(200, 100, 15, 500);

    rect(185, 100, 50, 5);
    rect(100, 30, 50, 5);
    rect(0, 75, 50, 5);
    rect(20, 130, 50, 5);
    rect(50, 180, 50, 5);
    rect(140, 240, 50, 5);
    rect(40, 290, 50, 5);
    rect(70, 350, 50, 5);
    rect(120, 420, 50, 5);
    rect(80, 480, 50, 5);
    

    rect(550, 75, 50, 5);
    rect(0, 500, 50, 5);

    stroke(138, 56, 33);
    fill(138, 56, 33);

    rect(575, 25, 25, 50);
    rect(0, 450, 25, 50);

    /*
    rect(100, 100, 100, 10);
    rect(300, 150, 100, 10);
    rect(200, 300, 100, 10);
    rect(150, 400, 100, 10);
    rect(450, 300, 100, 10);
    rect(300, 500, 100, 10);
    */

    if(playerX < 0 && playerY < 550 && playerY > 400){
      isOnLeftSide = true;
      isOnRightSide = false;
      isOnMiddleSide = false;
      background(254, 207, 255);

      stroke(0);
      fill(225);
  
      rect(275, 500, 50, 5);
      rect(350, 450, 50, 5);
      rect(455, 420, 50, 5);
      rect(455, 340, 50, 5);
      rect(400, 270, 50, 5);
      rect(500, 230, 50, 5);
      rect(380, 170, 50, 5);
      rect(300, 110, 50, 5);
      rect(400, 70, 50, 5);
      rect(550, 500, 50, 5);
  
      rect(200, 100, 15, 500);
  
      rect(185, 100, 50, 5);
      rect(100, 30, 50, 5);
      rect(0, 75, 50, 5);
      rect(20, 130, 50, 5);
      rect(50, 180, 50, 5);
      rect(140, 240, 50, 5);
      rect(40, 290, 50, 5);
      rect(70, 350, 50, 5);
      rect(120, 420, 50, 5);
      rect(80, 480, 50, 5);
      
  
      rect(550, 75, 50, 5);
      rect(0, 500, 50, 5);
  
      stroke(138, 56, 33);
      fill(138, 56, 33);
  
      rect(575, 450, 25, 50);

      image(player, playerX + 600, playerY, width/12, height/12);

    }
    else if(playerX > width && playerY > 0 && playerY < 100){
      isOnRightSide = true;
      isOnLeftSide = false;
      isOnMiddleSide = false;
      background(208, 255, 163);

      stroke(0);
      fill(225);
  
      rect(275, 500, 50, 5);
      rect(350, 450, 50, 5);
      rect(455, 420, 50, 5);
      rect(455, 340, 50, 5);
      rect(400, 270, 50, 5);
      rect(500, 230, 50, 5);
      rect(380, 170, 50, 5);
      rect(300, 110, 50, 5);
      rect(400, 70, 50, 5);
      rect(550, 500, 50, 5);
  
      rect(200, 100, 15, 500);
  
      rect(185, 100, 50, 5);
      rect(100, 30, 50, 5);
      rect(0, 75, 50, 5);
      rect(20, 130, 50, 5);
      rect(50, 180, 50, 5);
      rect(140, 240, 50, 5);
      rect(40, 290, 50, 5);
      rect(70, 350, 50, 5);
      rect(120, 420, 50, 5);
      rect(80, 480, 50, 5);
      
  
      rect(550, 75, 50, 5);
      rect(0, 500, 50, 5);
  
      stroke(138, 56, 33);
      fill(138, 56, 33);
  
      rect(0, 25, 25, 50);

      image(player, playerX - 600, playerY, width/12, height/12);
  
    }
    
    // GRAVITY
    // playerY+=3;

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