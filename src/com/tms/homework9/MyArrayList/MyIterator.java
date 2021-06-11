package com.tms.homework9.MyArrayList;

import java.util.Iterator;
/**
 * Итератор для класса MyArrayList
 */
public class MyIterator<E> implements Iterator {
    private int index = 0;
    E[] array;

    public MyIterator(E[] values) {
        this.array = values;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public Object next() {
        return array[index++];
    }
}
