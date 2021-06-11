package com.tms.homework9.MyArrayList;

import java.util.Iterator;

/**
 * Итератор для класса MyArrayList
 */
public class MyIterator<E> implements Iterator {
    private int index = 0;
    E[] values;

    public MyIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public Object next() {
        return values[index++];
    }
}
