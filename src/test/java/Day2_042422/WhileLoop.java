package Day2_042422;

public class WhileLoop {
    public static void main(String[] args) {
   //Iterate through zipCode and its streetNumber using Linear array and while loop
   String[] zipCodes = new String[]{"11218","11219","11213","10001"};
   int[] streetNumber = new int[]{111,222,333,444};

   //initialize your starting point before calling while loop
   int i = 0;
   //define the end point in while loop
   while (i < streetNumber.length){
       System.out.println("My zipCode is " + zipCodes[i] + " streetNumber " + streetNumber[i] );

       //incrementing
       i = i + 1;


   }//end of while loop


    }//end of main method
}//end of java class
