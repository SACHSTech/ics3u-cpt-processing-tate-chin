import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  PImage player;
  float playerX = 275;
  float playerY = 400;
  float playerX1 = 600;
  float playerY1 = 275;
  float playerX2 = 0;
  float playerY2 = 50;
  float speed = 4;
  float gravity = 3;
  float jump = 10;
  
  boolean keyLeft, keyRight, keyUp;
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
    image(player, playerX, playerY, width/15, height/15);
    
    stroke(0);
    fill(225);

    rect(275, 500, 50, 5);
    rect(405, 470, 50, 5);
    rect(455, 380, 50, 5);
    rect(400, 270, 50, 5);
    rect(380, 170, 50, 5);
    rect(300, 110, 50, 5);
    rect(400, 70, 50, 5);
    rect(550, 500, 50, 5);

    rect(200, 100, 15, 500);

    rect(185, 100, 50, 5);
    rect(100, 30, 50, 5);
    rect(0, 75, 50, 5);
    rect(50, 180, 50, 5);
    rect(40, 290, 50, 5);
    rect(120, 420, 50, 5);

    rect(550, 75, 50, 5);
    rect(0, 500, 50, 5);

    stroke(138, 56, 33);
    fill(138, 56, 33);

    rect(575, 25, 25, 50);
    rect(0, 450, 25, 50);

    if(playerX < 0 && playerY < 550 && playerY > 400){
      isOnLeftSide = true;
      isOnRightSide = false;
      isOnMiddleSide = false;
      background(254, 207, 255);

      stroke(0);
      fill(225);
  
      rect(275, 500, 50, 5);
      rect(405, 470, 50, 5);
      rect(455, 380, 50, 5);
      rect(400, 270, 50, 5);
      rect(380, 170, 50, 5);
      rect(300, 110, 50, 5);
      rect(400, 70, 50, 5);
      rect(550, 500, 50, 5);
  
      rect(200, 100, 15, 500);
  
      rect(185, 100, 50, 5);
      rect(100, 30, 50, 5);
      rect(0, 75, 50, 5);
      rect(50, 180, 50, 5);
      rect(40, 290, 50, 5);
      rect(120, 420, 50, 5);
      
  
      rect(550, 75, 50, 5);
      rect(0, 500, 50, 5);
  
      stroke(138, 56, 33);
      fill(138, 56, 33);
  
      rect(575, 450, 25, 50);

      image(player, playerX + 600, playerY, width/15, height/15);

      if (playerX > 245 && playerX < 315 && playerY > 465 && playerY < 470) {
        playerY = 465;
      }
      if (playerX > 375 && playerX < 445 && playerY > 435 && playerY < 440) {
        playerY = 435;
      } 
      if (playerX > 425 && playerX < 495 && playerY > 345 && playerY < 350) {
        playerY = 345;
      }
      if (playerX > 370 && playerX < 440 && playerY > 235 && playerY < 240) {
        playerY = 235;
      }
      if (playerX > 350 && playerX < 420 && playerY > 135 && playerY < 140) {
        playerY = 135;
      }
      if (playerX > 270 && playerX < 340 && playerY > 75 && playerY < 80) {
        playerY = 75;
      }
      if (playerX > 370 && playerX < 440 && playerY > 35 && playerY < 40) {
        playerY = 35;
      }
      if (playerX > 520 && playerX < 590 && playerY > 465 && playerY < 470) {
        playerY = 465;
      }
  
      // fix later
      if (playerX > 170 && playerX < 200 && playerY > 65) {
          playerY = 65;
      }
  
      if (playerX > 155 && playerX < 225 && playerY > 65 && playerY < 70) {
        playerY = 65;
      }
      if (playerX > 70 && playerX < 140 && playerY > -5 && playerY < 0) {
        playerY = -5;
      }
      if (playerX > -30 && playerX < 40 && playerY > 40 && playerY < 45) {
        playerY = 40;
      }
      if (playerX > 20 && playerX < 90 && playerY > 145 && playerY < 150) {
        playerY = 145;
      }
      if (playerX > 10 && playerX < 80 && playerY > 255 && playerY < 260) {
        playerY = 255;
      }
      if (playerX > 90 && playerX < 160 && playerY > 385 && playerY < 390) {
        playerY = 385;
      }
  
      if (playerX > 520 && playerX < 590 && playerY > 30 && playerY < 35) {
        playerY = 30;
      }
      if (playerX > -30 && playerX < 40 && playerY > 465 && playerY < 470) {
        playerY = 465;
      }

    }
    else if(playerX > width && playerY > 0 && playerY < 100){
      isOnRightSide = true;
      isOnLeftSide = false;
      isOnMiddleSide = false;
      background(208, 255, 163);

      stroke(0);
      fill(225);
  
      rect(275, 500, 50, 5);
      rect(405, 470, 50, 5);
      rect(455, 380, 50, 5);
      rect(400, 270, 50, 5);
      rect(380, 170, 50, 5);
      rect(300, 110, 50, 5);
      rect(400, 70, 50, 5);
      rect(550, 500, 50, 5);
  
      rect(200, 100, 15, 500);
  
      rect(185, 100, 50, 5);
      rect(100, 30, 50, 5);
      rect(0, 75, 50, 5);
      rect(50, 180, 50, 5);
      rect(40, 290, 50, 5);
      rect(120, 420, 50, 5);
      
  
      rect(550, 75, 50, 5);
      rect(0, 500, 50, 5);
  
      stroke(138, 56, 33);
      fill(138, 56, 33);
  
      rect(0, 25, 25, 50);

      image(player, playerX - 600, playerY, width/15, height/15);

      if (playerX > 245 && playerX < 315 && playerY > 465 && playerY < 470) {
        playerY = 465;
      }
      if (playerX > 375 && playerX < 445 && playerY > 435 && playerY < 440) {
        playerY = 435;
      } 
      if (playerX > 425 && playerX < 495 && playerY > 345 && playerY < 350) {
        playerY = 345;
      }
      if (playerX > 370 && playerX < 440 && playerY > 235 && playerY < 240) {
        playerY = 235;
      }
      if (playerX > 350 && playerX < 420 && playerY > 135 && playerY < 140) {
        playerY = 135;
      }
      if (playerX > 270 && playerX < 340 && playerY > 75 && playerY < 80) {
        playerY = 75;
      }
      if (playerX > 370 && playerX < 440 && playerY > 35 && playerY < 40) {
        playerY = 35;
      }
      if (playerX > 520 && playerX < 590 && playerY > 465 && playerY < 470) {
        playerY = 465;
      }
  
      // fix later
      if (playerX > 170 && playerX < 200 && playerY > 65) {
          playerY = 65;
      }
  
      if (playerX > 155 && playerX < 225 && playerY > 65 && playerY < 70) {
        playerY = 65;
      }
      if (playerX > 70 && playerX < 140 && playerY > -5 && playerY < 0) {
        playerY = -5;
      }
      if (playerX > -30 && playerX < 40 && playerY > 40 && playerY < 45) {
        playerY = 40;
      }
      if (playerX > 20 && playerX < 90 && playerY > 145 && playerY < 150) {
        playerY = 145;
      }
      if (playerX > 10 && playerX < 80 && playerY > 255 && playerY < 260) {
        playerY = 255;
      }
      if (playerX > 90 && playerX < 160 && playerY > 385 && playerY < 390) {
        playerY = 385;
      }
  
      if (playerX > 520 && playerX < 590 && playerY > 30 && playerY < 35) {
        playerY = 30;
      }
      if (playerX > -30 && playerX < 40 && playerY > 465 && playerY < 470) {
        playerY = 465;
      }
  
    }
    
    // GRAVITY
    playerY+=3;

    // COLLISIONS WITH PLATFORMS
    if (playerX > 245 && playerX < 315 && playerY > 465 && playerY < 470) {
      playerY = 465;
    }
    if (playerX > 375 && playerX < 445 && playerY > 435 && playerY < 440) {
      playerY = 435;
    } 
    if (playerX > 425 && playerX < 495 && playerY > 345 && playerY < 350) {
      playerY = 345;
    }
    if (playerX > 370 && playerX < 440 && playerY > 235 && playerY < 240) {
      playerY = 235;
    }
    if (playerX > 350 && playerX < 420 && playerY > 135 && playerY < 140) {
      playerY = 135;
    }
    if (playerX > 270 && playerX < 340 && playerY > 75 && playerY < 80) {
      playerY = 75;
    }
    if (playerX > 370 && playerX < 440 && playerY > 35 && playerY < 40) {
      playerY = 35;
    }
    if (playerX > 520 && playerX < 590 && playerY > 465 && playerY < 470) {
      playerY = 465;
    }

    // fix later
    if (playerX > 170 && playerX < 200 && playerY > 65) {
        playerY = 65;
    }

    if (playerX > 155 && playerX < 225 && playerY > 65 && playerY < 70) {
      playerY = 65;
    }
    if (playerX > 70 && playerX < 140 && playerY > -5 && playerY < 0) {
      playerY = -5;
    }
    if (playerX > -30 && playerX < 40 && playerY > 40 && playerY < 45) {
      playerY = 40;
    }
    if (playerX > 20 && playerX < 90 && playerY > 145 && playerY < 150) {
      playerY = 145;
    }
    if (playerX > 10 && playerX < 80 && playerY > 255 && playerY < 260) {
      playerY = 255;
    }
    if (playerX > 90 && playerX < 160 && playerY > 385 && playerY < 390) {
      playerY = 385;
    }

    if (playerX > 520 && playerX < 590 && playerY > 30 && playerY < 35) {
      playerY = 30;
    }
    if (playerX > -30 && playerX < 40 && playerY > 465 && playerY < 470) {
      playerY = 465;
    }

    // DRAWING SPIKES
    stroke(235, 52, 70);
    fill(235, 52, 70);

    for (float i = 0; i < 25; i++) {
      triangle(i * 24, 600, (i * 24) + 12, 550, (i + 1) * 24, 600);
    }

    // IF PLAYER HITS A SPIKE THEN IT TRIGGERS A GAME OVER SCREEN
    if(playerY > 550){
      background(0);
      text("Game Over", 300, 300);
      text("Restart The Screen", 300, 400);
      
    }
    // Circle Collections
    stroke(0);
    fill(50, 168, 82);

    //ellipse(210, 80, 10, 20);
    //ellipse(25, 55, 10, 20);

  }

  void changePosition() {
    if(keyLeft) playerX-=speed;
    if(keyRight) playerX+=speed;
    if(keyUp) playerY-=jump;
  }

  @Override
  public void keyPressed() {
  
      if(keyCode == LEFT) {
        keyLeft = true;
      }
      else if(keyCode == RIGHT) {
        keyRight = true;
      }
      else if (keyCode == UP) {
        keyUp = true;
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
    else if (keyCode == UP) {
      keyUp = false;
    }
      super.keyReleased();
  }
}