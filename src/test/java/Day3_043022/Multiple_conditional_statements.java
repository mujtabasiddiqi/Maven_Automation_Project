package Day3_043022;

public class Multiple_conditional_statements {
    public static void main(String[] args) {
        int a = 0;
        int b = 2;
        int c = 3;

        //if a+b is less than c than print the result
        //if a+b is greater than c then print the result
        //Finally print a+b is equal to c
        if(a+b < c) {
            System.out.println("a & b is less than c");
        } else if(a+b > c){
            System.out.println("a & b is greater than c");
        } else {
            System.out.println("a & b is equal to c");
        }// end of conditions

        //declare additional variables
        int d = 4;
        int e = 5;
        int f = 6;
        //or operator with if statement
        // || is used for an or operator -- one of the conditions need to be true only
        // && is used for an and operator -- both conditions need te be true
        if (d < e || f < e){
            System.out.println("d is less than e or f is less than e");
        } else {
            System.out.println("condition is not true");
        }

    }//end of main
}//end of java class
