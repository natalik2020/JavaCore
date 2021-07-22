package lesson2;

public class Main {
    public static void main(String[] args) {
        String[] array1 = {"1", "2", "3", "4"};
        String[][] array = {array1, array1, array1, array1};

        String[] arrayBugLine = {"1", "2", "3", "abc"};
        String[][] arrayBug = {arrayBugLine, arrayBugLine, arrayBugLine, arrayBugLine};

        try {
            checkArr(array);
            summArr(array);

            checkArr(arrayBug);
            summArr(arrayBug);
        } catch (MyArraySizeException e) {
            System.out.println("Массив не 4х4");
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static void checkArr(String[][] array) {
        int length = array.length;
        if (length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            String[] element = array[i];
            if (element.length != 4) {
                throw new MyArraySizeException();
            }
        }
    }

    private static void summArr(String[][] array) throws MyArrayDataException {
        long summ = 0L;
        for (int i = 0; i < array.length; i++) {
            String[] elementArr = array[i];
            for (int j = 0; j < elementArr.length; j++) {
                String element = array[i][j];
                int value = 0;
                try {
                    value = Integer.parseInt(element);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                summ = summ + value;
            }
        }
        System.out.println("Сумма равна " + summ);
    }
}
