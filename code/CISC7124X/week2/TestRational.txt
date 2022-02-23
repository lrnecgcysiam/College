TestRational.java file:


public class TestRational {

   public static void main(String[] args) {
      
       Rational first_result = new Rational(1, 2);
       System.out.println("first_result : " + first_result);
       Rational second_result = new Rational(3, 4);
       System.out.println("second_result : " + second_result);
       System.out.println("Adding first_result and second_result and storing it in first_result : ");
       first_result.addition(second_result);
       System.out.println("first_result : " + first_result);
       System.out.println("Substracting first_result and second_result and storing it in first_result : ");
       first_result.substraction(second_result);
       System.out.println("first_result : " + first_result);
       System.out.println("Multiplying first_result and second_result and storing it in first_result : ");
       first_result.multiplication(second_result);
       System.out.println("first_result : " + first_result);
       System.out.println("dividing first_result and second_result and storing it in first_result : ");
       first_result.division(second_result);
       System.out.println("first_result : " + first_result);
   }

}