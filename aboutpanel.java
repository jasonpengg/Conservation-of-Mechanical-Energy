import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class aboutpanel extends JPanel{
	BufferedImage imgAbout = null;
	
	public void paintComponent(Graphics g){
		g.drawImage(imgAbout, 10, 10, null);
	}
	// Constructor
	public aboutpanel(){
		try{
			imgAbout = ImageIO.read(new File("aboutpage.png"));
		}catch(IOException e){
			System.out.println("cannot load image");
		}
	}
}
