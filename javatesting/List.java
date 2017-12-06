/* ***************************************************
 * Brad Raynaud
 * 10/15/2017
 * List.java
 *
 * Solves the problem presented by the Assignment#4 to generate an output that
 * matches the provided .txt file. The code has been compared using the FC command
 * and no differences have been found
 *************************************************** */

 // the Node class
  class Node
  {
  	private int data;
  	private Node link;

  	// constructor
  	public Node()
  	{
  		this.data = 0;
  		this.link = null;
  	}

  	// accessor and mutator for the data component
  	public int getData()
  	{
  		return this.data;
  	}

  	public void setData(int data)
  	{
  		this.data = data;
  	}

  	// accessor and mutator for the link component
  	public Node getLink()
  	{
  		return this.link;
  	}

  	public void setLink(Node link)
  	{
  		this.link = link;
  	}
  }

  // the List class
  class List
  {
  	public static final int MAX_SIZE = 50;

  	private Node head;
  	private Node tail;
  	private Node curr;
    // temp was created to avoid have to create repeated temp nodes
  	private Node temp;
  	private int num_items;

  	// constructor
  	// remember that an empty list has a "size" of -1 and its "position" is at -1
  	public List()
  	{
  		temp = curr = tail = head;
  		num_items = 0;
  	}

  	// copy constructor
  	// clones the list l and sets the last element as the current
  	public List(List l)
  	{
  		curr = head;
  		int n;
  		int lPos = l.GetPos();
  		l.First();
  		for (int i = 0; i < l.GetSize(); i++)
  		{
  			n = l.GetValue();
  			InsertAfter(n);
  			l.Next();
  		}
  		l.SetPos(lPos);
  	}

  	// navigates to the beginning of the list
  	public void First()
  	{
  		curr = head;
  	}

  	// navigates to the end of the list
  	// the end of the list is at the last valid item in the list
  	public void Last()
  	{
  		curr = tail;
  	}

  	// navigates to the specified element (0-index)
  	// this should not be possible for an empty list
  	// this should not be possible for invalid positions
  	public void SetPos(int pos)
  	{
  		if (!IsEmpty() && pos < num_items)
  		{
  			First();
  			while (GetPos() != pos)
  			{
  				Next();
  			}
  		}
  	}

  	// navigates to the previous element
  	// this should not be possible for an empty list
  	// there should be no wrap-around
  	public void Prev()
  	{
  		if (!IsEmpty())
  		{
  			temp = head;
  			while (temp.getLink() != curr)
  			{
  				temp = temp.getLink();
  			}
  			curr = temp;
  		}
  	}

  	// navigates to the next element
  	// this should not be possible for an empty list
  	// there should be no wrap-around
  	public void Next()
  	{
        // moves curr to the next item in the List
  		if (!IsEmpty() && curr != tail)
  			curr = curr.getLink();
  	}

  	// returns the location of the current element (or -1)
  	public int GetPos()
  	{
  		if (IsEmpty()) // if empty return -1
  			return -1;
  		else
  		{
  			int i = 0;
  			temp = head;
            // if temp = curr then while loop doesnt run and returns 0
			while (temp != curr)
			{
				temp = temp.getLink();
				i++;
			}
  			return i;
  		}
  	}

  	// returns the value of the current element (or -1)
  	public int GetValue()
  	{
  		if (IsEmpty()) // if empty returns -1
  			return -1;
		return curr.getData(); // else return curr's value
  	}

  	// returns the size of the list
  	// size does not imply capacity
  	public int GetSize()
  	{
  		return num_items;
  	}

  	// inserts an item before the current element
  	// the new element becomes the current
  	// this should not be possible for a full list
  	public void InsertBefore(int data)
  	{
  		if (!IsFull()) // if full dont insert
  		{
  			if (curr == head) // if curr equals head then new node becomes head
  			{
  				Node n = new Node();
  				n.setData(data);
  				if (curr == null)
  					curr = n;
  				else
  				{
  					n.setLink(curr);
  					curr = n;
  				}
  				head = curr;
  				num_items++;
  			}
  			else // uses insert after after setting curr to previous node
  			{
  				Prev();
  				InsertAfter(data);
  			}
  		}
  	}

  	// inserts an item after the current element
  	// the new element becomes the current
  	// this should not be possible for a full list
  	public void InsertAfter(int data)
  	{
  		if (!IsFull())
  		{
  			Node n = new Node();
            n.setData(data);
  			if (IsEmpty()) // if List is empty create a new node and make it head
  			{
  				head = n;
  				tail = n;
  			}
  			else if (curr == tail) // if curr == tail make the new node tail
  			{
  				tail.setLink(n);
  				tail = n;
  			}
  			else // puts the new node after curr and sets the Links
  			{
  				n.setLink(curr.getLink());
  				curr.setLink(n);
  			}
  			curr = n;
  			num_items++;
  		}
  	}
  	// removes the current element (collapsing the list)
  	// this should not be possible for an empty list
  	public void Remove()
  	{
  		if (!IsEmpty())
  		{
            if (head == tail)
                head = tail = curr = null;
            else if (curr == tail) // makes the node before tail link to null
            {
                Prev();
                curr.setLink(null);
                tail = curr;
            }
            else if (curr == head) // sets the next node equal to head
            {
            	Next();
            	head = curr;
            }
            else // makes the previous node link to the node after curr
            {
            	Prev();
            	curr.setLink(curr.getLink().getLink());
            	Next();
            }
            num_items--; // reduce items by one
        }
  	}

  	// replaces the value of the current element with the specified value
  	// this should not be possible for an empty list
  	public void Replace(int data)
  	{
  		if (!IsEmpty()) // ensures that list is not empty
  			curr.setData(data);
  	}

  	// returns if the list is empty
  	public boolean IsEmpty()
  	{
  		if (head == null)
  			return true;
  		else
  			return false;
  	}

  	// returns if the list is full
  	public boolean IsFull()
  	{
  		if (num_items == MAX_SIZE)
  			return true;
  		else
  			return false;
  	}

  	// returns if two lists are equal (by value)
  	public boolean Equals(List l)
  	{
  		if (GetSize() == l.GetSize())// if two lists are not the same size then return false
  		{
  			int tempPos = GetPos();
  			int lPos = l.GetPos();
  			First();
  			l.First();
  			while (curr != tail)
  			{
  				if (GetValue() != l.GetValue()) // if values are not equal returns false
  				{
  					SetPos(tempPos);
  					l.SetPos(lPos);
  					return false;
  				}
  				Next(); // next node
  				l.Next(); // next node
  			}
  			SetPos(tempPos);
  			l.SetPos(lPos);
  			return true;
  		}
  		else
  			return false;
  	}

  	// returns the concatenation of two lists
  	// l should not be modified
  	// l should be concatenated to the end of *this
  	// the returned list should not exceed MAX_SIZE elements
  	// the last element of the new list is the current
  	public List Add(List l)
  	{
        int tempPos = this.GetPos();
        List tempList = new List(this);
        tempList.Last();
        int Value;
        int lPos = l.GetPos();
        l.First();

        for (int i = 0; i < l.GetSize(); i++)
        {
            Value = l.GetValue();
            tempList.InsertAfter(Value);
            l.Next();
        }
        l.SetPos(lPos);
        this.SetPos(tempPos);

        return tempList;
  	}

  	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
  	// the string "NULL" should be returned for an empty list
  	public String toString()
  	{
  		if (IsEmpty())
        {
            return "NULL";
        }
        else
  		{
            temp = head;
  			String s = "";
  			while (temp != null)
  			{
  				s += (temp.getData() + " ");
  				temp = temp.getLink();
  			}
  			return s;
  		}
  	}
  }
