public class Fraction
{
    // Create your instance variables and constructor here
    private int numerator;
    private int denominator;

    public Fraction (int num, int den)
    {
        numerator = num;
        denominator = den;
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
    }

    public String toString() {
        return numerator +" / "+ denominator;
    }
}