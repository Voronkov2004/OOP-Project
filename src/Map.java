import java.util.ArrayList;

public class Map {
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

}
