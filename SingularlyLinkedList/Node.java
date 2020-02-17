package LL;

public class Node<E> {

    private E element;
    private Node<E> next;

    public Node(E e, Node<E> n)
    {
        this.element = e;
        this.next = n;
    }

    //Retrieve data stored in node
    public E getElement() { return this.element; }

    //Retrieve the next node
    public Node<E> getNext() { return this.next; }

    //Set the next node
    public void setNext(Node<E> n) { this.next = n; }



}
