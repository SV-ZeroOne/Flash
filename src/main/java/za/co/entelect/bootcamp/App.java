package za.co.entelect.bootcamp;

public class App 
{
    public static final double CURRENT_RATE = 22.07;

    public static double convertRandToDollar(double value){
        return value * CURRENT_RATE / 100 ;
    }

    public static void main(String[] args) {
        System.out.println("Team Flash FTW");
        System.out.println("Byron Dinkelmann");
    }
}
