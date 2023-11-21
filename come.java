// Sam and Jason
// Version 1.0
// Conservation of Mechanical Energy
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class come{
	// Properties
	JFrame theframe = new JFrame("Conservation of Mechanical Energy");
	JPanel thepanel = new JPanel();
	JTextField thetext = new JTextField();
	JButton runbutton = new JButton();
	JButton resetbutton = new JButton();
	JLabel vlabel = new JLabel();
	JLabel hlabel = new JLabel();
	JLabel maxhlabel = new JLabel();
	
	
	
	
	// Methods
	
	
	// Constructor: shm is simple harmonic motion
	public shm(){
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(960, 540));
		
		
	}
	
	// Main Method
	public static void main(String[] args){
		new shm();
	}
}
