import java.io.*;
public class calculations{
    public static int Height(int intVel){
        double dblHeight = (0.5*(Math.pow(intVel, 2)))/9.8;
        dblHeight = Math.round(dblHeight);
		int intHeight = (int)dblHeight;
		System.out.println(intHeight);
		
		return intHeight;
    }
    
    public static void highScoreFile (String strName, int intScore){
		try{
		 PrintWriter highScores = new PrintWriter(new FileWriter("highScores.txt",true));
                highScores.println(strName +" with a score of: "+intScore);
                highScores.close();
		}catch(FileNotFoundException e){
			
		}catch(IOException e){
			
		}
	}


    public static void main(String[] args){
        double dblHeight = Height(10);
        //System.out.println(dblHeight);


    }
}
