// Sam and Jason
// Version 1.0
// Conservation of Mechanical Energy
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

public class come implements ActionListener, ChangeListener{
	//Properties
	//Creating Frames and Panels
	JFrame theFrame = new JFrame("Conservation of Mechanical Energy");
	ballpanel thePanel = new ballpanel();
	aboutpanel abtPanel = new aboutpanel();
	helppanel hlpPanel = new helppanel();
	quizpanel testPanel = new quizpanel();
	JPanel scorePanel = new JPanel();
	
	//Buttons
	JButton fireButton = new JButton("Fire");
	JButton resetButton = new JButton("Reset");
	JButton mainMenu = new JButton("Main");
	JButton aboutMenu = new JButton("About");
	JButton helpMenu = new JButton("Help");
	JButton quizMenu = new JButton ("Quiz");
	JButton submitButton = new JButton ("Submit");
	JButton questionButton = new JButton ("Give Question");
	JButton endButton = new JButton ("End Quiz");
	JButton scoreMenu = new JButton ("Score");
	JButton enterName = new JButton ("Enter Name");
	
	//Sliders
	JSlider sliderVel = new JSlider(JSlider.HORIZONTAL, 0, 25, 12);
	JSlider sliderMass = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
	JSlider sliderHeight = new JSlider(JSlider.HORIZONTAL, 0, 35, 25);
	JSlider sliderQuizHeight = new JSlider(JSlider.HORIZONTAL, 0, 35, 25);
	
	//Labels
	JLabel vLabel = new JLabel("Enter velocity: 12");
	JLabel mLabel = new JLabel("Enter mass: 25");
	JLabel hLabel = new JLabel();
	JLabel maxHLabel = new JLabel();
	JLabel EkLabel = new JLabel("Initial Kinetic Energy: ");
	JLabel QLabel = new JLabel();
	JLabel QLabel2 = new JLabel();
	JLabel QHLabel = new JLabel("Enter Height: ");
	JLabel resultLabel = new JLabel("");
	JLabel scoreLabel = new JLabel();
	
	//Creating timers, text area and menu bar
	Timer thetimer = new Timer(1000/48, this);
	JTextField nameText = new JTextField();
	JTextArea scoresText = new JTextArea();
	JMenuBar theBar = new JMenuBar();
	
	//Variables 
	int intVel = 12;
	int intHeight;
	double dblMaxHeight; 
	int intInputHeight;
	int intQVelocity;
	int intScore;
	
	//Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == aboutMenu){
			//Replace frame with new panel
			theFrame.setContentPane(abtPanel);
			theFrame.pack();
			theFrame.repaint();
		}
		if(evt.getSource() == helpMenu){
			//Replace frame with new panel
			theFrame.setContentPane(hlpPanel);
			theFrame.pack();
			theFrame.repaint();
		}
		if(evt.getSource() == mainMenu){
			//Replace frame with new panel
			theFrame.setContentPane(thePanel);
			theFrame.pack();
			theFrame.repaint();
		}
		if(evt.getSource() == scoreMenu){
			//Replace frame with new panel
			theFrame.setContentPane(scorePanel);
			theFrame.pack();
			theFrame.repaint();
			//Loading highscores
			scoresText.setText("");
			scorePanel.setVisible(true);
			scoresText.setEditable(false);
			
			//Loading highscores from jar file
			InputStream txtClass = null;
			txtClass = this.getClass().getClassLoader().getResourceAsStream("/highScores.txt");
			if(txtClass != null){
				try{
					BufferedReader infile = new BufferedReader(new InputStreamReader(txtClass));
					String strLine = "";
					strLine = infile.readLine();
					while(strLine != null){
						scoresText.append(strLine+"\n");
						strLine = infile.readLine();
					}
					infile.close();
				}catch(FileNotFoundException e){
					System.out.println("File not found");
				}catch(IOException e){
					System.out.println("File cannot be opened");
			}
			//Loading highscores from the txt file 
			}if(txtClass == null){
				try{
					BufferedReader infile = new BufferedReader(new FileReader("highScores.txt"));
					String strLine = "";
					strLine = infile.readLine();
					while(strLine != null){
						scoresText.append(strLine+"\n");
						strLine = infile.readLine();
					}
					infile.close();
				}catch(FileNotFoundException e){
					System.out.println("File not found");
				}catch (IOException e){
					System.out.println("File cannot be opened");
				}
			}
		}
