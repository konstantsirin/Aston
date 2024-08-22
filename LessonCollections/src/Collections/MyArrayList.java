package Collections;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<T> {
    private final int DEFAULT_SIZE = 10;
    private Object[] elements;
    private int size = 0;

    public MyArrayList() {
        elements = new Object[DEFAULT_SIZE];
    }

    public MyArrayList(Collection<? extends T> collection) {
        elements = new Object[collection.size()];
        for (T element : collection) {
            this.add(element);
        }

    }

    public void add(T item) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Запрашиваемого элемента не существует");
            return null;
        }
        return (T) elements[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Запрашиваемого элемента не существует");
            return;
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public void addAll(Collection<? extends T> collection) {
        if (collection.size() > 0) {
            for (T element : collection) {
                this.add(element);
            }
        }
    }

    public static <T extends Comparable<T>> Object[] bubbleSort(Collection<T> collection) {
        Object[] array = collection.toArray();
        boolean filteredCompleted;
        do {
            filteredCompleted = true;
            for (int i = 1; i < array.length; i++) {
                if (((T) array[i - 1]).compareTo((T) array[i]) > 0) {
                    Object temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    filteredCompleted = false;
                }
            }
        } while (!filteredCompleted);
        return array;
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
