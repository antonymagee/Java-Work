
public class LinkedQueue<T> implements QueueADT<T>
{

    private static class LinkedQueue<T> {


    private int count;
    private LinearNode<T>front, rear;

    public LinkedQueue()			// creates an empty Queue
    {
        count = 0;
        front = rear = null;
    }

    public void enqueue(T element)	// Adds element to the end of the Queue
    {
        LinearNode<T> node = new LinkedQueue<T>(element);

        if(isEmpty())
            front = node;
        else
            rear.setNext (node);

        rear = node;
        count++;
    }

    public T dequeue() throws EmptyCollectionException
    {
    	if (isEmpty())
    		throw EmptyCollectionException ("queue");		// dequeues elements from the front of the queue

    	T result = front.getElement();						// Assigns the value of front to T, and reduces count by 1
    	front = front.getNext();
    	count--;

    	if (isEmpty())										// isEmpty if, to display if no queue exists
    		rear = null;

    	return result;
    }

    public int size()
    {
    	return count;										// Returns the current count for queue size
    }

    public boolean isEmpty()
    {
    	return (count == 0);								// returning if count is 0
    }

    public T first() throws QueueEmptyException
    {
    	if (front == null)									// If front is null throws exception
    	{
     	 throw new QueueEmptyException();					// otherwise returns front value
    	} 	else
    	{
      	return front.getElement;
    	}
	}

	public String toString()
	{
		return "Current element is" + first();
	}
 }

}


public class LinearNode<T>
{
   private LinearNode<T> next;
   private T element;

   //-----------------------------------------------------------------
   //  Creates an empty node.
   //-----------------------------------------------------------------
   public LinearNode()
   {
      next = null;
      element = null;
   }

   //-----------------------------------------------------------------
   //  Creates a node storing the specified element.
   //-----------------------------------------------------------------
   public LinearNode (T elem)
   {
      next = null;
      element = elem;
   }

   //-----------------------------------------------------------------
   //  Returns the node that follows this one.
   //-----------------------------------------------------------------
   public LinearNode<T> getNext()
   {
      return next;
   }

   //-----------------------------------------------------------------
   //  Sets the node that follows this one.
   //-----------------------------------------------------------------
   public void setNext (LinearNode<T> node)
   {
      next = node;
   }

   //-----------------------------------------------------------------
   //  Returns the element stored in this node.
   //-----------------------------------------------------------------
   public T getElement()
   {
      return element;
   }

   //-----------------------------------------------------------------
   //  Sets the element stored in this node.
   //-----------------------------------------------------------------
   public void setElement (T elem)
   {
      element = elem;
   }
}
