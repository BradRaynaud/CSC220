/* ***************************************************
 * <Brad Raynaud>
 * <9/29/2017>
 * <List.java>
 *
 * Java class adapted from the work done in class to fufill the requirements of
 * assignment three due 9/29/2017. All testing was done in Win10 terminal and
 * when the output was compared with "ListTest.out" using the "FC" command, no
 * differences were found.
 *************************************************** */

/*******************************************************************************
*  Change list(Changes from the version that works with char)
*  All references where a char was call was replaced with references to integers
*  GetValue function modified to fix problem with output line 1 returning 32
*******************************************************************************/
// the EasyList class
class List
{
	public static final int MAX_SIZE = 50; // replaced "char" with "int"

	private int end;	// the index of the last valid item in the list
	private int curr;	// the index of the current item in the list
	private int[] list;	// the list

	// constructor
	// remember that an empty list has a "size" of -1 and its "position" is at -1
	public List()
	{
		this.end = -1;
		this.curr = -1;
		this.list = new int[MAX_SIZE];
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l)
	{
		this.end = -1;
		this.curr = -1;
		this.list = new int[MAX_SIZE];

		for (int i=0; i<l.GetSize(); i++)
			this.InsertAfter(l.list[i]);
	}

	// navigates to the beginning of the list
	public void First()
	{
		if (!IsEmpty())
			curr = 0;
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last()
	{
		curr = end;
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
		if (!IsEmpty() && pos >= 0 && pos < GetSize())
			curr = pos;
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev()
	{
		if (!IsEmpty() && GetPos() > 0)
			curr--;
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if (curr != end)
			curr++;
	}

	// returns the location of the current element (or -1)
	public int GetPos()
	{
		return curr;
	}

	// returns the value of the current element (or -1)
	public int GetValue()
	{
		if (IsEmpty())
			return -1; // returns -1 if array is empty
		else
			return list[curr];
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize()
	{
		return end + 1;
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(int data) // replaced "char" with "int"
	{
		if (!IsFull())
		{
			if (IsEmpty())
				InsertAfter(data);
			else if (curr > 0)
			{
				curr--;
				InsertAfter(data);
			}
			else
			{
				for (int i=end; i>=curr; i--)
					list[i+1] = list[i];
				list[curr] = data;
				end++;
			}
		}
	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(int data) // replaced "char" with "int"
	{
		if (!IsFull())
		{
			if (curr != end)
			{
				for (int i=end; i>curr; i--)
					list[i+1] = list[i];
			}

			curr++;
			end++;
			list[curr] = data;
		}
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list
	public void Remove()
	{
		if (!IsEmpty())
		{
			if (this.GetPos() == this.GetSize() - 1)
				curr--;
			else
			{
				for (int i=curr; i<end; i++)
					list[i] = list[i+1];
			}

			end--;
		}
	}

	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data) // replaced "char" with "int"
	{
		if (!IsEmpty())
			list[curr] = data;
	}

	// returns if the list is empty
	public boolean IsEmpty()
	{
		if (end == -1)
			return true;
		return false;
	}

	// returns if the list is full
	public boolean IsFull()
	{
		return (end >= MAX_SIZE - 1);
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List l)
	{
		if (this.GetSize() != l.GetSize())
			return false;

		for (int i=0; i<GetSize(); i++)
			if (this.list[i] != l.list[i])
				return false;
		return true;
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
		List m = new List(this);

		for (int i=0; i<l.GetSize(); i++)
			m.InsertAfter(l.list[i]);

		return m;
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{
		if (IsEmpty())
			return "NULL";
		else
		{
			String s = "";

			for (int i=0; i<=end; i++)
				s += list[i] + " ";

			return s;
		}
	}
}
