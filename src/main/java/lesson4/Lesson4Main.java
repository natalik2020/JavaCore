package lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lesson4Main {
    public static void main(String[] args) {
        unicWords();

        PhoneDict phoneDict = new PhoneDict();
        phoneDict.numberAdd("Ivanov", "+71234567");
        phoneDict.numberAdd("Ivanov", "+71234567");
        phoneDict.numberAdd("Ivanov", "+876543");
        phoneDict.numberAdd("Petrov", "+876543");
        phoneDict.numberAdd("Petrov", "+876543");
        phoneDict.numberAdd("Petrov", "+456743");
        phoneDict.numberAdd("Ivov", "+876543");
        phoneDict.numberAdd("Ivov", "+84563");
        phoneDict.numberAdd("Inov", "+8843");
        phoneDict.numberAdd("Inov", "+879873");
        phoneDict.numberAdd("Pumm", "+872343");

        System.out.println(phoneDict);
    }

    private static void unicWords() {
        String[] words = {"aa", "aa", "abc", "sdf", "sdf",
                "asd", "dgfhbvd", "asd", "hju", "aed"};

        Map<String, Integer> countWord = new HashMap<>();

        Set<String> stringUnicWord = new HashSet<>();
        for (String word : words) {
            stringUnicWord.add(word);

            Integer count = countWord.get(word);
            if (count == null) {
                count = 0;
            }
            countWord.put(word, count + 1);
        }
        System.out.println(stringUnicWord);
        System.out.println(countWord);
    }
}
