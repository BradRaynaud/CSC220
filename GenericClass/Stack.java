public class Stack<jordan>
{
    private Node<jordan> head;

    public Stack()
    {
	head = null;
    }

    public void push(jordan x)
    {
	// create a new node with the appropriate information.
	Node<jordan> n = new Node<jordan>();
	n.setData(x);

	// make the new node point to the original head, and then update
	// head to refer to the new node. (kinda like inserting before)
	n.setLink(head);
	head = n;
    }

    public jordan pop()
    {
	if (head != null)
	{
	    Node<jordan> n = head;

	    head = head.getLink();

	    return n.getData();
	}

	return null;
    }

    public String toString()
    {
	if (head == null)
	    return "NULL";
	else
	{
	    String s = "";
	    Node<jordan> temp = head;

	    while (temp != null)
	    {
		s += temp.getData().toString() + ", ";
		temp = temp.getLink();
	    }
	    return s;
	}
    }

}
