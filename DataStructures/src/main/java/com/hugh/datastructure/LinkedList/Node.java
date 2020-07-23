package com.hugh.datastructure.LinkedList;

/**
 * @program: draft
 * @description: 单链表中节点（Node）
 * @author: Fly.Hugh
 * @create: 2020-07-22 22:55
 **/
public class Node<E> {
    /**
     * 数据域
     */
    private E elem;

    /**
     * 指针域
     */
    private Node<E> next;

    /**
     * 构造方法
     */
    public Node(E element, Node<E> next) {
        this.elem = element;
        this.next = next;
    }

    /**
     * 无参构造方法
     */
    public Node() {
        this(null, null);
    }

    /** Setter & Getter */
    public void setElem(E element) {
        this.elem = element;
    }

    public E getElem() {
        return this.elem;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return this.next;
    }
}
