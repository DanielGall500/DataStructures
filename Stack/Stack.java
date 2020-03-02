import java.util.ArrayList;

class Stack<E>
{
    ArrayList<E> stackArr = new ArrayList<E>();

    //Last In First Out
    Stack()
    {
	
    }

    public void push(E element)
    {
	//Add Element to Start
	stackArr.add(0, element);
    }

    public E pop()
    {
	//Get Popped Element
	E popped = stackArr.get(0);

	//Pop From Stack
	stackArr.remove(0);

	//Return Popped Element
	return popped;
    }

    public void print()
    {
	System.out.println("--Printing Stack--");
	
	for(E element : stackArr)
	{
	    System.out.println(element);
        }

	System.out.println();
    }
    
    public static void main(String[] args)
    {
	Stack<Integer> stk = new Stack<Integer>();

	stk.push(1);
	stk.push(2);
	stk.push(3);

	stk.print();

	stk.pop();

	stk.print();
    }
}
