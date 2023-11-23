// Sam and Jason
// Version 1.0
// Conservation of Mechanical Energy
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

//Things left to do: 
// Make buttons 
// Make ball fall up and down with animation 
// the JFrame property setter can be replaced when we have the animation panel working. 

public class come implements ActionListener, ChangeListener{
	// NOTE: When naming variabels, use lower camel capitalization 
	// E.g firstName, lastName
	// Properties
	JFrame theframe = new JFrame("Conservation of Mechanical Energy");
	JPanel thePanel = new JPanel();
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
	JLabel MaxHLabel = new JLabel();
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == aboutItem){
			System.out.println("about");
			//Replace frame with new panel. 
		}
		if(evt.getSource() == helpItem){
			System.out.println("help");
		}
		if(evt.getSource() == mainMenu){
			System.out.println("menu");
		}
	}
	public void stateChanged(ChangeEvent evt){
		System.out.println(sliderVel.getValue());
		System.out.println(sliderMass.getValue());
		
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
		sliderVel.setBounds(200, 100, 200, 50);
		sliderVel.setLocation(670,100);
		sliderVel.setMajorTickSpacing(5);
        sliderVel.setMinorTickSpacing(1);
        sliderVel.setPaintTicks(true);
        sliderVel.setPaintLabels(true);
        theframe.setVisible(true);
		thePanel.add(sliderVel);
		sliderMass.setBounds(200, 100, 200, 50);
		sliderMass.setLocation(670,180);
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
		
		// Frame constructor
		theframe.setJMenuBar(theBar);
		theBar.add(mainMenu);
		theBar.add(aboutItem);
		theBar.add(helpItem);
		
		// Adding Functions to Components
		sliderVel.addChangeListener(this);
		aboutItem.addActionListener(this);
		helpItem.addActionListener(this);
		mainMenu.addActionListener(this);
		
		// Frame
		theframe.setContentPane(thePanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		theframe.setVisible(true);
	}
	
	// Main Method
	public static void main(String[] args){
		new come();
	}
}
