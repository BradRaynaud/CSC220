/* ***************************************************
 * <Cade White & Brad Raynaud>
 * <9/29/2017>
 * <ProjGourd1.java>
 *
 * This program solves the problem presented by ProjectGourd1 by reading the
 * provided textfiles and outputting the required table as per the parameters
 * of the assignment. !!Warning: to make the program function correctly you must
 * import the text files using java terminal commands!!
 *************************************************** */
import java.util.Scanner;

public class ProjGourd1
{

    public static void main(String[] args)
    {
        try
        {
            int [] digits = new int [10];
            int total = 0;
            //Create a new scanner variable to store the input from chosen file
            Scanner input = new Scanner(System.in);
            //While there are more lines to read in the file
            while (input.hasNextLine())
            {
              //Takes the leading integer of every number and sets it
              //to char "leadint"
              char leadint = input.nextLine().charAt(0);
              //Converts the char to int and sets it as "x"
              int x = Character.getNumericValue(leadint);
              //Since digits is an array of 10 spaces, incrementing it at
              //the xth position allows it to tally up all the leading integers
              digits[x]++;
              //increments total for everytime a new number is found so
              //the total number of numbers can be counted
              total ++;
            }
            //Calls calculatePercentages function with digits and total
            //in tow and sets it equal to float array "percentages"
            float[] percentages = calculatePercentages(digits, total);
            //calls printResult function to print the table with
            //digits array, percentages array, and total integer
            printResult(digits, percentages, total);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
    //Takes the "digits" array and total integer and finds the percent
    //of each and returns as a float array
    public static float[] calculatePercentages(int [] Results, int total)
    {
        //Initiliazes a new float array for the percent totals
        //to be stored in
        float[] percentages = new float [10];
        for(int i = 0; i < Results.length; i++)
        {
                //Multiplies the result at i in results array by 100
                //then divides by total to find percentage
                float percent = (Results[i] * 100.0f) / total;
                //Adds percent found to the percentage array
                percentages[i] = percent;
        }
        return percentages;
    }
    //Takes digits array, percentages array, and total integer and prints
    //it according to the provided table using System.out.format and
    // System.out.println
    public static void printResult(int [] temp,float[] percentages,int total)
    {
        System.out.println("-------------------------------");
        System.out.println("Leading Digit   Count         %");
        System.out.println("-------------------------------");
        // Prints each line of the table using system.out.format, the
        // percentages are stored as floats and are only printed to two decimal
        // places
        for(int i = 0; i < temp.length; i++)
            System.out.format("%-15d %-8d %5.2f%-1s %n",i,temp[i],percentages[i], "%");
        System.out.println("-------------------------------");
        // prints the line containing the total amount of numbers found using
        // the formatting for the above System.out.format()
        System.out.format("%-15s %-7d %s %n","TOTAL",total,"100.00%");
        System.out.println("===============================");
    }

}
