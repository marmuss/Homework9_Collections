package com.tms.homework9.MyArrayList;

import java.util.Arrays;
import java.util.Iterator;
/**
 * Класс MyArrayList симулирует работу коллекции ArrayList
 * Содержит конструктор без параметров, который создает массив с вместимостью 10 по умолчанию
 * и конструктор с параметром - размер массива можно задать
 * Метод add() - добавляет новый элемент
 * Метод delete() - удаляет элемент по его индексу
 * Метод get() - возвращвет элемент по его индексу
 * Метод size() - возвращает размер массива
 * Метод check() - проверяет, есть ли заданный элемент в коллекции
 * Метод clear() - очищает коллекцию
 * Метод resize() - увеличивает вместимость коллекции
 */
public class MyArrayList<E> implements IMyArrayList<E> {

    private Object[] array;
    private int size = 0;

    public MyArrayList() {
        this.array = new Object[10];
    }

    public MyArrayList(int capacity) {
        if (capacity >= 0) {
            this.array = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+ capacity);
        }
    }

    @Override
    public void add(E e) {
        if (size == array.length){
            resize(array.length * 2);
        }
        array[size++] = e;
    }

    @Override
    public void delete(int index) {
        try {
            Object[] tmp = array;
            array = new Object[tmp.length - 1];
            System.arraycopy(tmp, 0, array, 0, index);
            System.arraycopy(tmp, index + 1, array, index, tmp.length - index - 1);
            size--;
        } catch (ClassCastException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
         if ((index < size) && (index >= 0)){
             return (E) array[index];
         } else {
             String string = "Элемента с таким индексом нет";
             return (E) string;
         }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean check(Object e) {
        for(Object item : array){
            if (item.equals(e)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(array);
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public String toString() {
        String outStr = "";
        if (array.length != 0) {
            for (int i = 0; i < size; i++) {
                outStr += String.valueOf(get(i)) + " ";
            }
            return outStr;
        } else {
            return Arrays.toString(array);
        }
    }
}
