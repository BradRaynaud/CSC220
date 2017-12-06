class Ackermann
{
    public static void main(String [] args)
    {
	System.out.println("Starting");
	for (int i = 0; i <= 5; i++)
	{
	    for(int j = 0; j <= 5; j++)
	    {
		long startTime = System.nanoTime();
		System.out.print("Ackermann(" + i + "," + j + ") = " + Acker(i, j) + "\t");
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Duration = " + (duration / 1000000000) + " seconds");
	    }
	}


    }

    public static int Acker(int m, int n)
    {
	if(m == 0)
	    return n+1;
	else if(n == 0)
	    return Acker(m - 1, 1);
	else 
	    return Acker(m-1, Acker(m, n - 1));
    }
}

