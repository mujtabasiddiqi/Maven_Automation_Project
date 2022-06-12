package Action_Item;

import java.util.ArrayList;

public class Automation_AU01 {
    public static void main(String[] args) {
        //create an ArrayList for country and iterate through all values using For loop
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Pakistan");
        country.add("Bangladesh");
        country.add("Canada");
        country.add("India");

        //Declaring int as country code in ArrayList
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1122);
        countryCode.add(2233);
        countryCode.add(3344);
        countryCode.add(4455);
        countryCode.add(5566);

        //using For loop for iteration
        for (int i = 0; i < country.size(); i++) {
               //printing them out

               System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));

           }//end of loop


        //Iterate through region and its area code using linear array and while loop
        //declaring String and int in linear array

        String[] region = new String[]{"Asia", "Africa", "Europe", "America", "Australia"};
        int[] areaCode = new int[]{1234, 2345, 4567, 8765, 2234};

        //Initialize your starting point before creating while loop
        int i = 0;
        //define the end point in while loop
        while (i < areaCode.length){

            System.out.println("My region is " + region[i] + " area code " + areaCode[i]);
            //Incrementing
            i=i+1;
         }//end of while loop


        }//end of main
    }//end of java class

