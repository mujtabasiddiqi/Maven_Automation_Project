package Day2_042422;

import java.util.ArrayList;

public class ForLoop {
    public static void main(String[] args) {
        //create an arrayList for cities and loop/iterating through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        cities.add("Long Island");
        cities.add("Staten Island");

        for (int i = 0; i < cities.size(); i++){
            System.out.println("i is now " + i);
            System.out.println("My city is " + cities.get(i));
        }//end of for loop

    }//end of main method
}//end of java class
