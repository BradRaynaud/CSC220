/* ***************************************************
* <Brad Raynaud>
* <10/19/2017>
* <Stack.java>
*
* Generic Stack class for the Assignment#6 on Moodle
*************************************************** */
class Stack<generic>
{
        private List<generic> l;

        // Constructor for the Stack Class
        public Stack()
        {
            l = new List<generic>();
        }

        // Copy Constructor for the Stack class
        public Stack(Stack<generic> s)
        {
            l = new List<generic>(s.l);

        }

        // Adds a Node to the top of the Stack
        public void Push(generic data)
        {
            this.l.First();
            this.l.InsertBefore(data);
        }

        // Removes a Node from the top of the Stack
        public generic Pop()
        {
            this.l.First();
            generic data = this.l.GetValue();
            this.l.Remove();
            return data;
        }

        // returns the value of the top Node in the Stack
        public generic Peek()
        {
            this.l.First();
            return this.l.GetValue();
        }

        // returns the size of the Stack
        public int Size()
        {
            return this.l.GetSize();
        }

        // Returns True if Stack is Empty else returns False
        public boolean IsEmpty()
        {
            return this.l.IsEmpty();
        }

        // Returns Trus if Stack is Full else returns False
        public boolean IsFull()
        {
            return this.l.IsFull();
        }

        // Returns True if Stack is equal to the Stack provided in the argument
        public boolean Equals(Stack<generic> s)
        {
            return this.l.Equals(s.l);
        }

        // concatenates two Stacks
        public Stack<generic> Add(Stack<generic> s)
        {
            Stack<generic> temp = new Stack<generic>();
            temp.l = this.l.Add(s.l);
            return temp;
        }

        // String function for the Stack Class
        public String toString()
        {
            return this.l.toString();
        }
}
