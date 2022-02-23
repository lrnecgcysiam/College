public class Rational {
   int numerator;
   int denominator;

   public Rational(int numerator, int denominator) {

       int temp = greatCommonDenominator(numerator, denominator);
       if (temp != 1) {
           this.numerator = numerator / temp;
           this.denominator = denominator / temp;
       } else {
           this.numerator = numerator;
           this.denominator = denominator;
       }
   }

   public void addition(Rational rat) {

       int numerator = this.numerator * rat.denominator + rat.numerator * this.denominator;
       int denominator = this.denominator * rat.denominator;
       Rational result;
       result = new Rational(numerator, denominator);
       this.numerator = result.numerator;
       this.denominator = result.denominator;
   }

   public void substraction(Rational rat) {

       int numerator = this.numerator * rat.denominator - rat.numerator * this.denominator;
       int denominator = this.denominator * rat.denominator;
       Rational result;
       result = new Rational(numerator, denominator);
       this.numerator = result.numerator;
       this.denominator = result.denominator;
   }

   public void multiplication(Rational rat) {

       int numerator = this.numerator * rat.numerator ;
       int denominator = this.denominator * rat.denominator;
       Rational result;
       result = new Rational(numerator, denominator);
       this.numerator = result.numerator;
       this.denominator = result.denominator;
   }
   public void division(Rational rat) {

       int numerator = this.numerator * rat.denominator ;
       int denominator = this.denominator * rat.numerator;
       Rational result;
       result = new Rational(numerator, denominator);
       this.numerator = result.numerator;
       this.denominator = result.denominator;
   }

   public String toString() {
       return "Rational [" + numerator + " / " + denominator + "]";
   }

   public static int greatCommonDenominator(int a, int b) {
       if (a == 0)
           return b;
       if (b == 0)
           return a;

       if (a == b)
           return a;
       if (a > b)
           return greatCommonDenominator(a - b, b);
       return greatCommonDenominator(a, b - a);
   }

}