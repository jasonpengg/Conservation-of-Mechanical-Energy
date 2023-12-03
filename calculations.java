import java.io.*;
public class calculations{
    public static int Height(int intVel){
        double dblHeight = (0.5*(Math.pow(intVel, 2)))/9.8;
        dblHeight = Math.round(dblHeight);
		int intHeight = (int)dblHeight;
		System.out.println(intHeight);
		
		return intHeight;
    }
    public static void main(String[] args){
        double dblHeight = Height(10);
        //System.out.println(dblHeight);


    }
}
