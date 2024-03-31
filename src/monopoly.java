import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class monopoly {

    public static int rollTheDice(){

        int output = (int) (Math.random() * 6) + 1;
        return output;

    }

    public static void buyPropertyHuman(ArrayList<ArrayList<String>> map, int counter, Human human){

        if (human.budget  >= 400){

            map.get(counter).set(1, human.name);
            System.out.println("\n" + "You have bought " + map.get(counter).get(0) + "\n");
            human.properties.add(map.get(counter).get(0));
            human.budget -= 400;

        }
        else System.out.println("You dont have enough money! Moving forward");
    }

    public static void buyPropertyBot(ArrayList<ArrayList<String>> map, int counter, Bot bot){

        map.get(counter).set(1, "Bot");
        System.out.println("Bot have bought " + map.get(counter).get(0));
        bot.properties.add(map.get(counter).get(0));
        bot.budget -= 400;

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

    public static boolean isBotOwn(ArrayList<ArrayList<String>> map, int counter){

        if (map.get(counter).get(1).equals("Bot")) return true;
        else return false;

    }

    public static boolean isMoneyPerson(Human human){

        if (human.budget >= 0) return true;
        else {

            System.out.println("You lost!");
            return false;

        }

    }

    public static boolean isMoneyBot(Bot bot){
        if (bot.budget >= 0) return true;
        else {

            System.out.println("Bot lost!");
            System.out.println("Congrats, you won!");
            return false;

        }
    }

    public static boolean botBudgetOver400(Bot bot){

        if (bot.budget >= 400) return true;
        else return false;

    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void play(Human person, Bot bot, ArrayList<ArrayList<String>> map) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            if (!isMoneyBot(bot)) break;
            if (!isMoneyPerson(person)) break;

            while (true) {

                System.out.println("What would you like to do?(Enter the number): 1(Throw the dice), 2(Check credits), 3(Check your property), 4(Check Bots property)");

                int number1 = scanner.nextInt();

                if (number1 == 1) {
                    int addToCounter = rollTheDice();
                    person.counter = person.counter + addToCounter;
                    System.out.println("\n" + "You throw the dice and get " + addToCounter + "\n");
                    if (person.counter >= 16) {

                        int remains = person.counter - 16;
                        person.counter = remains;

                    }
                    break;
                }


                else if (number1 == 2) {

                    System.out.println("Your budget is: " + person.budget);

                }
                else if (number1 == 3) {

                    if (person.properties.isEmpty()) System.out.println("You have anything at all! Haha!" + "\n");
                    else {

                        System.out.println("You own those: ");
                        for (String i : person.properties) {

                            System.out.println(i);

                        }

                    }

                } // End of the number1 == 3 else if

                else if (number1 == 4) {

                    if (bot.properties.isEmpty()) System.out.println("He don't have anything" + "\n");
                    else {

                        System.out.println("Bot owns: ");
                        for (String i : bot.properties) {

                            System.out.println(i);

                        }
                    }

                } // End of the number1 == 4 else if

            } // End of while loop

            wait(1500);

            System.out.println("You just stepped on the - " + map.get(person.counter).get(0) + "\n");

            wait(1500);

            if (isYourOwn(map, person.counter, person)) {

                System.out.println("You stepped onto your own land" + "\n");

            }

            else if (isReward(map, person.counter)) {

                System.out.println("You just won 200 credits in the lottery!" + "\n");
                person.budget += 200;

            }

            else if (isPenalty(map, person.counter)) {

                System.out.println("You got robbed! You lost 200 credits" + "\n");
                person.budget -= 200;

            }

            else if (isFreeToStay(map, person.counter))
                System.out.println("You got tired and decided to sleep for a little (Spoiler: Nothing bad happened)" + "\n");

            else if (!isAvailable(map, person.counter)) {

                System.out.println("Oh no, you stepped onto Bots land, you need to pay the fee to stay alive!" + "\n");
                System.out.println("You lost 50 credits" + "\n");
                person.budget -= 50;
                bot.budget += 50;

            }

            else {

                while (true) {

                    System.out.println(map.get(person.counter).get(0) + " is empty! What would you like to do? 1(Buy the land), 2(Don't buy this land), 3(Check credits), 4(Check property), 5(Check Bots property)");
                    int number2 = scanner.nextInt();
                    if (number2 == 1) {

                        buyPropertyHuman(map, person.counter, person);
                        break;

                    }
                    else if (number2 == 2) {

                        System.out.println("But... That was a good deal :(" + "\n");
                        break;

                    }
                    else if (number2 == 3) {

                        System.out.println("Your budget is: " + person.budget);

                    }
                    else if (number2 == 4) {

                        if (person.properties.isEmpty()) System.out.println("You have anything at all! Haha!" + "\n");
                        else {

                            System.out.println("You own those: ");
                            for (String i : person.properties) {

                                System.out.println(i);

                            }

                        }

                    } // End of the number2 == 4 else if

                    else if (number2 == 5) {

                        if (bot.properties.isEmpty()) System.out.println("He don't have anything");
                        else {

                            System.out.println("Bot owns: ");
                            for (String i : bot.properties) {

                                System.out.println(i);

                            }
                        }

                    } // End of the number2 == 5 else if

                } // End of the while loop

            }

            wait(1500);

            // Bots part of the code
            System.out.println("Now it's the bots turn!" + "\n");
            wait(1500);
            int counter_add = rollTheDice();
            System.out.println("He throws the dice and gets: " + counter_add + "\n");
            wait(1500);
            bot.counter += counter_add;

            if (bot.counter >= 16) {

                int remains = bot.counter - 16;
                bot.counter = remains;

            }

            System.out.println("Bot is now on: " + map.get(bot.counter).get(0) + "\n");
            wait(1500);

            if (isBotOwn(map, bot.counter)) {

                System.out.println("Bot stepped onto his own land" + "\n");

            } else if (isReward(map, bot.counter)) {

                System.out.println("Bot just won 200 credits in the lottery!" + "\n");
                bot.budget += 200;

            } else if (isPenalty(map, bot.counter)) {

                System.out.println("Bot got robbed! He lost 200 credits" + "\n");
                bot.budget -= 200;

            } else if (isFreeToStay(map, bot.counter))
                System.out.println("Bot got tired and decided to sleep for a little (Spoiler: Nothing bad happened)" + "\n");

            else if (!isAvailable(map, bot.counter)) {

                System.out.println("Oh no, bot stepped onto " + person.name + " land, he need to pay the fee to stay alive!" + "\n");
                System.out.println("Bot lost 50 credits" + "\n");
                bot.budget -= 50;
                person.budget += 50;

            }

            else {

                while (true) {

                    if (botBudgetOver400(bot)) {

                        buyPropertyBot(map, bot.counter, bot);
                        break;

                    } else if (!botBudgetOver400(bot)) {

                        System.out.println("Bot wasn't in the mood, to buy the property!" + "\n");
                        break;

                    }
                }

            }
            wait(1500);
            System.out.println("\n" + "Now is your turn!" + "\n");
            wait(1500);


        }
    }

    public static void main(String[] args) {
    }
}
