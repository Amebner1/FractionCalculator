import java.util.Scanner;

public class Fraction
{
    // Create your instance variables and constructor here
    private int numerator;
    private int denominator;

    /**
     * This method creates a Fraction Object using a String.
     * The fraction will always become improper
     *
     * @param frac takes a String thats a fraction and makes it an improper fractions
     */
    public Fraction (String frac)
    {
        Scanner take = new Scanner(frac);
        int whole = 0;

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
        }
        if (whole != 0){
            if (whole < 0){
                numerator = whole * denominator - numerator;
            }
            else {
                numerator = whole * denominator + numerator;
            }
        }
    }

    /**
     * This method returns the numerator from a Fraction object
     * @return int the numerator
     */
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }

    /**
     *
     * @param x
     */
    public void setNumerator(int x) {
        x = numerator;
    }
    public void setDenominator(int x) {
        x = denominator;
    }
    public void add(Fraction other) {
        numerator = other.getNumerator() * denominator + (other.getDenominator() * numerator);
        denominator = other.getDenominator() * denominator;
    }
    public void subtract(Fraction other) {
        // IMPLEMENT THIS METHOD
        numerator = other.getNumerator() * denominator *-1 + (other.getDenominator() * numerator);
        denominator = other.getDenominator() * denominator;
    }
    public void multiply(Fraction other) {
        // IMPLEMENT THIS METHOD
        numerator = numerator * other.getNumerator();
        denominator = other.getDenominator() * denominator;
        if (denominator < 0) {
            denominator *= -1;
        }
    }
    public void divide(Fraction other) {
        if (numerator < 0 && other.getNumerator() < 0) {
            numerator *= -1;
        }
        else if (other.getNumerator() < 0 ){
            numerator *= -1;
        }
        numerator = numerator * other.getDenominator();
        denominator = denominator * other.getNumerator();
        if (denominator < 0) {
            denominator *= -1;
        }
    }

    public int gcf(int n, int d) {
        if (d == 0){
            return n;
        }
        else {
            return gcf(d, n % d);
        }
    }

    public void simplify(){
        int f;

        f = gcf(numerator, denominator);
        if (f < 0){
            f *= -1;
        }
        numerator /= f;
        denominator /= f;


    }

    public String toString() {
        if (numerator == 0){
            return "0";
        }
        else if (denominator == 1){
            return numerator + "";
        }
        else if (numerator > denominator){
            int whole = numerator / denominator;
            numerator = numerator %denominator;
            return whole + "_" + numerator + "/" + denominator;
        }
        else if (numerator*-1 > denominator){
            int whole = numerator / denominator;
            numerator = (numerator %denominator) * -1;
            return whole + "_" + numerator + "/" + denominator;
        }
        else {
            return numerator + "/" + denominator;
        }
    }
}