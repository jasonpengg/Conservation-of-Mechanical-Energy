import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class ballpanel extends JPanel{
    // Properties 
    int intX = 100;
    int intY = 400;
    int intYMax = 401;
    double dblY = 0;

    int intVel = 0;
    double dblTime = 0;
    double dblFPS = 0;
    double dblPosition;
    BufferedImage imgRuler = null;
    boolean blnMove = false;
    double dblHeight = 0; 
    
    boolean blnMaxHeight = false;
    double dblMaxHeight = 0;
    
    // Methods
    // override how JComponent is painted 
    public void paintComponent(Graphics g){
		//System.out.println(blnMove);
		//System.out.println(dblTime);
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960, 540);
		
		//Boundaries of the ball (can be deleted) 
		g.setColor(Color.RED);
		g.fillRect(0,400,300, 3);
		//g.fillRect(0,50,200, 1);
		
		//For movement of the ball and bar 
		g.setColor(Color.RED);
		g.fillOval(intX,intY, 20, 20);
		g.fillRect(0,intYMax,300, 1);
		g.drawImage(imgRuler, 0, 41, null);

		// Height in Metres (for label)
		dblHeight = -Math.round((4.9*dblTime*dblTime + intVel*dblTime)*100.0)/100.0;
		//System.out.println(dblHeight);
		//Position for X-Y Coord for planting ball and lines, converts to int
		dblPosition = (4.9*dblTime*dblTime + intVel*dblTime)*10;
		intY = 400 + (int)Math.round(dblPosition);
		//System.out.println(intY);
		
		//Checks if the Y value is less than 0m, then stops the program so it doesn't keep falling past 0m
		if (intY > 400){
			//System.out.println("true");
			dblFPS = 0;
			intY = 400;
			blnMove = false;
			dblHeight = 0 ;
		}
		//This is for the bar that raises
		if (intYMax > intY){
			intYMax = intY;
		}
		// This is for checking Max Height
		if (intYMax < intY){
			blnMaxHeight = true;
			dblMaxHeight = dblHeight;
		}
		
		//The entire program stops if this is false, since everything is Time dependant
		if(blnMove == true){
			dblFPS = dblFPS + (1000.0/48.0);
			dblTime = dblFPS/1000.0;
		}
		
    }


    //Constructor
    public ballpanel (){
		try{
            imgRuler = ImageIO.read(new File("35m.png"));
        }catch (IOException e){
            System.out.println("cannot load image");
        }
       
    }
}
