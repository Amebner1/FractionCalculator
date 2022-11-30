import java.util.Scanner;

public class Fraction
{
    // Create your instance variables and constructor here
    private int numerator;
    private int denominator;

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
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
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
    public String toString() {
        if (numerator == 0){
            return "0";
        }
        else {
            return numerator + "/" + denominator;
        }
    }
}