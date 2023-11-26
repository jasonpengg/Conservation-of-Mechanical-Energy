import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class ballpanel extends JPanel{
    // Properties 
    int intX = 100;
    int intY = 400;
    double dblY = 0;
    int intDefx = 0;
    int intDefy = 5;


    int intHomerX = 500;
    int intHomerY = 100;
    int intVel = -25;
    double dblTime = 0;
    double dblFPS = 0;
    double dblPosition;

    // Methods
    // override how JComponent is painted 
    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,960, 540);
        
        g.setColor(Color.RED);
		g.fillRect(0,400,960, 5);
		g.fillRect(0,intY,960, 1);
        g.setColor(Color.RED);
        g.fillOval(intX,intY, 20, 20);

        dblFPS = dblFPS + (1000.0/30.0);
        dblTime = dblFPS/1000.0;
        System.out.println(dblTime);
        
        if (intY > 400){
			System.out.println("true");
			dblFPS = 0;
        }
        dblPosition = (4.9*dblTime*dblTime + intVel*dblTime)*11;
        intY = 400 + (int)Math.round(dblPosition);
		System.out.println(dblPosition);
    }


    //Constructor
    public ballpanel (){
       
    }
}
