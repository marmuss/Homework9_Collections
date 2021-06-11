package com.tms.homework9.MyArrayList;
/**
 * Интерфейс класса MyArrayList
 */
public interface IMyArrayList<E> extends Iterable<E> {
    void add(E e);
    void delete(int index);
    E get(int index);
    int size();
    boolean check(E e);
    void clear();
}
