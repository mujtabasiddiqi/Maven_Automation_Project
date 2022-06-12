package Day1_042322;

public class Hasanday1_practice {
    public static void main(String[] args) {
        //1. printing out welcome to automation class
        System.out.println("Welcome to automation class"); //code 1

        //2. datatype
        // 2.1 declaring a string with some value
        String myVariable = "Welcome to automation class 101";

        // understanding string code
        //1- 'S' of string must be capital
        //2- the string variable will be declared after 'string' is declared without anything but 'space' between string and its variable. So no =, [], {}, "" etc.
        //3- '=' will be used after string variable (myVariable in this case) prior to declaring the value of the string variable.
        //4- the value of the string variable must be within quotation marks "" in this case " Welcome to automation class 101"
        //5- the code must be closed with semicolon ' ; '
        //6- String variable can be alphabet, alphanumerical, special character or even numerical.

        // 2.2 declaring integer with some value
        int myNumber = 200;

        //understanding int code
        //1- int will be declared without any capital letter
        //2- after int the variable will be declared with just space nothing else
        //3- '=' will be used to declare value for int variable
        //4- value will be declared without quotations
        //5- semicolon to close code ' ; '

        //2.3 What is concatenation? it's to combine multiple variables or comments to variables in a print statement using '+' sign.
        //2.4 Printing out 'welcome to automation class 101 my number is 200' using string and int variables. So concatenation will be used
        System.out.println(myVariable + " and my role number is " + myNumber); //code 2

        //2.5 declaring multiple other string and int values
        String myVariable2 = "Sumon";
        int myZipcode = 77084;

        //2.6 Printing out concatenated statement of multiple string variables and int variables and comments
        System.out.println(myVariable + ", my IT professor is " + myVariable2 + ". My role number is " + myNumber + " and my zipcode is " + myZipcode + ".");


    }//end of main method
}//end of java class
