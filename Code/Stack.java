public class Stack
{
    private Node head;

    public Stack()
    {
	head = null;
    }

    public void push(int x)
    {
	// create a new node with the appropriate information.
	Node n = new Node();
	n.setData(x);

	// make the new node point to the original head, and then update
	// head to refer to the new node. (kinda like inserting before)
	n.setLink(head);
	head = n;
    }

    public int pop()
    {
	if (head != null)
	{
	    Node n = head;
	    
	    head = head.getLink();

	    return n.getData();
	}

	return -1;
    }
}


