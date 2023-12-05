import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ballpanel extends JPanel{
	// Properties 
	int intX = 100;
	int intY = 400;
	int intVel = 0;
	double dblTime = 0;
	double dblFPS = 0;
	double dblPosition = 0;;
	BufferedImage imgRuler = null;
	boolean blnMove = false;
	double dblHeight = 0; 
	int intYMax = 401;
	boolean blnMaxHeight = false;
	double dblMaxHeight = 0;
	
	// Methods
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960, 540); 
		g.setColor(Color.RED);
		g.fillRect(0,400,300, 3);
		g.setColor(Color.RED);
		g.fillOval(intX,intY, 20, 20);
		g.fillRect(0,intYMax,300, 1);
		g.drawImage(imgRuler, 0, 41, null);

		// Height in Metres (for label)
		dblHeight = -Math.round((4.9*dblTime*dblTime + intVel*dblTime)*100.0)/100.0;
		dblPosition = (4.9*dblTime*dblTime + intVel*dblTime)*10;
		intY = 400 + (int)Math.round(dblPosition);
		
		//Checks if the Y value is less than 0m, then stops the program so it doesn't keep falling past 0m
		if (intY > 400){
			dblFPS = 0;
			intY = 400;
			blnMove = false;
			dblHeight = 0 ;
		}
		//Checks for max Y value
		if (intYMax > intY){
			intYMax = intY;
		}
		// This is for checking Max Height
		if (intYMax < intY){
			blnMaxHeight = true;
			dblMaxHeight = dblHeight;
		}
		//Checks if the fire button is clicked
		if(blnMove == true){
			dblFPS = dblFPS + (1000.0/30.0);
			dblTime = dblFPS/1000.0;
		}
	}
	//Constructor
	public ballpanel(){
		InputStream imageclass = null;
		imageclass = this.getClass().getResourceAsStream("35m.png");
		if(imageclass != null){
			try{
				imgRuler = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image file from jar");
			}
		}
		if(imgRuler == null){
			try{
				imgRuler = ImageIO.read(new File("35m.png"));
			}catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
	}
}
