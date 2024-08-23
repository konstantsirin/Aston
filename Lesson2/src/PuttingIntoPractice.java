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

        System.out.println("1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)");
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

        System.out.println("2. Вывести список неповторяющихся городов, в которых работают трейдеры.");
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        String resultAllTraders = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(resultAllTraders);
        System.out.println();

        System.out.println("5. Выяснить, существует ли хоть один трейдер из Милана.");
        boolean hasPersonFromMilan = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .anyMatch(c -> c.equals("Milan"));
        System.out.println(hasPersonFromMilan ? "Да" : "Нет");
        System.out.println();

        System.out.println("6. Вывести суммы всех транзакций трейдеров из Кембриджа.");
        int sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println(sum);
        System.out.println();

        System.out.println("7. Какова максимальная сумма среди всех транзакций?");
        Integer max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
        System.out.println(max);

        // без сохранения в переменную
        transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println("8. Найти транзакцию с минимальной суммой.");
        Integer min = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .getAsInt();
        System.out.println(min);

        // без сохранения в переменную
        transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .ifPresent(System.out::println);

        System.out.println();
    }
}
