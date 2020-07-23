package LinkedList;

/**
 * @program: draft
 * @description: 自己完整实现
 * @author: Fly.Hugh
 * @create: 2020-07-24 01:31
 **/
public class Node<E> {
    /**
     * 数据域
     */
    private E element;

    /**
     * 指针域
     */
    private Node<E> next;

    /**
     * 构造方法
     */
    public Node(E element, Node<E> next){
        this.element = element;
        this.next = next;
    }

    /**
     * 无参构造方法
     */
    public Node() {
        this(null, null);
    }

    /** getter & setter */
    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
