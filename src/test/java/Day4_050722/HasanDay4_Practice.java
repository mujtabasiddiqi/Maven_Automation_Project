package Day4_050722;

public class HasanDay4_Practice {
    public static void main(String[] args) {
        // LEARNING ABOUT STRING SPLITS
        // Splits in Java: Split command allows you to divide/separate from a string
        // The purpose of the split command is to use portion of the string. ie its string manipulation
        // Ex. String is "My name is John" but i want just 'john' in my code. So i will use split to do that.
        // Once a string is split it is an array so during our code we will refer to the split as an index number like in array. Just keep in mind that the first index is 0 so in this example 'john' would be 3.
        // CODE:
        // String[] splitmessage = message.split("");
        // After this above code the string is now an array
        // We can split the msg by a common character so in this case we can split it by single space...??? i need to understand this better
        // In our case: Now this string is an array by splitting by a single space so each word is an object now.
        // John will be '3'

       // Declare String Variable
        String splitMessage1 = "My name is john";

        // declaring an array of string // Slitting the String
        String[] splitMessageArray1 = splitMessage1.split( " ");

        //print out John to the console
        System.out.println("My first name is "+ splitMessageArray1[3]);

        //second example with "_" ie underscore being the common expression rather than space. NOTE: in our array of string statement we placed a space between the quotes after regex: this is bc the common expression in the original string is space. So when declaring it into an array we identify that the common expression is space and it should ignored when assigning an index number to each character in the string array.
        // so now we wil use underscore as a common expression to show the same code.
        //***IMPORTANT*** Common expression simply means from where the index '1' will start. With space being the common expression the index 1 is 'name'. So 'My' is index 0. So if i put a space after the first quotations then My will be index 1.
        //NOTE: I will change the name of string variable, the split array variable so we dont get an error of "string variable already exists etc."
        String splitMessage_ = "My_name_is_john";

        // declaring an array of string // Slitting the String
        String[] splitMessageArray_ = splitMessage_.split( "_");

        //print out John to the console
        System.out.println("My first name is "+ splitMessageArray_[3]);

        //practice

        //

    } //end of main
} //end of class
