import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class helppanel extends JPanel{
	BufferedImage imgHelp = null;
	
	public void paintComponent(Graphics g){
		g.drawImage(imgHelp, 0, 0, null);
	}
	// Constructor
	public helppanel(){
		try{
			imgHelp = ImageIO.read(new File("helppanelpic.png"));
		}catch(IOException e){
			System.out.println("cannot load image");
		}
	}
}
