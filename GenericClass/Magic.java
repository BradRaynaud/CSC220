import java.util.Random;

public class Magic
{
    public static void main(String [] args)
    {
	Stack<Integer> s = new Stack<Integer>();

	s.push(10);
	s.push(11);
	s.push(12);
	s.push(13);
	s.push(14);
	s.push(15);
	s.push(16);
	s.push(17);
	s.push(18);
    
	System.out.println(s);

	Integer x = s.pop();
	
	while(x != null)
	{
	    System.out.print("after popping:\t");
	    System.out.println(s);
	    x = s.pop();
	}

	Stack<Character> t = new Stack<Character>();
	Random r = new Random();

	for(int i = 0; i < 20; i++)
	{
	    Character c = (char)(r.nextInt(57) + 65);
	    t.push(c);
	}

	System.out.println(t);
	Character y = t.pop();
	while(y != null)
	{
	    System.out.print("after popping:\t");
	    System.out.println(t);
	    y = t.pop();
	}


    }

}
