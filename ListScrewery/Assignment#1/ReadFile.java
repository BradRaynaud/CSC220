import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args) {
        try {
            int [] digits = new int [10];
            int total = 0;
            //Create a new scanner variable to store the input from chosen file
            Scanner input = new Scanner(System.in);

            while (input.hasNextLine())
            {
              char leadint = input.nextLine().charAt(0);
              int x = Character.getNumericValue(leadint);
              digits[x]++;
              total ++;

            }
            float[] percentages = calculatePercentages(digits, total);
            printResult(digits, percentages, total);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static float[] calculatePercentages(int [] Results, int total)
    {
        float[] percentages = new float [10];
        for(int i = 0; i < Results.length; i++)
        {
                float percent = (Results[i] * 100.0f) / total;
                percentages[i] = percent;
        }
        return percentages;
    }
    public static void printResult(int [] temp,float[] percentages,int total)
    {
        System.out.println("-------------------------------");
        System.out.println("Leading Digit   Count         %");
        System.out.println("-------------------------------");
        for(int i = 0; i < temp.length; i++)
            System.out.format("%-13d %-10d %5.2f%-1s %n",i,temp[i],percentages[i], "%");
        System.out.println("-------------------------------");
        System.out.format("%-13s %-9d %s %n","TOTAL",total,"100.00%");
        System.out.println("===============================");
    }

}
