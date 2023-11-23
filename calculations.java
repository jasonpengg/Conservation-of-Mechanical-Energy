public class calculations{
    public static double Height(double dblVel){
        double dblHeight = (0.5*(Math.pow(dblVel, 2)))/9.8;
        //System.out.println(dblHeight);
        return dblHeight;



    }
    public static void main(String[] args){
        double dblHeight = Height(10);
        //System.out.println(dblHeight);


    }
}
