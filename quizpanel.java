import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class quizpanel extends JPanel{
	BufferedImage imgQuiz = null;
	
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0,0,960, 540);
		g.drawImage(imgQuiz, 34,300,null);
	}
	// Constructor
	public quizpanel(){
		try{
			imgQuiz = ImageIO.read(new File("quizformula.png"));
		}catch(IOException e){
			System.out.println("cannot load image");
		}
	}


}
