import java.util.Scanner;
public class AddTwoMatrix
{
  public static void main(String args[])
  {
    int numberOfRows, numberOfColumns, row, column;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter the number of rows and columns of matrix");
    numberOfRows = in.nextInt();
    numberOfColumns = in.nextInt();

    int first[][] = new int[numberOfRows][numberOfColumns];
    int second[][] = new int[numberOfRows][numberOfColumns];
    int sum[][] = new int[numberOfRows][numberOfColumns];

    System.out.println("Enter the elements of first matrix");

    for (row = 0; row < numberOfRows; row++)
      for (column = 0; column < numberOfColumns; column++)
        first[row][column] = in.nextInt();

    System.out.println("Enter the elements of second matrix");

    for (row = 0 ; row < numberOfRows; row++)
      for (column = 0 ; column < numberOfColumns; column++)
        second[row][column] = in.nextInt();

    for (row = 0; row < numberOfRows; row++)
      for (column = 0; column < numberOfColumns; column++)
        sum[row][column] = first[row][column] + second[row][column];  //replace '+' with '-' to subtract matrices

    System.out.println("Sum of the matrices:");

    for (row = 0; row < numberOfRows; row++)
    {
      for (column = 0; column < numberOfColumns; column++)
        System.out.print(sum[row][column] + "\t");

      System.out.println();
    }
  }
}