import java.util.ArrayList;

public class Penguin {
    int penguinage;

    public Penguin () {
    }

    public void setAge ( int age ) {
        penguinage = age;
    }

    public int getAge (){
        System.out.println("Penguin's age is:" + penguinage);
        return penguinage;
    }

    public static void agePenguins() {
        int middleAge = 3;
        int youngAge = middleAge-1;
        int oldAge = middleAge+1;
        ArrayList<Penguin> penguins = new ArrayList<>();
        Penguin archie = new Penguin();
        archie.setAge(youngAge); //this sets the Penguin's age
        penguins.add(archie);
        penguins.add(archie);
        penguins.add(archie);
        Penguin newbie = penguins.get(2); //this returns the 3rd element of the ArrayList
        newbie.setAge(oldAge);
        System.out.println(archie.getAge()); //this prints the Penguin's age
    }

    public static void main(String[] args) {
        agePenguins();
    }
}


