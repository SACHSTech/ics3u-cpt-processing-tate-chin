import processing.core.PApplet;

/**
 * Main class to execute sketch
 * @author 
 *
 */
class Main {
  public static void main(String[] args) {
    
    String[] processingArgs = {"MySketch"};
	  //Sketch mySketch = new Sketch();  
	  // Sketch2 mySketch = new Sketch2();
	Sketch1 mySketch = new Sketch1();  // uncomment this to run this sketch file
	  
	  PApplet.runSketch(processingArgs, mySketch);
  }
  
}