//---------------------------------------------------------------QUIZ PANEL---------------------------------------------------------------------
		if(evt.getSource() == quizMenu){
			//Changing panels
			theFrame.setContentPane(testPanel);
			theFrame.pack();
			theFrame.repaint();
			
			//Resetting quiz panel
			questionButton.doClick();
			enterName.setVisible(false);
			submitButton.setEnabled(true);
			questionButton.setEnabled(true);
			endButton.setEnabled(true);
			enterName.setEnabled(true);
			resultLabel.setText("");
			nameText.setEditable(false);
		}
		if(evt.getSource()== submitButton){
			//Checks if input is correct value
			if(calculations.Height(intQVelocity) == intInputHeight){
				questionButton.doClick();
				intScore++;
				resultLabel.setForeground(Color.GREEN);
				resultLabel.setText("Correct!");
				scoreLabel.setText("the score is: "+intScore);
			}else{
				resultLabel.setForeground(Color.RED);
				resultLabel.setText("Incorrect, Try Again");
			}
		}
		if(evt.getSource()== questionButton){
			// Uses random number generator to decide quiz questions
			intQVelocity = (int)(Math.random() * 25) + 1;
			QLabel.setText("Given the velocity to be: "+ intQVelocity +"m/s,");
			QLabel2.setText("Calculate max height. Round to nearest whole number");
		}
		if(evt.getSource()== endButton){
			//Disables buttons and guides user to enter their name 
			System.out.println(intScore);
			submitButton.setEnabled(false);
			questionButton.setEnabled(false);
			endButton.setEnabled(false);
			enterName.setVisible(true);
			nameText.setEditable(true);
		}
		if(evt.getSource()== enterName){
			//When they submit their name, they get their score saved and they can do the quiz again
			enterName.setEnabled(false);
			String strName = nameText.getText();
			calculations.highScoreFile(strName, intScore);
			intScore = 0;
			nameText.setText("");
			scoreLabel.setText("");
			resultLabel.setText("");
			quizMenu.doClick();
		}
