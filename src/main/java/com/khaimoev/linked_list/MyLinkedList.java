package com.khaimoev.linked_list;

import com.khaimoev.interfaces.ListInterface;

import java.util.Collection;
import java.util.Objects;

public class MyLinkedList<E> implements ListInterface<E> {
    private int size = 0;

    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {}
    public MyLinkedList(Collection<? extends E> collection) {
        addCollection(collection);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Boolean isEmpty() {
        return this.size > 0;
    }

    @Override
    public void add(E e) {
        Node<E> item;
        if (first == null) {
            item = new Node<E>(null, e, null);
            first = item;
        } else {
            item = new Node<E>(last, e, null);
            last.next = item;
        }
        last = item;
        size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, this.size);
        Node<E> itemFind = findNodeForIndex(index);
        return itemFind.item;
    }

    Node<E> findNodeForIndex(int index) {
        Node<E> item = first;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item;
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, this.size);
        Node<E> itemFind = findNodeForIndex(index);
        removeNode(itemFind);
    }

    @Override
    public void addAll(Collection<? extends E> collection) {
        addCollection(collection);
    }

    private void addCollection(Collection<? extends E> collection) {
        for (E item : collection) {
            this.add(item);
        }
    }

    private void removeNode(Node<E> item) {
        final Node<E> next = item.next;
        final Node<E> prev = item.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            item.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            item.next = null;
        }

        item.item = null;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("My linked list: ");
        if (first == null) {
            sb.append("Empty");
        } else {
            Node<E> nextItem = this.first;
            do {
                sb.append(nextItem.item);
                if (nextItem.next == null) {
                    sb.append(".");
                } else {
                    sb.append(", ");
                }
                nextItem = nextItem.next;
            } while (nextItem != null);
        }

        return sb.toString();
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}