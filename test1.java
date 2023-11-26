//Math calculator 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class test1 implements ActionListener{ 
    //properties 
    JFrame theframe = new JFrame("math!"); 
    ballpanel thepanel = new ballpanel();
    Timer thetimer = new Timer(1000/30, this);

    //methods 
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == thetimer){
            thepanel.repaint();
        }
    }

    //constructor 
    public test1(){
        thepanel.setLayout(null);
        thepanel.setPreferredSize(new Dimension (960, 540));

       
        theframe.setContentPane(thepanel); 
        theframe.pack(); 
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setVisible(true); 
        theframe.setResizable(false);
        thetimer.start();

    }
    public static void main(String[] args){
        new test1();

    }


}

