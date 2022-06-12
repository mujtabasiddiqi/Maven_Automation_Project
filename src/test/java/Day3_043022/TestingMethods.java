package Day3_043022;

import ReuseableLibraries.ReusableMethods;

public class TestingMethods {
    public static void main(String[] args) {


        //call the add two number method and execute it
        ReusableMethods.addTwoNumbers(20,30);

        //let's create an example
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        System.out.println("the Two numbers are " + (a+b));
        System.out.println("the two numbers are " + (c+d));

        //Now let's say we want to add two more numbers up there
        //After adding two more numbers we will have to print it out again
        // We don't want to do that, it's lengthy and looks unprofessional instead we can use Reusable method
        //We can use reusable method and just change the numbers we want to execute

        ReusableMethods.addTwoNumbers(3,4);
        ReusableMethods.addTwoNumbers(5,4);
        ReusableMethods.addTwoNumbers(8,4);

    }//end of main
}//end of java class
