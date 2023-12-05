import java.io.*;
public class calculations{
	//Method checks for max height
	public static int Height(int intVel){
		double dblHeight = (0.5*(Math.pow(intVel, 2)))/9.8;
		dblHeight = Math.round(dblHeight);
		int intHeight = (int)dblHeight;
		return intHeight;
	}
	//Method inputs values into txt file
	public static void highScoreFile (String strName, int intScore){
		try{
			PrintWriter highScores = new PrintWriter(new FileWriter("highScores.txt",true));
			highScores.println(strName +" with a score of: "+intScore);
			highScores.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}catch(IOException e){
			System.out.println("File cannot be opened");
		}
	}
}
