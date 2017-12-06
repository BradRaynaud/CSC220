
class Recursion
{
     public static void main(String args[])
     {

         int rows = 10;
         int columns = 15;

         int[][] matrix = new int[rows][columns];
         for(int r = 0; r < rows; r++)
         {
             for(int c = 0; c < columns; c++)
             {
                 if(r > c)
                    matrix[r][c] = 0;
                 else
                    matrix[r][c] = 1;
             }
         }

        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<columns; j++)
            {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }

    }
}
