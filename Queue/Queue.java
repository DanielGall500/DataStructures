import java.util.ArrayList;

class Queue<E>
{
    ArrayList<E> queueArr;
    
    Queue()
    {
	queueArr = new ArrayList<E>();
    }

    public void offer(E element)
    {
	queueArr.add(element);
    }

    public E poll()
    {
	if(this.size() == 0)
	    throw new RuntimeException("Queue Empty");
	
	E polled = queueArr.get(0);

	queueArr.remove(0);
	
	return polled;
    }

    public void print()
    {
	System.out.println("--Printing Queue--");

	for(E element : queueArr)
	    {
		System.out.println(element);
	    }

	System.out.println();
    }

    public int size()
    {
	return queueArr.size();
    }
}
