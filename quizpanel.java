import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class quizpanel extends JPanel{
	//Properties
	BufferedImage imgQuiz = null;
	
	//Methods
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960, 540);
		g.drawImage(imgQuiz, 34,300,null);
	}
	// Constructor
	public quizpanel(){
		InputStream imageclass = null;
		imageclass = this.getClass().getResourceAsStream("quizformula.png");
		if(imageclass != null){
			try{
				imgQuiz = ImageIO.read(imageclass);
			}catch(IOException e){
				System.out.println("Unable to load image file from jar");
			}
		}
		if(imgQuiz == null){
			try{
				imgQuiz = ImageIO.read(new File("quizformula.png"));
			}catch(IOException e){
				System.out.println("Unable to load image");
			}
		}
	}
}
