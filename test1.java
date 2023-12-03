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

public class test1 implements ActionListener, ChangeListener{
	// NOTE: When naming variables, use lower camel capitalization 
	// E.g firstName, lastName
	// Properties
	JFrame theframe = new JFrame("Conservation of Mechanical Energy");
	ballpanel thePanel = new ballpanel();
	JPanel aboutpanel = new JPanel();
	JPanel testPanel = new JPanel();
	JPanel scorePanel = new JPanel();
	
	
	// buttons
	JButton fireButton = new JButton("Fire");
	JButton resetButton = new JButton("Reset");
	JButton mainMenu = new JButton("Main");
	JMenuBar theBar = new JMenuBar();
	JButton aboutMenu = new JButton("About");
	JButton helpMenu = new JButton("Help");
	JButton quizMenu = new JButton ("Quiz");
	JButton scoreMenu = new JButton ("Score");
	JSlider sliderVel = new JSlider(JSlider.HORIZONTAL, 0, 25, 12);
	JSlider sliderMass = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
	JSlider sliderHeight = new JSlider(JSlider.HORIZONTAL, 0, 35, 25);
	
	//labels
	JLabel vLabel = new JLabel("Enter velocity: ");
	JLabel mLabel = new JLabel("Enter mass: ");
	JLabel hLabel = new JLabel();
	JLabel maxHLabel = new JLabel();
	JLabel EkLabel = new JLabel("Intial Kinetic Energy: ");
	JLabel aboutLabel = new JLabel("Sam and Jason were the programmers of this simulation. This was thanks to the ICS4U1 Computer Science class by Mr. Cadawas. ");
	Timer thetimer = new Timer(1000/48, this);
	JLabel QLabel = new JLabel();
	
	//Global variables
	int intVel;
	int intHeight;
	double dblMaxHeight; 
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		
		
		if(evt.getSource() == quizMenu){
			theframe.setContentPane(testPanel);
		}
	}
	public void stateChanged(ChangeEvent evt){

	}
	
	// Constructor: 
	public test1(){
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
		
		EkLabel.setSize(200, 100);
		EkLabel.setLocation(670,200 );
		thePanel.add(EkLabel);
		
		// Frame constructor
		theframe.setJMenuBar(theBar);
		theBar.add(mainMenu);
		theBar.add(aboutMenu);
		theBar.add(helpMenu);
		theBar.add(scoreMenu);
		theBar.add(quizMenu);
		
		// Adding Functions to Components
		sliderVel.addChangeListener(this);
		sliderMass.addChangeListener(this);
		aboutMenu.addActionListener(this);
		helpMenu.addActionListener(this);
		mainMenu.addActionListener(this);
		
		//About Panel
		aboutpanel.setLayout(null);
		aboutpanel.setPreferredSize(new Dimension(960, 540));
		aboutLabel.setSize(1000,50);
		aboutLabel.setLocation(10, 10);
		aboutpanel.add(aboutLabel);
		
		//Quiz Panel 
		
		
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
		new test1();

	}
}
