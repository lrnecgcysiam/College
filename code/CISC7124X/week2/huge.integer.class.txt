import java.io.*;

public class Huge_Integer
{
private int[] intArray;
private int numDigits; // stores the number of digits in intArray

public Huge_Integer(String s)
{
intArray = new int[40];
numDigits = 0;
// call parse(s)
}

public Huge_Integer( )
{
intArray = new int[40];
numDigits = 0;
  
}
  
public void parse(String s)
{
// Add each digit to the arrays
// update numDigits
}

public static Huge_Integer add(Huge_Integer theHugeInteger, Huge_Integer hugeInt2)
{
// Create hugeInt3
// Loop
// Add digits from theHugeInteger and hugeInt2,
// Store in corresponding hugeInt3
// End
//
// return hugeInt3   
}

public static Huge_Integer subtract(Huge_Integer theHugeInteger, Huge_Integer hugeInt2)
{
// Create hugeInt3
// Loop
// Subtract hugeInt2 digit from theHugeInteger,
// Store in corresponding hugeInt3
// End
//
// return hugeInt3   

}

public static boolean isEqualTo(Huge_Integer theHugeInteger, Huge_Integer hugeInt2)
{
// return true if the value represented by
// elements of theHugeInteger.intArray is equal to
// value represented by elements of hughInt2.intArray

}

public static boolean isNotEqualTo(Huge_Integer theHugeInteger, Huge_Integer hugeInt2)
{
// return true if the value represented by
// elements of theHugeInteger.intArray is not equal to
// value represented by elements of hughInt2.intArray

}

public static boolean isGreaterThan(Huge_Integer theHugeInteger, Huge_Integer hugeInt2)
{
// return true if the value represented by
// elements of theHugeInteger.intArray is greater than
// value represented by elements of hughInt2.intArray

}

public static boolean isLessThan(Huge_Integer theHugeInteger, Huge_Integer hugeInt2)
{
// return true if the value represented by
// elements of theHugeInteger.intArray is less than
// value represented by elements of hughInt2.intArray
}

public static boolean isGreaterThanOrEqualTo(Huge_Integer theHugeInteger, Huge_Integer hugeInt2)
{
// return true if the value represented by
// elements of theHugeInteger.intArray is greater than or equal to
// value represented by elements of hughInt2.intArray
}

public static boolean isZero(Huge_Integer theHugeInteger )
{
// return true if the value represented by
// elements of theHugeInteger.intArray is 0
}

public String toString( )
{
// return string representation of this object
}

}