package LinkedList;

/**
 * @program: draft
 * @description: 双向链表节点
 * @author: Fly.Hugh
 * @create: 2020-07-24 01:49
 **/
public class DLNode<E> {
    private E element;
    private DLNode<E> prev;
    private DLNode<E> next;

    public DLNode(E element, DLNode prev, DLNode next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public DLNode() {
        this(null, null, null);
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DLNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DLNode<E> prev) {
        this.prev = prev;
    }

    public DLNode<E> getNext() {
        return next;
    }

    public void setNext(DLNode<E> next) {
        this.next = next;
    }
}
