// Sam and Jason
// Version 1.0
// Conservation of Mechanical Energy
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class come implements ActionListener, ChangeListener{
	// Properties
	JFrame theframe = new JFrame("Conservation of Mechanical Energy");
	JPanel thepanel = new JPanel();
	// buttons
	JButton runbutton = new JButton();
	JButton resetbutton = new JButton();
	JMenu mainmenu = new JMenu("Main");
	JMenuBar thebar = new JMenuBar();
	JMenuItem aboutitem = new JMenuItem("About");
	JMenuItem helpitem = new JMenuItem("Help");
	JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);

	
	//labels
	JLabel vlabel = new JLabel("Enter velocity: ");
	JLabel mlabel = new JLabel("Enter mass: ");
	JLabel hlabel = new JLabel();
	JLabel maxhlabel = new JLabel();
	
	// Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == aboutitem){
		
		}
	}
	public void stateChanged(ChangeEvent evt){
		System.out.println(slider.getValue());
		
	}
	
	// Constructor: 
	public come(){
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(960, 540));
		thebar.setLayout(null);
		aboutitem.setSize(20,20);
		aboutitem.setLocation(0,0);
		
		// Buttons constructor
		
		// Slider 
		 slider.setBounds(200, 100, 200, 50);
		slider.setLocation(200,100);
		slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        theframe.setVisible(true);
		thepanel.add(slider);
		
		// Labels Constructor
		vlabel.setSize(300, 200);
		vlabel.setLocation(670, 30);
		thepanel.add(vlabel);
		
		mlabel.setSize(300, 200);
		mlabel.setLocation(670, 150);
		thepanel.add(mlabel);
		
		// Frame constructor
		theframe.setJMenuBar(thebar);
		thebar.add(mainmenu);
		thebar.add(aboutitem);
		thebar.add(helpitem);
		
		slider.addChangeListener(this);
		aboutitem.addActionListener(this);
		helpitem.addActionListener(this);
		
		theframe.setContentPane(thepanel);
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
