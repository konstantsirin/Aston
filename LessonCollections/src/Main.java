import Collections.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Слово1");
        myArrayList.add("Слово2");
        myArrayList.add("Слово3");
        System.out.println(myArrayList);
        myArrayList.get(3);
        System.out.println(myArrayList.get(1));
        myArrayList.remove(0);
        System.out.println(myArrayList);
        ArrayList<String> arrayList = new ArrayList<>(List.of("Слово из другой коллекции 1",
                "Слово из другой коллекции 2",
                "Слово из другой коллекции 3"));
        myArrayList.addAll(arrayList);
        System.out.println(myArrayList);

        MyArrayList<Integer> newMyArrayList = new MyArrayList(List.of(5, 7, 9, 10, 2, 3));
        System.out.println(newMyArrayList);
        ArrayList<Integer> forSortedList = new ArrayList<>(List.of(5, 7, 9, 10, 2, 3));
        Object[] sortedList = MyArrayList.bubbleSort(forSortedList);
        Arrays.stream(sortedList).forEach(i -> System.out.print(i + " "));
    }
}
