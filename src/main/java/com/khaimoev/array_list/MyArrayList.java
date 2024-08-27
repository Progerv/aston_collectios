package com.khaimoev.array_list;

import com.khaimoev.interfaces.ListInterface;

import java.util.Collection;
import java.util.Objects;

public class MyArrayList<E> implements ListInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] list;

    public MyArrayList() {
        initList(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initSize) {
        if (initSize < 0) {
            throw new RuntimeException(new IllegalArgumentException("Illegal size array: " + initSize));
        }
        initList(initSize);
    }

    public MyArrayList(Collection<? extends E> collection) {
        var newCapacity = getNewCapacity(collection.size());
        this.size = newCapacity;
        initList(newCapacity);
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
    public void add(E o) {
        if (this.size >= this.list.length) {
            growArray();
        }
        this.list[size] = o;
        this.size++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, this.size);
        return (E) this.list[index];
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, this.size);
        int numMoved = this.size - index - 1;
        System.arraycopy(this.list, index + 1, this.list, index, numMoved);
        this.list[--this.size] = null;
    }

    @Override
    public void addAll(Collection<? extends E> collection) {
        addCollection(collection);
    }

    @Override
    public String toString() {
        var stringBuilder = new StringBuilder();
        stringBuilder.append("My array: ");
        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(this.list[i]);
            if (i != this.size - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    private void initList(int initSize) {
        this.list = new Object[initSize];
    }

    int getNewCapacity(int currentSize) {
        return (currentSize * 3) / 2 + 1;
    }

    private void growArray() {
        var newCapacity = getNewCapacity(this.size);
        Object[] listNewList = new Object[newCapacity];
        System.arraycopy(this.list, 0, listNewList, 0, this.size);
        this.list = listNewList;
    }

    private void addCollection(Collection<? extends E> collection) {
        for (E item : collection) {
            this.add(item);
        }
    }

    public static <T extends Comparable> void bubbleSort(Collection<T> collection) {
        var flagSorted = true;
        Object[] arrayForSort = collection.toArray();
        while (flagSorted) {
            flagSorted = false;
            for (int i = 0; i < arrayForSort.length - 1; i++) {
                if (((T) arrayForSort[i]).compareTo(arrayForSort[i + 1]) > 0) {
                    var temp = arrayForSort[i];
                    arrayForSort[i] = arrayForSort[i + 1];
                    arrayForSort[i + 1] = temp;
                    flagSorted = true;
                }
            }
        }
        collection.clear();
        for (int j = 0; j < arrayForSort.length; j++) {
            collection.add((T) arrayForSort[j]);
        }
    }
}