//---------------------------------------------------------------thePanel---------------------------------------------------------------------
		if(evt.getSource() == fireButton){
			thePanel.intVel = -(this.intVel);
			thePanel.dblFPS = 0;
			thePanel.dblTime = 0;
			thePanel.blnMove = true;
		}
		if(evt.getSource() == resetButton){
			// Set all values to 0, resets the program
			thePanel.dblTime = 0;
			thePanel.dblFPS = 0;
			thePanel.intVel = 0;
			dblMaxHeight = 0;
			thePanel.intYMax = 401;
			thePanel.blnMaxHeight = false;
			thePanel.dblMaxHeight = 0;
			maxHLabel.setVisible(false);
			maxHLabel.setLocation(150, thePanel.intYMax-95);
			thePanel.blnMove = false;
			sliderVel.setValue(12);
			sliderMass.setValue(25);
		}
		if(evt.getSource () == thetimer){
			//This tracks the height of the ball in (m)
			thePanel.repaint();
			hLabel.setText("" + thePanel.dblHeight+ "m");
			hLabel.setLocation(150, thePanel.intY-95);
			//Checks if the height of the ball is at max height of all the other shots
			if(thePanel.dblHeight >= dblMaxHeight ){
				dblMaxHeight = thePanel.dblHeight;
				maxHLabel.setText ("" + dblMaxHeight+ "m (MaxHeight)");
				maxHLabel.setLocation(300, thePanel.intYMax-95);
				maxHLabel.setForeground(Color.BLUE);
			//Checks if the height of the ball is max height of the first launch
			}if(thePanel.blnMaxHeight == true){
				maxHLabel.setVisible(true);
			//Initially sets the label invisible, also used if the reset button is clicked
			}else{
				maxHLabel.setVisible(false);	
			}
		}
	}
	public void stateChanged(ChangeEvent evt){
		//Get slider values
		this.intVel = sliderVel.getValue();
		this.intInputHeight = sliderQuizHeight.getValue();
		EkLabel.setText ("Initial Kinetic Energy: "+(0.5 * sliderMass.getValue() * intVel*intVel) +"J");
		vLabel.setText("Enter velocity: " +intVel);
		mLabel.setText("Enter mass: " +sliderMass.getValue());
		QHLabel.setText("Enter Height: " +intInputHeight +"m");
	}
	
	// Constructor
	public come(){
		//-------------------------------------------------------------------MAIN MENU-------------------------------------------------------------------------------//
		thePanel.setLayout(null);
		thePanel.setPreferredSize(new Dimension(960, 540));
		
		// Buttons 
		fireButton.setSize(190, 40);
		fireButton.setLocation(670, 350);
		fireButton.addActionListener(this);
		thePanel.add(fireButton);
		
		resetButton.setSize(190, 40);
		resetButton.setLocation(670, 400);
		resetButton.addActionListener(this);
		thePanel.add(resetButton);
		
		// Sliders
		sliderVel.setBackground(Color.WHITE);
		sliderVel.setBounds(670, 180, 200, 50);
		sliderVel.setLocation(670,100);
		sliderVel.setMajorTickSpacing(5);
		sliderVel.setMinorTickSpacing(1);
		sliderVel.setPaintTicks(true);
		sliderVel.setPaintLabels(true);
		theFrame.setVisible(true);
		sliderVel.setValue(12);
		sliderVel.addChangeListener(this);
		thePanel.add(sliderVel);
		
		sliderMass.setBackground(Color.WHITE);
		sliderMass.setBounds(670, 180, 200, 50);
		sliderMass.setMajorTickSpacing(10);
		sliderMass.setMinorTickSpacing(2);
		sliderMass.setPaintTicks(true);
		sliderMass.setPaintLabels(true);
		sliderMass.setValue(25);
		theFrame.setVisible(true);
		sliderMass.addChangeListener(this);
		thePanel.add(sliderMass);
		
		// Labels
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
		

		//-------------------------------------------------------------------ABOUT PANEL-------------------------------------------------------------------------------//
		abtPanel.setLayout(null);
		abtPanel.setPreferredSize(new Dimension(960, 540));
		
		//-------------------------------------------------------------------HELP PANEL-------------------------------------------------------------------------------//
		hlpPanel.setLayout(null);
		hlpPanel.setPreferredSize(new Dimension(960, 540));

		//-------------------------------------------------------------------QUIZ PANEL-------------------------------------------------------------------------------//
		testPanel.setLayout(null);
		testPanel.setPreferredSize(new Dimension(960, 540));
		testPanel.setBackground(Color.WHITE);

		//Slider for quiz
		sliderQuizHeight.setBackground(Color.WHITE);
		sliderQuizHeight.setBounds(670, 180, 200, 50);
		sliderQuizHeight.setLocation(670,100);
		sliderQuizHeight.setMajorTickSpacing(5);
		sliderQuizHeight.setMinorTickSpacing(1);
		sliderQuizHeight.setPaintTicks(true);
		sliderQuizHeight.setPaintLabels(true);
		theFrame.setVisible(true);
		sliderQuizHeight.addChangeListener(this);
		testPanel.add(sliderQuizHeight);

		//Labels for quiz
		QLabel.setSize(400, 120);
		QLabel.setLocation(50, 40);
		testPanel.add(QLabel);
		
		QLabel2.setSize(400, 120);
		QLabel2.setLocation(50, 70);
		testPanel.add(QLabel2);
		
		QHLabel.setSize(150, 100);
		QHLabel.setLocation(675, 40);
		testPanel.add(QHLabel);
		
		resultLabel.setSize(400, 120);
		resultLabel.setLocation(50,100);
		testPanel.add(resultLabel);
		
		scoreLabel.setSize(400, 120);
		scoreLabel.setLocation(50,130);
		testPanel.add(scoreLabel);
		
		//Buttons for quiz
		submitButton.setSize(190, 40);
		submitButton.setLocation(670, 200);
		submitButton.addActionListener(this);
		testPanel.add(submitButton);
		
		questionButton.setSize(190, 40);
		questionButton.setLocation(670, 250);
		questionButton.addActionListener(this);
		testPanel.add(questionButton);
		
		endButton.setSize(190, 40);
		endButton.setLocation(670, 300);
		endButton.addActionListener(this);
		testPanel.add(endButton);
		
		nameText.setSize(190,40);
		nameText.setLocation(670, 350);		
		testPanel.add(nameText);
		
		enterName.setSize(190, 40);
		enterName.setLocation(670, 400);
		enterName.addActionListener(this);
		testPanel.add(enterName);
		//-------------------------------------------------------------------SCORE PANEL-------------------------------------------------------------------------------//
		scorePanel.setLayout(null);
		scorePanel.setPreferredSize(new Dimension(960, 540));
		scorePanel.setBackground(Color.WHITE);

		scoresText.setSize(900, 500);
		scoresText.setLocation(30, 20);
		scorePanel.add(scoresText);
		//-------------------------------------------------------------------GENERAL FRAME-------------------------------------------------------------------------------//
		
		aboutMenu.addActionListener(this);
		helpMenu.addActionListener(this);
		mainMenu.addActionListener(this);
		quizMenu.addActionListener(this);
		scoreMenu.addActionListener(this);
		
		// Frame and bar 
		theFrame.setJMenuBar(theBar);
		theBar.add(mainMenu);
		theBar.add(aboutMenu);
		theBar.add(helpMenu);
		theBar.add(quizMenu);
		theBar.add(scoreMenu);
		theFrame.setContentPane(thePanel);
		theFrame.pack();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setResizable(false);
		theFrame.setVisible(true);
		thetimer.start();
	}
	// Main Method
	public static void main(String[] args){
		new come();
	}
}
