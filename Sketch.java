/*
-------------------------------------------------------------------------------
Name:		Sketch.java
Purpose:	Main game functionality goes in here
Author:	  Tate Chin, Angel Lin
Created: 22/1/2020
------------------------------------------------------------------------------
*/

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  // VARIABLES FOR GAME MECHANICS
  PImage player;
  float playerX = 275;
  float playerY = 400;
  float speed = 4;
  float gravity = 3;
  float jump = 20;

  // COORDINATES OF THE OBJECTS TO COLLECT
  float C1X = 25;
  float C1Y = 50;
  float C2X = 25;
  float C2Y = 475;
  float C3X = 575;
  float C3Y = 50;
  
  // BOOLEAN VALUES
  boolean[] collectables = {true, true, true};
  boolean keyLeft, keyRight, keyUp;
  boolean isOnLeftSide = false;
  boolean isOnRightSide = false;
  boolean isOnMiddleSide = true;
  boolean isOnPlatform = false;
  
  // RAIN MECHANICS ARRAY
  float[] circleY = new float[25];

  // JUMP TIMER TO PREVENT PEOPLE FROM JUMPING IN MIDAIR
  int timer = 1000;

  // SETTING SIZE TO 600,600 SCREEN
  public void settings() {
    size(600, 600);
  }

  public void setup() {
    // DRAWING THE PLAYER (HE'S BIG FLOPPA SO CUTE)
    player = loadImage("floppa.png");
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }
  }

  public void draw() {

    // SETTING THE BACKGROUND AND CALLING THE CHANGE POSITION FUNCTION
    background(201, 222, 255);
    changePosition();
   
    // JUMP TIMER INCREMENT
    timer +=1;
    
    // DRAWING PLAYER
    image(player, playerX, playerY, width/15, height/15);
    
    stroke(0);
    fill(225);

    // DRAWING THE PLATFORMS
    rect(275, 500, 50, 5);
    rect(405, 470, 50, 5);
    rect(455, 380, 50, 5);
    rect(400, 270, 50, 5);
    rect(380, 170, 50, 5);
    rect(300, 110, 50, 5);
    rect(400, 70, 50, 5);
    rect(550, 500, 50, 5);

    rect(185, 100, 50, 5);
    rect(100, 30, 50, 5);
    rect(0, 75, 50, 5);
    rect(50, 180, 50, 5);
    rect(40, 290, 50, 5);
    rect(120, 420, 50, 5);

    rect(550, 75, 50, 5);
    rect(0, 500, 50, 5);

    // GRAVITY
    playerY+=3;

    // COLLISIONS WITH PLATFORMS IN THE MIDDLE SCREEN
    if(playerX > 0 && playerX < width){

      isOnMiddleSide = true;
      isOnLeftSide = false;
      isOnRightSide = false;
      isOnPlatform = false;
      if (playerX > 245 && playerX < 315 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      } 
      if (playerX > 375 && playerX < 445 && playerY > 435 && playerY < 440) {
        playerY = 435;
        isOnPlatform = true;
      } 
      if (playerX > 425 && playerX < 495 && playerY > 345 && playerY < 350) {
        playerY = 345;
        isOnPlatform = true;
      }
      if (playerX > 370 && playerX < 440 && playerY > 235 && playerY < 240) {
        playerY = 235;
        isOnPlatform = true;
      }
      if (playerX > 350 && playerX < 420 && playerY > 135 && playerY < 140) {
        playerY = 135;
        isOnPlatform = true;
      }
      if (playerX > 270 && playerX < 340 && playerY > 75 && playerY < 80) {
        playerY = 75;
        isOnPlatform = true;
      }
      if (playerX > 370 && playerX < 440 && playerY > 35 && playerY < 40) {
        playerY = 35;
        isOnPlatform = true;
      }
      if (playerX > 520 && playerX < 590 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }
  
      if (playerX > 155 && playerX < 225 && playerY > 65 && playerY < 70) {
        playerY = 65;
        isOnPlatform = true;
      }
      if (playerX > 70 && playerX < 140 && playerY > -5 && playerY < 0) {
        playerY = -5;
        isOnPlatform = true;
      }
      if (playerX > -30 && playerX < 40 && playerY > 40 && playerY < 45) {
        playerY = 40;
        isOnPlatform = true;
      }
      if (playerX > 20 && playerX < 90 && playerY > 145 && playerY < 150) {
        playerY = 145;
        isOnPlatform = true;
      }
      if (playerX > 10 && playerX < 80 && playerY > 255 && playerY < 260) {
        playerY = 255;
        isOnPlatform = true;
      }
      if (playerX > 90 && playerX < 160 && playerY > 385 && playerY < 390) {
        playerY = 385;
        isOnPlatform = true;
      }
  
      if (playerX > 520 && playerX < 590 && playerY > 40 && playerY < 45) {
        playerY = 40;
        isOnPlatform = true;
      }
      if (playerX > -30 && playerX < 40 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }

      // CIRCLE COLLECTION
      stroke(0);
      fill(50, 168, 82);

      ellipse(C1X, C1Y, 10, 20);

      if (playerX == 7 && playerY == 40) {
        collectables[0] = false;
      }
  
      if (collectables[0] == false) {
        C1X = C1X - 100;
        C1Y = C1Y - 100;
      }
    }

    if(playerX < 0){

      isOnLeftSide = true;
      isOnRightSide = false; 
      isOnMiddleSide = false;
      background(254, 207, 255);
      
      // DRAWING RAIN IN THIS PART OF THE MAP. 
      for (int i = 0; i < circleY.length; i++) {
        float circleX = width * i / circleY.length;
        ellipse(circleX, circleY[i], 5, 5);
    
        circleY[i]++;
    
        if (circleY[i] > height) {
          circleY[i] = 0;
        }
      }

      // SET JUMP TO LOWER SINCE IT IS RAINING
      jump = 15;
      
      stroke(0);
      fill(225);
      
      // REDRAWING PLATFORMS
      rect(275, 500, 50, 5);
      rect(405, 470, 50, 5);
      rect(455, 380, 50, 5);
      rect(400, 270, 50, 5);
      rect(380, 170, 50, 5);
      rect(300, 110, 50, 5);
      rect(400, 70, 50, 5);
      rect(550, 500, 50, 5);
 
      rect(185, 100, 50, 5);
      rect(100, 30, 50, 5);
      rect(0, 75, 50, 5);
      rect(50, 180, 50, 5);
      rect(40, 290, 50, 5);
      rect(120, 420, 50, 5);
  
      rect(550, 75, 50, 5);
      rect(0, 500, 50, 5);

      image(player, playerX + 600, playerY, width/15, height/15);

      // COLLISIONS WITH PLATFORMS IN THE LEFT SCREEN
      isOnPlatform = false;
      if (playerX > 245 - 600 && playerX < 315 - 600 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }
      if (playerX > 375 - 600 && playerX < 445 - 600 && playerY > 435 && playerY < 440) {
        playerY = 435;
        isOnPlatform = true;
      } 
      if (playerX > 425 - 600 && playerX < 495 - 600 && playerY > 345 && playerY < 350) {
        playerY = 345;
        isOnPlatform = true;
      }
      if (playerX > 370 - 600 && playerX < 440 - 600 && playerY > 235 && playerY < 240) {
        playerY = 235;
        isOnPlatform = true;
      }
      if (playerX > 350 - 600 && playerX < 420 - 600 && playerY > 135 && playerY < 140) {
        playerY = 135;
        isOnPlatform = true;
      }
      if (playerX > 270 - 600 && playerX < 340 - 600 && playerY > 75 && playerY < 80) {
        playerY = 75;
        isOnPlatform = true;
      }
      if (playerX > 370 - 600 && playerX < 440 - 600 && playerY > 35 && playerY < 40) {
        playerY = 35;
        isOnPlatform = true;
      }
      if (playerX > 520 -600 && playerX < 590 - 600 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }
      if (playerX > 155 - 600 && playerX < 225 - 600 && playerY > 65 && playerY < 70) {
        playerY = 65;
        isOnPlatform = true;
      }
      if (playerX > 70 - 600 && playerX < 140 - 600 && playerY > -5 && playerY < 0) {
        playerY = -5;
        isOnPlatform = true;
      }
      if (playerX > -30  - 600 && playerX < 40 - 600 && playerY > 40 && playerY < 45) {
        playerY = 40;
        isOnPlatform = true;
      }
      if (playerX > 20 - 600 && playerX < 90 - 600 && playerY > 145 && playerY < 150) {
        playerY = 145;
        isOnPlatform = true;
      }
      if (playerX > 10- 600 && playerX < 80 - 600&& playerY > 255 && playerY < 260) {
        playerY = 255;
        isOnPlatform = true;
      }
      if (playerX > 90 - 600 && playerX < 160 - 600 && playerY > 385 && playerY < 390) {
        playerY = 385;
        isOnPlatform = true;
      }
      if (playerX > 520 - 600 && playerX < 590 - 600 && playerY > 40 && playerY < 45) {
        playerY = 40;
        isOnPlatform = true;
      }
      if (playerX > -30 - 600 && playerX < 40 - 600 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }

      // SETTING JUMP TO LOWER SINCE IT'S RAINING
      if(isOnLeftSide = true){
        jump = 15;
      }

      // CIRCLE COLLECTION
      stroke(0);
      fill(50, 168, 82);

      ellipse(C2X, C2Y, 10, 20);

      if (playerX == -597 && playerY == 465) {
        collectables[1] = false;
      }
    
      if (collectables[1] == false) {
        C2X = C2X - 100;
        C2Y = C2Y - 100;
      }

    }
    
    // RIGHT SIDE OF THE MAP
    else if(playerX > width){
      isOnRightSide = true;
      isOnLeftSide = false;
      isOnMiddleSide = false;
      background(208, 255, 163);

      // RAIN
      for (int i = 0; i < circleY.length; i++) {
        float circleX = width * i / circleY.length;
        ellipse(circleX, circleY[i], 5, 5);
    
        circleY[i]++;
    
        if (circleY[i] > height) {
          circleY[i] = 0;
        }
      }

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
  
      rect(185, 100, 50, 5);
      rect(100, 30, 50, 5);
      rect(0, 75, 50, 5);
      rect(50, 180, 50, 5);
      rect(40, 290, 50, 5);
      rect(120, 420, 50, 5);
    
      rect(550, 75, 50, 5);
      rect(0, 500, 50, 5);

      image(player, playerX - 600, playerY, width/15, height/15);

      // COLLISIONS WITH PLATFORMS IN THE LEFT SCREEN
      isOnPlatform = false;
      if (playerX > 245 + 600 && playerX < 315 + 600 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }
      if (playerX > 375 + 600 && playerX < 445 + 600 && playerY > 435 && playerY < 440) {
        playerY = 435;
        isOnPlatform = true;
      } 
      if (playerX > 425 + 600 && playerX < 495 + 600&& playerY > 345 && playerY < 350) {
        playerY = 345;
        isOnPlatform = true;
      }
      if (playerX > 370 + 600 && playerX < 440 + 600 && playerY > 235 && playerY < 240) {
        playerY = 235;
        isOnPlatform = true;
      }
      if (playerX > 350 + 600 && playerX < 420 + 600 && playerY > 135 && playerY < 140) {
        playerY = 135;
        isOnPlatform = true;
      }
      if (playerX > 270 + 600 && playerX < 340 + 600 && playerY > 75 && playerY < 80) {
        playerY = 75;
        isOnPlatform = true;
      }
      if (playerX > 370 + 600 && playerX < 440 + 600 && playerY > 35 && playerY < 40) {
        playerY = 35;
        isOnPlatform = true;
      }
      if (playerX > 520 + 600 && playerX < 590 + 600 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }
  
  
      if (playerX > 155 + 600 && playerX < 225 + 600 && playerY > 65 && playerY < 70) {
        playerY = 65;
        isOnPlatform = true;
      }
      if (playerX > 70 + 600 && playerX < 140 + 600 && playerY > -5 && playerY < 0) {
        playerY = -5;
        isOnPlatform = true;
      }
      if (playerX > -30 + 600 && playerX < 40 + 600 && playerY > 40 && playerY < 45) {
        playerY = 40;
        isOnPlatform = true;
      }
      if (playerX > 20 + 600 && playerX < 90 + 600 && playerY > 145 && playerY < 150) {
        playerY = 145;
        isOnPlatform = true;
      }
      if (playerX > 10 + 600 && playerX < 80 + 600 && playerY > 255 && playerY < 260) {
        playerY = 255;
        isOnPlatform = true;
      }
      if (playerX > 90 + 600 && playerX < 160 + 600 && playerY > 385 && playerY < 390) {
        playerY = 385;
        isOnPlatform = true;
      }
  
      if (playerX > 520 + 600 && playerX < 590 + 600 && playerY > 40 && playerY < 45) {
        playerY = 40;
        isOnPlatform = true;
      }
      if (playerX > -30 + 600 && playerX < 40 + 600 && playerY > 465 && playerY < 470) {
        playerY = 465;
        isOnPlatform = true;
      }

       // SET JUMP TO LOWER SINCE IT IS RAINING
       if(isOnRightSide = true){
        jump = 15;
       }

       // CIRCLE COLLECTION
       stroke(0);
       fill(50, 168, 82);
   
       ellipse(C3X, C3Y, 10, 20);
       
       if (playerX == 1147 && playerY == 40) {
        collectables[2] = false;
      }
      
      if (collectables[2] == false) {
        C3X = C3X - 100;
        C3Y = C3Y - 100;
      }

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

    // SET JUMP HIGHER ON THE MIDDLE SCREEN
    if(isOnMiddleSide == true){
      jump = 20;
    }

    // PREVENTS THE PLAYER FROM GOING OFF THE SCREEN
    if(playerX < -605){
      playerX = -605;
    }
    
    if(playerX > 1163){
      playerX = 1163;  
    }

    System.out.println(isOnPlatform);

    // TRIGGER THE GAME END
    gameEnd();

  }

  // METHODS GO HERE
  
   /**
    * Triggers the winning screen 
    */
  void gameEnd() {
    if (collectables[0] == false && collectables[1] == false && collectables[2] == false) {
      background(0);
      text("You Won", 300, 300);
    }
  }

   /**
    * Changes the position of the player when certain keys are pressed
    */
  void changePosition() {
    // PLAYER MOVEMENT
    if(keyLeft) playerX-=speed;
    if(keyRight) playerX+=speed;

    // IF THE PLAYER IS ON A PLATFORM ALLOW THEM TO JUMP
    if(isOnPlatform && keyUp){
      playerY-=jump;
      timer = 0;
    } 

    if(timer < 10) {
      playerY -= jump;
      
    }
    
  }

   /**
    * Function to check if a key is pressed
    *
    */
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
   /**
    * Function to check if a key is released
    */
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