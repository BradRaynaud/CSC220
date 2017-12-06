/* ***************************************************
* <Brad Raynaud>
* <10/19/2017>
* <Stack.java>
*
* Generic Queue class for the Assignment#7 on Moodle
*************************************************** */
class Queue<generic>
{
    private List<generic> l;

    // Constructor for the Queue Class
    public Queue()
    {
        l = new List<generic>();
    }

    // Copy Constructor for the Queue Class
    public Queue(Queue<generic> s)
    {
        l = new List<generic>(s.l);
    }

    // Adds a Node to the end of the Queue(List)
    public void Enqueue(generic data)
    {
        this.l.Last();
        this.l.InsertAfter(data);
    }

    // Removes a Node from the front of the list and returns the value it held
    public generic Dequeue()
    {
        this.l.First();
        generic data = this.l.GetValue();
        this.l.Remove();
        return data;
    }

    // Returns the value of the first position in the Queue
    public generic Peek()
    {
        this.l.First();
        return this.l.GetValue();
    }

    // Returns the size of the Queue
    public int Size()
    {
        return this.l.GetSize();
    }

    // Returns True if Queue is Empty else returns False
    public boolean IsEmpty()
    {
        return this.l.IsEmpty();
    }

    // Returns True if Queue is full else Return False
    public boolean IsFull()
    {
        return this.l.IsFull();
    }

    // Returns True if Queue is equal to the Queue provided in the argument
    public boolean Equals(Queue<generic> s)
    {
        return this.l.Equals(s.l);
    }

    // concatenates two Queues
    public Queue<generic> Add(Queue<generic> s)
    {
        Queue<generic> temp = new Queue<generic>();
        temp.l = this.l.Add(s.l);
        return temp;
    }

    // String function for the Queue class
    public String toString()
    {
        return this.l.toString();
    }
}
