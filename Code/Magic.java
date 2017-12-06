public class Magic
{
    public static void main(String [] args)
    {
	Stack s = new Stack();

	s.push(10);
	s.push(11);
	s.push(12);
	s.push(13);
	s.push(14);
	s.push(15);
	s.push(16);
	s.push(17);
	s.push(18);

	int x = s.pop();

	while(x != -1)
	{
	    System.out.println(x + ",");
	    x = s.pop();
	}

    }
}
