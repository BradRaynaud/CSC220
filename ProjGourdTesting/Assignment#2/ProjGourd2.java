/* ***************************************************
 * <Cade White & Brad Raynaud>
 * <9/29/2017>
 * <ProjGourd1.java>
 *
 * This program solves the problem presented by ProjectGourd2 by reading the
 * provided TextFile and finding the greatest sum of four integers in one row.
 * !!Warning: to make the program function correctly you must
 * import the text file using java terminal commands!!
 *************************************************** */
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

class ProjGourd2
{
  public static void main(String [] args)
  {
    //Calls function that creates an integer array for the text file
    int[][] intarray = arrayCreator();
    //Calls a function that calculates the maximum sum
    int maxsum = computeArray(intarray);

    //Prints biggest sum on its own line
    System.out.print(maxsum);
  }
  //Creates a 20x20 array based on the text file of 400 integers
  public static int[][] arrayCreator()
  {
    //Initializes array to be a 20x20 2D integer array
    int[][] initarray = new int[20][20];

    Scanner input = new Scanner(System.in);

    //Continue until no more integers are found in file
    while (input.hasNextInt())
    {
      //Continues through each row, but waits for each column to fill out
      for (int i = 0; i < initarray.length; i++)
      {
        //Fills out each part of the column in its respective row
        //with the next int in the text file
        for (int j = 0; j < initarray.length; j++)
        {
          initarray[i][j] = input.nextInt();
        }
      }
    }
    //Returns int array "initarray" to be used in main
    return initarray;
  }

  //Calculates the biggest sum of 4 consecutive numbers
  //Does not wrap around
  public static int computeArray(int[][] arr)
  {
    //Initializes the variable that will be the biggest sum
    //and sets it to 0
    int bigsum = 0;

    //Same thing as in "createArray"
    for (int i = 0; i < 20; i++)
    {
      //Same thing as in "createArray", except only to 17 to account for
      //the fact that addition below is based on the position of j
      //plus 3
      for (int j = 0; j < 17; j++)
      {
        //This calculates the sum of 4 consecutive numbers in array "arr"
        //and sets it equal to integer "checker"
        int checker = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
        arr[i][j + 3];
        //Checks if the sum of the 4 consecutive numbers is greater than
        //the previous biggest sum
        if (bigsum < checker)
        {
          //If it is, it sets biggest sum equal to the newly found
          //biggest sum
          bigsum = checker;
        }
      }
    }
    //Returns "bigsum" to be printed in main
    return bigsum;
  }
}
