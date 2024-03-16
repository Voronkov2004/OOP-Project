import java.util.ArrayList;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        Human anton = new Human("Anton");
        Bot bot = new Bot();
        ArrayList<ArrayList<String>> map = Map.createMap();
        Scanner input = new Scanner(System.in);
        System.out.println("Hello there Traveller!");
        System.out.println("Would you like to play?: Y(yes)/N(no)");
        String answer = input.nextLine();
        if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("yes")){
            System.out.println("Goodluck then!");
            monopoly.play(anton, bot, map);
        }
        else{
            System.out.println("Good luck in your journey!");
        }
    }
}
