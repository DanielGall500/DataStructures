package LL;
import java.util.Iterator;

interface List<E>
{
    int size();
    boolean isEmpty();

    void add(int i, E e);
    void remove(int i);

    E get(int i);

    void set(int i, E e);
}


public class SingularlyLinkedList<E> implements List<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private Node<E> curr;

    private int size = 0;

    SingularlyLinkedList() {
    }

    private class ListIterator implements Iterator<E>
    {
        Node curr;

        public ListIterator()
        {
            curr = head;
        }

        public boolean hasNext()
        {
            return curr != null;
        }

        @Override
        public E next()
        {
            E res = (E) curr.getElement();
            curr = curr.getNext();
            return res;
        }
    }

    void addFirst(E e)
    {
        //Create a new node for our element
        //Set head as next element
        Node newNode = new Node<E>(e, head);

        Node oldHead = head;

        //NEW NODE =CONNECTS TO=> HEAD
        newNode.setNext(oldHead);

        //Update head
        head = newNode;

        //If there was no tail before, add one
        if(tail == null && this.size == 1)
        {
            tail = oldHead;
        }

        //Increment size
        size++;
    }

    void addLast(E e)
    {
        //Create a new node for our element
        //Set head as next element
        Node newNode = new Node<E>(e, head);

        if(tail == null) {
            tail = newNode;
            return;
        }

        Node tmpNode = tail;

        tail.setNext(newNode);

        tail = newNode;

        size++;
    }

    void removeFirst()
    {
        //Check if list is empty
        if(this.isEmpty())
            throw new RuntimeException ("Linked List Is Empty");

        //Set head
        head = head.getNext();

        //Remove one element from size
        size--;
    }

    void removeLast() {

        //Check if list is empty
        if (this.isEmpty())
            throw new RuntimeException ("Linked List Is Empty");

        curr = head;

        //Find our SECOND LAST element
        for (int i = 0; i < this.size - 1; i++) {
            curr = curr.getNext();
        }

        //Set our new tail
        tail = curr;
        tail.setNext(null);
    }

    public void add(int indx, E e)
    {
        //DOUBLE CHECK WHAT ADD ACTUALLY DOES

        if (indx == 0)
            init_head(e);
        else
        {
            //Create new node for element e
            Node newNode = new Node<E>(e, null);

            //Node to store the node previous
            //to the current one
            Node prev = new Node<E>(null, null);

            curr = head;

            for(int i = 0; i < indx; i++)
            {
                prev = curr;
                curr = curr.getNext();
            }

            //PREVIOUS NODE -> NEW NODE
            prev.setNext(newNode);

            //NEW NODE -> CURRENT NODE
            newNode.setNext(curr);

            //Increment Size
            size++;
        }

    }

    private void init_head(E e)
    {
        if(size != 0)
            throw new RuntimeException("Cannot Initialise");

        Node tmpNode = new Node<E>(e, tail);
        head = tmpNode;

        size++;
    }

    private void init_tail(E e)
    {
        if(size != 1)
            throw new RuntimeException("Cannot Initialise");

        Node tmpNode = new Node<E>(e, null);
        tail = tmpNode;

        head.setNext(tail);

        size++;
    }

    public void remove(int indx)
    {
        Node prev = new Node<E>(null, null);

        curr = head;

        //Find element at the index position
        for(int i = 0; i < indx; i++)
        {
            prev = curr;
            curr = curr.getNext();
        }

        //PRE-INDX ELEMENT =CONNECTED TO=> POST-INDX ELEMENT
        prev.setNext(curr.getNext());
    }

    public boolean contains(Object e)
    {

        if(this.isEmpty())
            throw new RuntimeException ("Linked List Is Empty");

        curr = head;

        for(int i = 0; i < size; i++)
        {
            if(curr.getElement() == e)
                return true;

            curr = curr.getNext();
        }

        return false;
    }

    public E get(int indx)
    {
        if(indx > (size - 1))
            throw new IllegalArgumentException("Invalid Index");

        curr = head;

        System.out.println();

        //Search for element
        for(int i = 0; i < indx; i++)
        {
            curr = curr.getNext();
        }

        return curr.getElement();
    }

    public void set(int indx, E e)
    {
        if(indx > (this.size - 1) )
            throw new RuntimeException("Linked List Is Empty");

        Node prev, newNode;

        curr = head;
        prev = new Node<E>(null, null);

        for(int i = 0; i < indx; i++)
        {
            curr = curr.getNext();
            prev = curr;
        }

        newNode = new Node<E>(e, curr.getNext());

        //PRE-INDX =CONNECTS TO=> NEW NODE
        prev.setNext(newNode);

        //CURRENT INDX = NEW NODE
        curr = newNode;

    }

    public boolean isEmpty() { return size == 0; }

    public E last() { return tail.getElement(); }

    public int size() { return this.size; }

    public static void main(String[] args)
    {
        SingularlyLinkedList<Integer> x = new SingularlyLinkedList<>();

        x.add(0, 10);
        System.out.println(x.get(0));

        x.add(1, 12);


    }


}
