package lesson5;

public class Lesson5Main {
    public static void main(String[] args) {
      AppData dannye = new AppData();
        String filePath = "src/main/resources/lesson5/primer1.csv";
        String filePath2 = "src/main/resources/lesson5/primer1Save.csv";
        dannye.loadFrom(filePath);
        dannye.saveTo(filePath2);
    }
}
