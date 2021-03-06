/* ***************************************************
* <Brad Raynaud>
* <10/19/2017>
* <List.java>
*
* This code is modified from what is provided on moodle to complete the objective
* of the Generic List assignment. Output was checked using FC and no differences were found
*************************************************** */

// the Node class
class Node<generic>
{
	private generic data;
	private Node<generic> link;

	// constructor
	public Node()
	{
		this.data = null;
		this.link = null;
	}

	// accessor and mutator for the data component
	public generic getData()
	{
		return this.data;
	}

	public void setData(generic data)
	{
		this.data = data;
	}

	// accessor and mutator for the link component
	public Node<generic> getLink()
	{
		return this.link;
	}

	public void setLink(Node<generic> link)
	{
		this.link = link;
	}
}

// the List class
public class List<generic>
{
	public static final int MAX_SIZE = 50;

	private Node<generic> head;
	private Node<generic> tail;
	private Node<generic> curr;
	private int num_items;

	// constructor
	// remember that an empty list has a "size" of -1 and its "position" is at -1
	public List()
	{
		this.num_items = 0;
		head = tail = curr = null;
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List<generic> l)
	{
		// Start by creating an empty list, and then storing the
		// position of l.curr so that you can reset it after using
		// it to cycle through l.
		this.num_items = 0;
		head = tail = curr = null;
		int temp = l.GetPos();

		// Move l.curr to the beginning of the list, and get one
		// value at a time from l, and insert it into *this. When
		// you are done, move curr back to where it was (as stored
		// in temp)
		l.First();
		for(int i = 0; i < l.GetSize(); i++)
		{
			InsertAfter(l.GetValue());
			l.Next();
		}
		l.SetPos(temp);
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
		// If the list is not empty, and the value of pos is between
		// 0 and the size of the list, then move curr to the
		// beginning, and then move it over in single steps until
		// the numer of steps is equal to the value required.
		if (!IsEmpty() && pos < GetSize() && pos >= 0)
		{
			First();
			for (int i = 0; i < pos; i++)
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
		// If the list is not empty, and curr is not at the head,
		// then proceed with the process of starting at the head and
		// moving over one node at a time until you either get to
		// the end or to the point where you are pointing to curr.
		// Update curr to that point such that it ends up pointing
		// to the position it was originally at.
		if (!IsEmpty() && curr != head)
		{
			Node<generic> n = head;
			while (n != null && n.getLink() != curr)
			n = n.getLink();

			curr = n;
		}

	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if(!(IsEmpty()) && curr != tail)
		curr = curr.getLink();
	}

	// returns the location of the current element (or -1)
	public int GetPos()
	{
		// If its empty, return -1
		if (IsEmpty())
		return -1;
		// Otherwise create a new Node reference and place it at the
		// head. Then keep on moving it over while increasing a
		// counter until it gets to the same value as curr (or the
		// end of the list)
		else
		{
			Node<generic> n = head;
			int i = 0;

			while(n != curr && n != null)
			{
				n = n.getLink();
				i++;
			}

			// return the value of the counter
			return i;
		}
	}

	// returns the value of the current element (or -1)
	public generic GetValue()
	{
		if (IsEmpty())
			return null;
		return curr.getData();
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
	public void InsertBefore(generic data)
	{
		if (!IsFull())
		{
			// If curr is at the head, then create the node with the
			// appropriate information, make that node point to
			// head/curr, and then update head and curr to the new
			// head. (and increase the number of items counter.
			if(curr == head)
			{
				Node<generic> n = new Node<generic>();
				n.setData(data);
				n.setLink(curr);
				head = curr = n;
				num_items++;
			}
			else
			{
				// Otherwise, just go to the previous position, and
				// insert the data after using the InsertAfter()
				// function.
				Prev();
				InsertAfter(data);
			}
		}
	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(generic data)
	{
		if (!IsFull())
		{
			// create a new node and put the appropriate information
			Node<generic> n = new Node<generic>();
			n.setData(data);

			// If the list is empty, set curr, tail and head to point to
			// the new node.
			if (IsEmpty())
			{
				head = curr = tail = n;
			}
			// if we are at the end of the list, then just append
			// the node to the list, and update both curr and tail
			else if(curr == tail)
			{
				curr.setLink(n);
				curr = tail = n;
			}
			// Otherwise make the new node point to the one after
			// curr, then change the link of curr to point to the
			// new node, and then update curr by moving it over to
			// n.
			else
			{
				n.setLink(curr.getLink());
				curr.setLink(n);
				Next();
			}
			// and then update the number of items in the list
			num_items++;

		}
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list
	public void Remove()
	{
		if (!IsEmpty())
		{
			// If curr is at the head, then just move both curr and
			// head over to the next node.
			if (curr == head)
			{
				head = curr = curr.getLink();
			}
			// If curr is at the tail, then just move curr behind by
			// one, update its link portion, and update tail.
			else if(curr == tail)
			{
				Prev();
				curr.setLink(null);
				tail = curr;
			}
			// Otherwise, move back by one position, and change the
			// link portion of the node to point to the node after
			// the next in the list. DO NOT forget to move curr back
			// to its former position.
			else
			{
				Prev();
				curr.setLink(curr.getLink().getLink());
				Next();
			}
			// and then update the number of items in the list.
			num_items--;
		}
	}

	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(generic data)
	{
		if (!IsEmpty())
			curr.setData(data);
	}

	// returns if the list is empty
	public boolean IsEmpty()
	{
		return (num_items == 0);
	}

	// returns if the list is full
	public boolean IsFull()
	{
		return (num_items == MAX_SIZE);
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List<generic> l)
	{
		// If the two lists are different sizes, return false
		// immediately.
		if (l.GetSize() != GetSize())
			return false;

		// If they aren't, create two new references that will cycle
		// through both lists without changing any information in
		// those lists.
		Node<generic> a = head;
		Node<generic> b = l.head;

		// Starting at position 0, compare the data between the
		// corresponding nodes of the lists, making sure to update
		// the references to both at the end of each iteration. If
		// there is any discrepancy in the information, return
		// false.
		for(int i = 0; i < GetSize(); i++, a = a.getLink(), b = b.getLink())
		{
			if (a.getData() != b.getData())
				return false;
		}

		// Otherwise, the lists are the same, and therefore you
		// should return true.
		return true;
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List<generic> Add(List<generic> l)
	{
		// create a new list that is a copy of this, and then create
		// a new node that will be used to cycle through List l
		// without changing anything in it e.g. curr.
		List<generic> newList = new List<generic>(this);
		Node<generic> n = l.head;

		// Move the curr in the new list to the end to get ready to
		// insert new elements
		newList.Last();

		// cycle through the elements in l until you either get to
		// MAX_SIZE or the end of the list, making sure to insert
		// the data being stored in every single node.
		for (int i = newList.GetSize(); i < MAX_SIZE && n != null; i++)
		{
			newList.InsertAfter(n.getData());
			n = n.getLink();
		}

		// And then return the new list you created
		return newList;
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{
		if (IsEmpty())
		return "NULL";

		// create an empty string to append the information to. Also
		// create a new node that will cycle through the information
		// without changing curr, head, or tail.
		String s = "";
		Node<generic> n = head;
		for(int i=0; i < num_items; i++)
		{
			s += n.getData() + " ";
			n = n.getLink();
		}

		// return the string you have created.
		return s;
	}
}
