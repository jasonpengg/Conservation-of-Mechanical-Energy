import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class helppanel extends JPanel{
	//Properties
	BufferedImage imgHelp = null;
	
	//Methods
	public void paintComponent(Graphics g){
		g.drawImage(imgHelp, 0, 0, null);
	}
	//Constructor
	public helppanel(){
		InputStream imageclass = null;
		imageclass = this.getClass().getResourceAsStream("helppanelpic.png");
		if(imageclass != null){
			try{
				imgHelp = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image file from jar");
			}
		}
		if(imgHelp == null){
			try{
				imgHelp = ImageIO.read(new File("helppanelpic.png"));
			}catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
	}
}
