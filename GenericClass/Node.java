public class Node<jordan>
{
    private jordan data;
    private Node<jordan> link;

    public Node()
    {
	data = null;
	link = null;
    }

    public void setData(jordan value)
    {
	this.data = value;
    }
    
    public jordan getData()
    {
	return this.data;
    }

    public void setLink(Node<jordan> n)
    {
	link = n;
    }

    public Node<jordan> getLink()
    {
	return this.link;
    }
}
