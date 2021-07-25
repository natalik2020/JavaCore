package lesson3;

public class Lesson3Main {
    public static void main(String[] args) {
        Apple[] apples = {new Apple(), new Apple()};
        swap(apples);

        Orange[] oranges = {new Orange(), new Orange()};
        swap(oranges);

        Box<Apple> korobkaSJablokami = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> korobkaSApelsinami = new Box<Orange>(new Orange(), new Orange());
        boolean korobkiRavny = korobkaSJablokami.compare(korobkaSApelsinami);

        System.out.println(korobkiRavny);


        Box<Apple> jashikSJablokami = new Box<>(new Apple());
        System.out.println(korobkaSJablokami.getWeight() + " " + jashikSJablokami.getWeight());
        korobkaSJablokami.peresypatV(jashikSJablokami);
        System.out.println(korobkaSJablokami.getWeight() + " " + jashikSJablokami.getWeight());

    }

    private static <KakojtoFrukt> void swap(KakojtoFrukt[] frukts) {
        if (frukts.length == 0) {
            throw new IllegalArgumentException("Массив пустой!");
        }

        KakojtoFrukt one = frukts[0];
        KakojtoFrukt last = frukts[frukts.length - 1];

        frukts[0] = last;
        frukts[frukts.length - 1] = one;


    }
}
