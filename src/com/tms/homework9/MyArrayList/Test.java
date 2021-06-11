package com.tms.homework9.MyArrayList;
/**
 * тест
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList<String> myStringArray = new MyArrayList<>();

        System.out.println("Добавляем элементы в коллекцию");
        myStringArray.add("One");
        myStringArray.add("Two");
        myStringArray.add("Three");
        myStringArray.add("Four");
        myStringArray.add("Five");
        System.out.println(myStringArray.toString());
        System.out.println();

        System.out.println("Размер массива: " + myStringArray.size());
        System.out.println();

        System.out.println("Выбирем элемент с индексом 3");
        System.out.println(myStringArray.get(3));
        System.out.println();

        System.out.println("Удаляем его");
        myStringArray.delete(3);
        System.out.println(myStringArray.toString());
        System.out.println();

        System.out.println("Проверяем, есть ли элемент Two в коллекции");
        if (myStringArray.check("Two")){
            System.out.println("Такой элемент в коллекции есть");
        } else {
            System.out.println("Такого элемента в коллекции нет");
        }
        System.out.println();

        System.out.println("Очищаем коллекцию");
        myStringArray.clear();
        System.out.println(myStringArray.toString());
    }
}
