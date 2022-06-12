package Day3_043022;

import java.util.ArrayList;

public class HasanDay3_Practice {
    public static void main(String[] args) {
        //WE WILL COVER THE FOLLOWING:  1-If statement, 2-If else, 3-else if, 4-if else with loop, 5-else if with loop

        //1- if statement
        int a = 2;
        int b = 3;
        int c = 5;
        if (a<b){
            System.out.println("a is less than b");
        }


        // 2- if else
        if (a+b<c){
            System.out.println("a plus b is less than c");
        } else {
            System.out.println("a plus b is NOT less than c");
        }

        //3- else if - this is 2 if else statements declared at once
        //ex. 1
        if (a+b<c) {
            System.out.println("a plus b is less than c");
        } else if (a+b>c){
            System.out.println("a plus b is greater than c");
        } else {
            System.out.println("a plus b is EQUALS to c");
        }

        //ex.2
        if (b==a) {
            System.out.println("b is equal to a");
        } else if (a + b == c) {
            System.out.println("a plus b equals c");
        } else {
            System.out.println("both statements are false");
    }

        //if statements with AND OPERATOR which is '&&'
        //only if both arguments in the if statement are true then it will print the sout
        if (a<b && a+b==c){
            System.out.println("Both statements in line 44 are true");
        }

        //if statements with OR OPERATOR which is ||
        //if either of the two are true the sout will successfully print
       if (b<a || a+b==c){
           System.out.println("One of the statements in line 50 is true");
       }

        // if with loop: Arrays can be looped and arrays along with loops can be used with conditional statements
        //ex. 1
        String [] fruit = new String [] {"apple","cherry","grape","mango"};
        //using a loop print only when the fruit is apple or grape
        for (int i = 0; i< fruit.length;i++) {
            if (fruit[i]=="apple"){
                System.out.println("Fruit is "+ fruit[i]);
            }//end of if statement
        }//end of for loop

        // if else with loop
        for (int i = 0; i< fruit.length;i++) {
            if (fruit[i] == "orange") {
                System.out.println("Fruit is " + fruit[i]);
            }//end of if statement
            else {
                System.out.println("There is no fruit as orange");
            }
        }
        //ex. of more conditional loops
        //ex.1
        String[] veggies = new String[] {"corn","olives","carrot","mushroom"};
        for (int i = 0; i < veggies.length;i++) {
            if (veggies[i]=="carrot") {
                System.out.println("Veggies is "+veggies[i]);
            }//end of if
            else {
                System.out.println("No veggie as carrot in index");
            }//end of else
        } // end of loop

        //ex.2
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("White");
        colors.add("Blue");
        colors.add("black");
        for (int i=0;i< colors.size();i++) {
            if (colors.get(i)=="Blue"){
                System.out.println("This index in variable 'colors' "+colors.get(i));
            }//end of if
            else {
                System.out.println("This index in variable 'colors' is not Blue");
            } //end of else
        }//end of loop

        //ex.3
        for (int i=0;i< colors.size();i++) {
            if (colors.get(i)=="Blue" || colors.get(i)=="White"){
                System.out.println("This index in variable 'colors' "+colors.get(i));
            }//end of if
            else {
                System.out.println("This index in variable 'colors' is not Blue or White");
            } //end of else
        }//end of loop

        //ex.4

            for (int j = 0; j< fruit.length; j++){
                 for (int i = 0; i< colors.size();i++){
                    if (colors.get(i)=="red"&& fruit[j]=="apple"){
                        System.out.println("My "+fruit[j]+ " is "+colors.get(i));
                    }//end of if
                    else {
                        System.out.println("My fruit is not apple and red at same time");
                    }//end of else
                }// end of second for loop
            }//end of first loop


   }//end of main
}//end of class