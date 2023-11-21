// Sam and Jason
// Version 1.0
// Conservation of Mechanical Energy
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class come implements ActionListener{
	// Properties
	JFrame theframe = new JFrame("Conservation of Mechanical Energy");
	JPanel thepanel = new JPanel();
	JTextField thetext = new JTextField();
	JTextField thetext2 = new JTextField();
	JButton runbutton = new JButton();
	JButton resetbutton = new JButton();
	JLabel vlabel = new JLabel("Enter velocity: ");
	JLabel mlabel = new JLabel("Enter mass: ");
	JLabel hlabel = new JLabel();
	JLabel maxhlabel = new JLabel();
	String strName = "Main";
	JMenu mainmenu = new JMenu(strName);
	JMenuBar thebar = new JMenuBar();
	JMenuItem aboutitem = new JMenuItem("About");
	JMenuItem helpitem = new JMenuItem("Help");
	
	
	
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == aboutitem){
		
		}
	}
	
	// Constructor: shm is simple harmonic motion
	public come(){
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(960, 540));
		thebar.setLayout(null);
		aboutitem.setSize(20,20);
		aboutitem.setLocation(0,0);
		
		// Frame constructor
		theframe.setJMenuBar(thebar);
		thebar.add(mainmenu);
		thebar.add(aboutitem);
		thebar.add(helpitem);
		aboutitem.addActionListener(this);
		helpitem.addActionListener(this);
		
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		theframe.setVisible(true);
		
		// Buttons constructor
		
		// Text Constructor
		thetext.setSize(190, 40);
		thetext.setLocation(670, 80);
		thepanel.add(thetext);
		thetext2.setSize(190, 40);
		thetext2.setLocation(670, 200);
		thepanel.add(thetext2);
		
		// Labels Constructor
		vlabel.setSize(300, 200);
		vlabel.setLocation(670, 30);
		thepanel.add(vlabel);
		mlabel.setSize(300, 200);
		mlabel.setLocation(670, 150);
		thepanel.add(mlabel);
	}
	
	// Main Method
	public static void main(String[] args){
		new come();
	}
}
