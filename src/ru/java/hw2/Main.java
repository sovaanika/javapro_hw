package ru.java.hw2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6));
        list = Test.noDuplicates(list);
        System.out.println("Список чисел без дубликатов: " + list);
        List<String> str = new ArrayList<>(Arrays.asList("ab", "bc", "ab", "cat", "bird", "AvadaKedavra", "deploy"));
        str = Test.noDuplicates(str);
        System.out.println("Список слов без дубликатов: " + str);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6));
        System.out.println("3-е наибольшее число: " + Test.thirdBigger(list1));
        System.out.println("3-е наибольшее «уникальное» число: " + Test.thirdUniqueBigger(list1));

        List<Employee> employees = List.of(
                new Employee("John", 29, "Engineer"),
                new Employee("Bob", 35, "Manager"),
                new Employee("Ben", 43, "Engineer"),
                new Employee("Stasy", 19, "Engineer"),
                new Employee("Kurt", 27, "Engineer"),
                new Employee("Andrew", 32, "Designer"),
                new Employee("Alex", 21, "Designer")
        );
        List<String> names = Test.threeOldEngineers(employees);
        System.out.println("Список имен 3 самых старших сотрудников с должностью «Инженер»: " + names);
        System.out.println("Средний возраст сотрудников с должностью «Инженер»: " + Test.averageEngineerAge(employees));
        System.out.println("Самое длинное слово в списке слов: " + Test.longestWord(str));
        String str2 = "ab ab aa ac ba bu ba b b a e f bv f s w q a s bv";
        Map<String, Integer> map = Test.stringToMap(str2);
        System.out.println("Пары: слово - количество: " + map);
        List<String> str3 = new ArrayList<>(Arrays.asList("ab", "bc", "ab", "cat", "bird", "AvadaKedavra", "deploy"));
        Test.sortStrings(str3);
        String[] strings = {"cat dog pet mouse hamster", "bird parrot pigeon sparrow flamingo", "docker helm pod deploy code"};
        System.out.println("Самое длинное слово в массиве строк: " + Test.anyLongestWord(strings));
    }
}