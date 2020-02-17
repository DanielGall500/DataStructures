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

        //NEW NODE =CONNECTS TO=> HEAD
        newNode.setNext(head);

        //Update head
        head = newNode;

        //Increment size
        size++;
    }

    void addLast(E e)
    {
        if(this.isEmpty()) {
            head = new Node<E>(e, null);
            System.out.print('x');
        }
        else if(tail == null) {
            tail = new Node<E>(e, null);
            System.out.print('y');
        }
        else {
            Node newNode = new Node<E>(e, null);
            tail.setNext(newNode);
            tail = newNode;
            System.out.print('z');
        }

        //Increment size
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
        curr = head;

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

    public void print()
    {
        curr = head;

        for(int i = 0; i < this.size; i++)
        {
            if(curr.getElement() != null)
                 System.out.print(curr.getElement());

            if(curr.getNext() != null)
                System.out.print(" => ");
                curr = curr.getNext();
        }
    }

    public static void main(String[] args)
    {
        SingularlyLinkedList<Integer> x = new SingularlyLinkedList<>();

        x.addFirst(1);
        x.print();

        x.addLast(2);
        x.print();

    }


}
