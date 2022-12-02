import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        // TODO: Read the input from the user and call produceAnswer with an equation
        System.out.println("Input 2 Fractions with a space in between them");
        String fraction = input.nextLine();
        input.close();
        String why = produceAnswer(fraction);
        System.out.println(why);
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
        Scanner in = new Scanner(input);
        in.useDelimiter(" ");
        String frac2 = "";
        String frac1 = "";
        String symbol = "";

        if (in.hasNextLine()){
            frac1 = in.next();
        } /* Checkpoint 1 CODE*/
        if (in.hasNextLine()){
            symbol = in.next();
        }
        if (in.hasNextLine()) {
            frac2 = in.next();
        }
        in.close();

        Scanner take = new Scanner(frac2);
        int whole = 0;
        int numerator = 0;
        int denominator = 0;

        take.useDelimiter("[^-0-9]");

        if (take.hasNextInt()){
            whole = take.nextInt();
            if (take.hasNextInt()){
                numerator = take.nextInt();
                if (take.hasNextInt()){
                    denominator = take.nextInt();
                }
                else {
                    denominator = numerator;
                    numerator = whole;
                    whole = 0;
                }
            }
            else {
                denominator = 1;
            }
        } /* Checkpoint 2 CODE*/
        take.close();

        Fraction fraction1 = new Fraction(frac1);
        Fraction fraction2 = new Fraction(frac2);

        if (symbol.equals("+")){
            fraction1.add(fraction2);
        }
        else if (symbol.equals("-")){
            fraction1.subtract(fraction2);
        }
        else if (symbol.equals("*")){
            fraction1.multiply(fraction2);
        }
        else if (symbol.equals("/")){
            fraction1.divide(fraction2);
        }

        fraction1.simplify();

        return fraction1.toString();
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
