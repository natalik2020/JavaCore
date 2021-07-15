package lesson1;

public class Main {
    public static void main(String[] args) {

        Wall zabor = new Wall(5);
        CanJump[] jumpers = {
                new Human("Вася", 4, 200),
                new Human("Петя", 6, 300),
                new Robot("x1", 10, 150),
                new Robot("x2", 11, 150),
                new Cat("Барсик", 4, 125),
                new Cat("Обормот", 7, 125),
        };

        for (CanJump jumper : jumpers) {
            jumper.jump(zabor);
        }

        Track doroga = new Track(100);
        CanRun[] runners = {
                new Human("Вася", 4, 200),
                new Human("Петя", 6, 300),
                new Robot("x1", 10, 150),
                new Robot("x2", 11, 150),
                new Cat("Барсик", 4, 125),
                new Cat("Обормот", 7, 125),
        };

        for (int i = 0; i < runners.length; i++) {
            runners[i].run(doroga);
        }
    }


}
