package com.iglaz.astonbase.lesson5.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1. ����� ��� ���������� �� 2011 ��� � ������������� �� �� ����� (�� ������� � �������)");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(new Comparator<Transaction>() {
                    @Override
                    public int compare(Transaction o1, Transaction o2) {
                        return o1.getValue() - o2.getValue();
                    }
                })
                .forEach(System.out::println);
        System.out.println();

        System.out.println("2. ������� ������ ��������������� �������, � ������� �������� ��������.");
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("3. ����� ���� ��������� �� ��������� � ������������� �� �� ������.");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("4. ������� ������ �� ����� ������� ���������, ���������������� � ���������� �������.");
        String resultAllTraders = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(resultAllTraders);
        System.out.println();

        System.out.println("5. ��������, ���������� �� ���� ���� ������� �� ������.");
        boolean hasPersonFromMilan = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .anyMatch(c -> c.equals("Milan"));
        System.out.println(hasPersonFromMilan ? "��" : "���");
        System.out.println();

        System.out.println("6. ������� ����� ���� ���������� ��������� �� ���������.");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("7. ������ ������������ ����� ����� ���� ����������?");
        Integer max = transactions.stream()
                .mapToInt(t -> t.getValue())
                .max()
                .getAsInt();
        System.out.println(max);
        System.out.println();

        System.out.println("8. ����� ���������� � ����������� ������.");
        Integer min = transactions.stream()
                .mapToInt(t -> t.getValue())
                .min()
                .getAsInt();
        System.out.println(min);
        System.out.println();
    }
}
