package lesson4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneDict {
    Map<String, Set<String>> spravka;

    public PhoneDict() {
        spravka = new HashMap<>();
    }

    public void numberAdd(String fio, String number) {
        Set<String> phones = spravka.get(fio);
        if (phones == null) {
            phones = new HashSet<>();
            spravka.put(fio, phones);
        }
        phones.add(number);
    }

    @Override
    public String toString() {
        return "PhoneDict{" +
                "spravka=" + spravka +
                '}';
    }
}
