package listing_02_03;

public class Automobile {
    private static int number;
    Automobile(){
        number++;
        System.out.println("From Automobile constructor: number = " + number);
    }
}
