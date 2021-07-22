package lesson2;

public class MyArrayDataException extends Throwable {
    public MyArrayDataException(int i, int j) {
    super("Ошибка. Не число в ячейке " + i + " " + j);
    }
}
