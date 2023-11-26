import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class aboutpanel extends JPanel{
	//about panel 
	// can be as simple as importing an about image that includes everythign 
	// have buttons so that you can go back and forth between panels
	// Properties
	BufferedImage imgAbout = null;
	JLabel aboutLabel = new JLabel("Sam and Jason were the programmers of this simulation. This was thanks to the ICS4U1 Computer Science class by Mr. Cadawas. ");
	
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960, 540);
		g.drawImage(imgAbout, 10, 10, null);
	}
	// Constructor
	public aboutpanel(){
		aboutLabel.setSize(300, 200);
		aboutLabel.setLocation(10, 10);
		this.add(aboutLabel);
		try{
			imgAbout = ImageIO.read(new File("aboutpage.png"));
		}catch(IOException e){
			System.out.println("cannot load image");
		}
	}
}
