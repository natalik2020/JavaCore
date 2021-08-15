package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lesson9Main {

//    1. Написать функцию, принимающую список Student
//    и возвращающую список уникальных курсов,
//    на которые подписаны студенты.
//    2. Написать функцию, принимающую на вход список Student
//    и возвращающую список из трех самых любознательных
//    (любознательность определяется количеством курсов).
//    3. Написать функцию, принимающую на вход список Student
//    и экземпляр Course, возвращающую список студентов,
//    которые посещают этот курс.

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Irina",
                Arrays.asList(new Cource("Math"),
                        new Cource("Biology"),
                        new Cource("Testing"))));
        students.add(new Student("Igor",
                Arrays.asList(new Cource("Literature"),
                        new Cource("Biology"),
                        new Cource("Chemistry"),
                        new Cource("Testing"))));
        students.add(new Student("Inna",
                Arrays.asList(new Cource("Math"),
                        new Cource("Biology"),
                        new Cource("Chemistry"),
                        new Cource("Physics"))));

        //1
        System.out.println(students.stream()
                .map(s -> s.getCources())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        //2
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCources().size() - s1.getCources().size())
                .limit(2)
                .collect(Collectors.toList()));

        //3
        Cource cource = new Cource("Testing");
        System.out.println(students.stream()
                .filter(s -> s.getCources().contains(cource))
                .collect(Collectors.toList()));
    }


}
