package com.khaimoev;

import com.khaimoev.array_list.MyArrayList;
import com.khaimoev.interfaces.ListInterface;
import com.khaimoev.linked_list.MyLinkedList;
import com.khaimoev.test_models.TestSort;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /***
         * test MyArrayList
         */
        //Create MyArrayList
        System.out.println("Create MyArrayList");
        MyArrayList<String> stringMyArrayList1 = new MyArrayList<String>(10);
        for (int i = 0; i < 10; i++) {
            stringMyArrayList1.add("String " + i);
        }
        printSizeCollection(stringMyArrayList1);
        System.out.println(stringMyArrayList1);

        //Get element for index
        System.out.println("Get element MyArrayList");
        System.out.println("Element for index 5: \"" + stringMyArrayList1.get(5) + "\"");

        System.out.println("Get element with max index MyArrayList");
        System.out.println("Element for index " + (stringMyArrayList1.size() - 1) + ": \"" + stringMyArrayList1.get(stringMyArrayList1.size() - 1) + "\"");

        //test Reaching the limits of the array
        try {
            stringMyArrayList1.get(50);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //Remove element MyArrayList
        System.out.println("Remove 3 elements MyArrayList");
        stringMyArrayList1.remove(0);
        stringMyArrayList1.remove(5);
        stringMyArrayList1.remove(7);

        printSizeCollection(stringMyArrayList1);
        System.out.println(stringMyArrayList1);

        //test Reaching the limits of the array
        try {
            stringMyArrayList1.remove(50);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //Add collection MyArrayList
        System.out.println("Add collection MyArrayList");
        ArrayList<String> testArray = new ArrayList<String>();
        for (int i = 0; i <= 10; i++) {
            testArray.add("Строка " + i);
        }
        stringMyArrayList1.addAll(testArray);
        printSizeCollection(stringMyArrayList1);
        System.out.println(stringMyArrayList1);

        //Create new MyArrayList from Collection
        System.out.println("Create new MyArrayList from Collection");
        ArrayList<String> listTest = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listTest.add("Тест " + i);
        }
        MyArrayList<String> stringMyArrayList = new MyArrayList<String>(listTest);
        printSizeCollection(stringMyArrayList);
        System.out.println(stringMyArrayList);

        /***
         * test MyLinkedList
         */
        //Create MyLinkedList
        System.out.println("Create MyLinkedList");
        MyLinkedList<String> stringMyLinkedList1 = new MyLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            stringMyLinkedList1.add("String " + i);
        }
        printSizeCollection(stringMyLinkedList1);
        System.out.println(stringMyLinkedList1);

        //Get element for index
        System.out.println("Get element MyLinkedList");
        System.out.println("Element for index 5: \"" + stringMyLinkedList1.get(5) + "\"");

        System.out.println("Get element with max index MyLinkedList");
        System.out.println("Element for index " + (stringMyLinkedList1.size() - 1) + ": \"" + stringMyLinkedList1.get(stringMyLinkedList1.size() - 1) + "\"");

        //test Reaching the limits of the list
        try {
            stringMyLinkedList1.get(50);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //Remove element MyLinkedList
        System.out.println("Remove 3 elements MyLinkedList");
        stringMyLinkedList1.remove(0);
        stringMyLinkedList1.remove(5);
        stringMyLinkedList1.remove(7);

        printSizeCollection(stringMyLinkedList1);
        System.out.println(stringMyLinkedList1);

        //test Reaching the limits of the linked list
        try {
            stringMyLinkedList1.remove(50);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //Add collection MyLinkedList
        System.out.println("Add collection MyLinkedList");
        ArrayList<String> testCollection = new ArrayList<String>();
        for (int i = 0; i <= 10; i++) {
            testCollection.add("Test string " + i);
        }
        stringMyLinkedList1.addAll(testCollection);
        printSizeCollection(stringMyLinkedList1);
        System.out.println(stringMyLinkedList1);

        //Create new MyLinkedList from Collection
        System.out.println("Create new MyLinkedList from Collection");
        ArrayList<String> listCollectionTest = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listTest.add("Тест " + i);
        }
        MyLinkedList<String> stringLinkedListListCollect1 = new MyLinkedList<String>(listCollectionTest);
        printSizeCollection(stringLinkedListListCollect1);
        System.out.println(stringLinkedListListCollect1);

        /***
         * test bubble sort
         */
        ArrayList<String> testSort = new ArrayList<String>();
        ArrayList<Integer> testSort2 = new ArrayList<Integer>();
        Random ran = new Random();
        for (int i = 0; i <= 10; i++) {
            int x = ran.nextInt(1000);
            testSort.add(x + "Test string");

            testSort2.add(x);
        }

        MyArrayList.bubbleSort(testSort);
        System.out.println(testSort);

        MyArrayList.bubbleSort(testSort2);
        System.out.println(testSort2);

        ArrayList<TestSort> testSort3 = new ArrayList<TestSort>();
        for (int i = 0; i <= 29; i++) {
            int x = ran.nextInt(50000);
            var str = ("Test - " + x);

            testSort3.add(new TestSort(x, str));
        }

        MyArrayList.bubbleSort(testSort3);
        System.out.println(testSort3);
    }

    static void printSizeCollection(ListInterface collection) {
        System.out.println("Size " + collection.getClass().getSimpleName() + ": " + collection.size());
    }
}