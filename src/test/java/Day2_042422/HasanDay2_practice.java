package Day2_042422;

import java.util.ArrayList;

public class HasanDay2_practice {
    public static void main(String[] args) {
        //ARRAYS
        //array allows you to store multiple strings and integers (data sets/values) into a SINGLE Variable ie 'placeholder'
        //array starts with zero '0' NOT '1'
        //there are string array and integer array
        //TWO TYPES OF ARRAY

        //1. Linear Array
        //- Defined by symbol []
        //- uses length command to get count of the values
        //- written in a single line.
        //- commas ' , ' are used
        //- you can declare the variable name first and then define the variable afterwards.
        //- Linear is best for smaller lists

        //1.1 String Array linear
        String [] zipcode = new String[]{"11218", "22218", "33218", "44218"}; //first zipcode will be [0]
        System.out.println("My first zipcode is "+zipcode [0]); //code 1
        System.out.println("My last zipcode is "+zipcode[3]); //code 2
        System.out.println("My first code is "+zipcode [0]+ " and my last code is " +zipcode [3]); //code 3

        //REMEMBER: new String[]{"11218", "22218", "33218", "44218" ___In this part of the code we must put quotations as this is a string array and strings need quotations.

        //Practicing String Array linear with various examples. Objective is to memorize the code syntax.
        String [] names = new String[]{"Ahmed","Daya","Mama","Baba"};
        System.out.println("My sons name is "+ names[0]);//code 4

        String [] colors = new String[]{"black", "white", "red", "blue"};
        System.out.println("My favorite colors are " + colors[1] + " and " +colors[0] + " however, i also dont mind " +colors[3] + " but " +colors[2] + " is not of my preference."); //code 5

        //1.2 Integer Array Linear
        // this code is the same as a string array linear but:
        // 'string' will be replaced with 'int'
        // no quotations inside the curly braces {} because this is int not string.

        int [] ages = new int[] {4,2,31,25};
        System.out.println("The age of "+names[0]+ " is "+ages[0]+ ", the age of "+names[1]+ " is "+ages[1]+ ", the age of "+names[3]+" is "+ages[2]+ " and the age of "+names[2]+ " is "+ages[3]); //code 6

        //----------------------------------------------------------------------------------

        //2. ArrayList
        //This command can also be used to define 'arrays'
        //better choice than linear array as we are not restricted to define all the values with in line
        //the command must be called with a uppercase 'A'of array and uppercase 'L' of List. so it will look like 'ArrayList'
        //Brackets [] wont be used
        //<> Will be used

        //2.1 ArrayList String

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Long Island");//0
        cities.add("Houston");//1
        cities.add("Islamabad");//2
        cities.add("Istanbul");//3
        System.out.println("I currently live in "+cities.get(1)+ " but will be moving back to "+cities.get(0)+ " after i return from my trip to "+cities.get(2)+ ". One day i plan to visit " +cities.get(3)+ ",InShaAllah"); //code 7

        //2.2 ArrayList integer
        ArrayList<Integer> areaCode = new ArrayList<>();
        areaCode.add(631);//0
        areaCode.add(832);//1
        areaCode.add(331);//2
        areaCode.add(989);//3

        System.out.println("The area code of "+cities.get(0)+ " is "+areaCode.get(0)+ ". The area code for "+cities.get(1)+ " is "+areaCode.get(1));//code 8

        //----------------------------------LOOPS---------------------------------------------------------------
        //Loop-statements allow us to execute a statement or series of statements multiple times.

        // --------------------------------------1.For loop-----------------------------------------------------
        // Written in one line
        // Has 3 parts:
        // Part 1 is initialization 'int i=0;'
        // Part 2 is Condition
        // Part 3 execution if condition is met or exist from loop if condition is not met

        //EXAMPLE FOR LOOP
        //The following arraylist will be used
        //ArrayList<String> cities = new ArrayList<>();
        //        cities.add("Long Island");//0
        //        cities.add("Houston");//1
        //        cities.add("Islamabad");//2
        //        cities.add("Istanbul");//3


        for (int i = 0; i < cities.size();i++) {
            System.out.println("My cities are " + cities.get(i));
        }//end of loop
        // in line 90 the gatekeeper/condition statement is variable.size bc even if the number of the variables increase this wont effect us. It will automatically size the the arraylist and print everything. WE could have put a hardcoded number i was less than but then we would need to change that number as the list increases/

        for (int i = 0; i <3;i++) {
            System.out.println("My cities are "+cities.get(i));
        }//end of loop code 10


        //--------------------------2. WHILE LOOP-----------------------------------------------------------------------

        //String [] zipcode = new String[]{"11218", "22218", "33218", "44218"};

        //initialization
        int i = 0;
        //define endpoint in while loop
        while (i < zipcode.length) {
            System.out.println("My zipcodes is "+ zipcode[i]);
            i=i+1;
        }//end of while loop

    }//end of main
}//end of java class
