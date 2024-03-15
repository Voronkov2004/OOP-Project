import java.util.ArrayList;
import java.util.Scanner;

public class monopoly {

    public static ArrayList<ArrayList<String>> createMap(){
        ArrayList<ArrayList<String>> monopolyMap = new ArrayList<ArrayList<String>>();
        ArrayList<String> start = new ArrayList<>();
        start.add("Start");
        start.add("Start");
        monopolyMap.add(start);

        ArrayList<String> street1 = new ArrayList<>();
        street1.add("Oriental Avenue");
        street1.add("No one");
        monopolyMap.add(street1);

        ArrayList<String> street2 = new ArrayList<>();
        street2.add("Vermont Avenue");
        street2.add("No one");
        monopolyMap.add(street2);

        ArrayList<String> street3 = new ArrayList<>();
        street3.add("Connecticut Avenue");
        street3.add("No one");
        monopolyMap.add(street3);

        ArrayList<String> street4 = new ArrayList<>();
        street4.add("Free Stay");
        street4.add("Free Stay");
        monopolyMap.add(street4);

        ArrayList<String> street5 = new ArrayList<>();
        street5.add("ST. James Avenue");
        street5.add("No one");
        monopolyMap.add(street5);

        ArrayList<String> street6 = new ArrayList<>();
        street6.add("Tennessee Avenue");
        street6.add("No one");
        monopolyMap.add(street6);

        ArrayList<String> street7 = new ArrayList<>();
        street7.add("New York Avenue");
        street7.add("No one");
        monopolyMap.add(street7);

        ArrayList<String> street8 = new ArrayList<>();
        street8.add("Penalty");
        street8.add("Penalty");
        monopolyMap.add(street8);

        ArrayList<String> street9 = new ArrayList<>();
        street9.add("Atlantic Avenue");
        street9.add("No one");
        monopolyMap.add(street9);

        ArrayList<String> street10 = new ArrayList<>();
        street10.add("Ventnor Avenue");
        street10.add("No one");
        monopolyMap.add(street10);

        ArrayList<String> street11 = new ArrayList<>();
        street11.add("Marvin Avenue");
        street11.add("No one");
        monopolyMap.add(street11);

        ArrayList<String> street12 = new ArrayList<>();
        street12.add("Reward");
        street12.add("Reward");
        monopolyMap.add(street12);

        ArrayList<String> street13 = new ArrayList<>();
        street13.add("Pacific Avenue");
        street13.add("No one");
        monopolyMap.add(street13);

        ArrayList<String> street14 = new ArrayList<>();
        street14.add("North Carolina Avenue");
        street14.add("No one");
        monopolyMap.add(street14);

        ArrayList<String> street15 = new ArrayList<>();
        street15.add("Pennsylvania Avenue");
        street15.add("No one");
        monopolyMap.add(street15);

        return monopolyMap;
    }

    public static int rollTheDice(){
        int output = (int) (Math.random() * 6) + 1;
        return output;
    }

    public static void buyPropertyHuman(ArrayList<ArrayList<String>> map, int counter, Human human){
        if (isAvailable(map,counter)){
            map.get(counter).set(1, human.name);
            System.out.println("You have bought " + map.get(counter).get(0));
            human.properties.add(map.get(counter).get(0));
            human.budget -= 400;
        }
    }

    public static ArrayList<ArrayList<String>> buyPropertyBot(ArrayList<ArrayList<String>> map, int counter){
        map.get(counter).set(1, "Bot");
        System.out.println("Bot have bought " + map.get(counter).get(0));
        return map;
    }

    public static boolean isAvailable(ArrayList<ArrayList<String>> map, int counter){
        if (map.get(counter).get(1).equals("No one")) return true;
        return false;
    }

    public static boolean isPenalty(ArrayList<ArrayList<String>> map, int counter){
        if (map.get(counter).get(1).equals("Penalty")) return true;
        return false;
    }

    public static boolean isReward(ArrayList<ArrayList<String>> map, int counter){
        if (map.get(counter).get(1).equals("Reward")) return true;
        return false;
    }

    public static boolean isFreeToStay(ArrayList<ArrayList<String>> map, int counter){
        if (map.get(counter).get(1).equals("Free Stay")) return true;
        return false;
    }

    public static boolean isYourOwn(ArrayList<ArrayList<String>> map, int counter, Human human){
        if (map.get(counter).get(1).equals(human.name)) return true;
        else return false;
    }


    public static void play(Human person, Bot bot, ArrayList<ArrayList<String>> map){
        Scanner scanner = new Scanner(System.in);
        while (person.budget > 0 && bot.budget > 0){

            System.out.println("What would you like to do?(Enter the number): 1(Throw the dice), 2(Leave the game)");

            int number1 = scanner.nextInt();

            if (number1 == 2) break;

            person.counter = person.counter + rollTheDice();
            if (person.counter > 16){
                int remains = person.counter - 16;
                person.counter = remains;
            }

            System.out.println("You just stepped on the - " + map.get(person.counter).get(0));

            if (isYourOwn(map, person.counter, person)){
                System.out.println("You stepped onto your own land");
            }
            else if (isReward(map, person.counter)){
                System.out.println("You just won 200 credits in the lottery!");
                person.budget += 200;
            }
            else if (isPenalty(map, person.counter)){
                System.out.println("You got robbed! You lost 200 credits");
                person.budget -= 200;
            }
            else if (isFreeToStay(map, person.counter))System.out.println("You got tired and decided to sleep for a little (Spoiler: Nothing bad happened)");

            else if (!isAvailable(map, person.counter)) {
                System.out.println("Oh no, you stepped in NoMans land, you need to pay the fee to stay alive!");
                System.out.println("You lost 50 credits");
                person.budget -= 50;
            }
            else {
                System.out.println("This land is empty! What would you like to do? 1(Buy the land), 2(Don't buy this land), 3(Check credits), 4(Check property)");

                int number2 = scanner.nextInt();

                if (number2 == 1) buyPropertyHuman(map, person.counter, person);
                else if (number2 == 2) System.out.println("But... That was a good deal :(");
                else if (number2 == 3) {
                    System.out.println("Your budget is: " + person.budget);
                } else if (number2 == 4) {
                    if (person.properties == null) System.out.println("You have nothing at all! Haha!");
                    else {
                        System.out.println("You own those: ");
                        for (String i : person.properties) {

                            System.out.println(i);
                        }
                    }
                }
            }


        }

    }

    public static void main(String[] args) {

    }
}
