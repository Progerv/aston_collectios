package com.khaimoev.interfaces;

import java.util.Collection;

public interface ListInterface<E> {
    int size();
    Boolean isEmpty();
    void add(E e);
    E get(int index);
    void remove(int index);
    void addAll(Collection<? extends E> collection);
}