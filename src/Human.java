import java.util.ArrayList;

public class Human {
    public int budget;
    public int counter;
    public ArrayList<String> properties;
    public String name;

    public Human(String name) {
        this.budget = 2000;
        this.counter = 0;
        this.name = name;
        this.properties = new ArrayList<>();
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ArrayList<String> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<String> properties) {
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
