public class Node
{
    private int data;
    private Node link;

    public Node()
    {
	data = 0;
	link = null;
    }

    public void setData(int value)
    {
	data = value;
    }
    
    public int getData()
    {
	return this.data;
    }

    public void setLink(Node n)
    {
	link = n;
    }

    public Node getLink()
    {
	return this.link;
    }
}
