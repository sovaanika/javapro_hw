package ru.java.hw2;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    //удаление из листа всех дубликатов
    public static <T> List<T> noDuplicates(List<T> list) {
        return list.stream()
                .distinct()
                .toList();
    }

    //3-е наибольшее число
    public static int thirdBigger(List<Integer> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(0);
    }

    //3-е наибольшее «уникальное» число
    public static int thirdUniqueBigger(List<Integer> list) {
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(2)
                .findFirst()
                .orElse(0);
    }

    //список имен 3 самых старших сотрудников с должностью «Инженер»
    public static List<String> threeOldEngineers(List<Employee> list) {
        return list.stream()
                .filter(e -> e.getRole().equals("Engineer"))
                .sorted(Comparator.comparingInt(Employee::getAge).reversed())
                .limit(3)
                .map(Employee::getName)
                .toList();
    }

    //средний возраст сотрудников с должностью «Инженер»
    public static double averageEngineerAge(List<Employee> list) {
        return list.stream()
                .filter(e -> e.getRole().equals("Engineer"))
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0);
    }

    //самое длинное слово
    public static String longestWord(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .map(String::toString)
                .findFirst()
                .orElse("");
    }

    //Имеется строка с набором слов в нижнем регистре, разделенных пробелом. Постройте хеш-мапы, в которой будут хранится пары: слово - сколько раз оно встречается во входной строке
    public static Map<String, Integer> stringToMap(String str) {
        return Arrays.stream(str.split(" "))
                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
    }

    //строки из списка в порядке увеличения длины слова, если слова имеют одинаковую длины, то должен быть сохранен алфавитный порядок
    public static void sortStrings(List<String> strings) {
        System.out.println("Строки из списка в порядке увеличения длины слова: ");
        strings.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .map(String::toString)
                .forEach(System.out::println);
    }

    //Имеется массив строк, в каждой из которых лежит набор из 5 строк, разделенных пробелом, найдите среди всех слов самое длинное, если таких слов несколько, получите любое из них
    public static String anyLongestWord(String[] strings) {
        return Arrays.stream(strings)
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .max(Comparator.comparing(String::length))
                .orElse("");
    }
}
