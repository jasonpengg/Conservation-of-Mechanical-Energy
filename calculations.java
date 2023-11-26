public class calculations{
    public static double Height(int intVel){
        double dblHeight = (0.5*(Math.pow(intVel, 2)))/9.8;
        return Math.round(dblHeight*100.0)/100.0;
    }
    public static void main(String[] args){
        double dblHeight = Height(10);
        //System.out.println(dblHeight);


    }
}
