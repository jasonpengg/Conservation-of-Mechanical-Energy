// Sam and Jason
// Version 1.0
// Conservation of Mechanical Energy
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

// Things left to do: 
// Make buttons 
// Make ball fall up and down with animation 
// the JFrame property setter can be replaced when we have the animation panel working. 

public class come implements ActionListener, ChangeListener{
	// NOTE: When naming variables, use lower camel capitalization 
	// E.g firstName, lastName
	// Properties
	JFrame theframe = new JFrame("Conservation of Mechanical Energy");
	ballpanel thePanel = new ballpanel();
	JPanel aboutpanel = new JPanel();
	// buttons
	JButton fireButton = new JButton("Fire");
	JButton resetButton = new JButton("Reset");
	JButton mainMenu = new JButton("Main");
	JMenuBar theBar = new JMenuBar();
	JButton aboutItem = new JButton("About");
	JButton helpItem = new JButton("Help");
	JSlider sliderVel = new JSlider(JSlider.HORIZONTAL, 0, 25, 12);
	JSlider sliderMass = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
	
	//labels
	JLabel vLabel = new JLabel("Enter velocity: ");
	JLabel mLabel = new JLabel("Enter mass: ");
	JLabel hLabel = new JLabel();
	JLabel maxHLabel = new JLabel();
	JLabel aboutLabel = new JLabel("Sam and Jason were the programmers of this simulation. This was thanks to the ICS4U1 Computer Science class by Mr. Cadawas. ");
	Timer thetimer = new Timer(1000/45, this);
	
	//Global variables
	int intVel;
	int intHeight;
	double dblMaxHeight; 
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == aboutItem){
			System.out.println("about");
			//Replace frame with new panel. 
			theframe.setContentPane(aboutpanel);
			aboutLabel.setSize(300, 200);
			aboutLabel.setLocation(10, 10);
			aboutpanel.add(aboutLabel);
			aboutpanel.repaint();
			theframe.repaint();
			theframe.setVisible(true);
		}
		if(evt.getSource() == helpItem){
			System.out.println("help");
		}
		if(evt.getSource() == mainMenu){
			System.out.println("menu");
			theframe.setContentPane(thePanel);
			thePanel.repaint();
			theframe.repaint();
			theframe.setVisible(true);
		}
		if(evt.getSource() == fireButton){
			System.out.println("fire");
			thePanel.intVel = -(this.intVel);
			thePanel.dblFPS = 0;
			thePanel.dblTime = 0;
			thePanel.blnMove = true;
		}
		if(evt.getSource() == resetButton){
			//Set everything to 0, time, vel, Y values, max height, visible, EVERYTHIGN 
			System.out.println("reset");
			thePanel.blnMove = false;
		}
		if(evt.getSource () == thetimer){
			//This tracks the Height of the ball in (m)
			thePanel.repaint();
			hLabel.setText("" + thePanel.dblHeight+ "m");
			hLabel.setLocation(150, thePanel.intY-95);

			//Checks if the Height of the ball is at max height of all the other shots
			if(thePanel.dblHeight >= dblMaxHeight ){
				dblMaxHeight = thePanel.dblHeight;
				maxHLabel.setText ("" + dblMaxHeight+ "m (MaxHeight)");
				maxHLabel.setLocation(150, thePanel.intYMax-95);
				maxHLabel.setForeground(Color.BLUE);
			//Checks if the Height of the ball is max height of the first launch
			}if(thePanel.blnMaxHeight == true){
				maxHLabel.setVisible(true);
			//Intially sets the Balls invisible, also used if the reset button is clicked
			}else{
				maxHLabel.setVisible(false);	
			}
		}
	}
	public void stateChanged(ChangeEvent evt){
		System.out.println(sliderVel.getValue());
		System.out.println(sliderMass.getValue());
		this.intVel = sliderVel.getValue();
	}
	
	// Constructor: 
	public come(){
		thePanel.setLayout(null);
		thePanel.setPreferredSize(new Dimension(960, 540));


		// Buttons constructor
		fireButton.setSize(190, 40);
		fireButton.setLocation(670, 350);
		fireButton.addActionListener(this);
		thePanel.add(fireButton);
		
		resetButton.setSize(190, 40);
		resetButton.setLocation(670, 400);
		resetButton.addActionListener(this);
		thePanel.add(resetButton);
		
		// Slider (You need all this code for the slider to appear);
		sliderVel.setBackground(Color.WHITE);
		sliderVel.setBounds(670, 180, 200, 50);
		sliderVel.setLocation(670,100);
		sliderVel.setMajorTickSpacing(5);
        sliderVel.setMinorTickSpacing(1);
        sliderVel.setPaintTicks(true);
        sliderVel.setPaintLabels(true);
        theframe.setVisible(true);
		thePanel.add(sliderVel);
		
		sliderMass.setBackground(Color.WHITE);
		sliderMass.setBounds(670, 180, 200, 50);
		sliderMass.setMajorTickSpacing(10);
        sliderMass.setMinorTickSpacing(2);
        sliderMass.setPaintTicks(true);
        sliderMass.setPaintLabels(true);
        theframe.setVisible(true);
		thePanel.add(sliderMass);
		
		// Labels Constructor
		vLabel.setSize(100, 100);
		vLabel.setLocation(675, 40);
		thePanel.add(vLabel);
		
		mLabel.setSize(300, 200);
		mLabel.setLocation(670, 70);
		thePanel.add(mLabel);
		
		hLabel.setSize(300, 200);
		thePanel.add(hLabel);
		
		maxHLabel.setSize(300, 200);
		thePanel.add(maxHLabel);
		
		// Frame constructor
		theframe.setJMenuBar(theBar);
		theBar.add(mainMenu);
		theBar.add(aboutItem);
		theBar.add(helpItem);
		
		// Adding Functions to Components
		sliderVel.addChangeListener(this);
		sliderMass.addChangeListener(this);
		aboutItem.addActionListener(this);
		helpItem.addActionListener(this);
		mainMenu.addActionListener(this);
		
		// Frame
		theframe.setContentPane(thePanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		theframe.setVisible(true);
		thetimer.start();
	}
	
	// Main Method
	public static void main(String[] args){
		new come();
	}
}
