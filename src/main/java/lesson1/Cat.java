package lesson1;

public class Cat implements CanJump, CanRun {
    private final int jumpingHeight;
    private final String name;
    private int runningLength;
    private double jumpingHigh;

    public Cat(String name, int jumpingHeight, int runningLength) {
        this.jumpingHeight = jumpingHeight;
        this.name = name;
        this.runningLength = runningLength;
    }

    public double getJumpingHigh() {
        return jumpingHigh;
    }

    public void setJumpingHigh(int jumpingHigh) {
        this.jumpingHigh = jumpingHigh;
    }

    @Override
    public double jump(Wall wall) {
        System.out.println("Я кот " + name + ", я прыгаю!");
        if (jumpingHeight < wall.getHeight()) {
            System.out.println("Не допрыгнул, выбываю из игры!");
        }
        System.out.println("Затратил " + wall.getHeight() / jumpingHeight);
        System.out.println();
        return wall.getHeight() / jumpingHeight;
    }

    @Override
    public double run(Track track) {
        System.out.println("Я кот " + name + ", я пробежал!");
        if (runningLength < track.getLength()) {
            System.out.println("Не допбежал, выбываю из игры!");
        }
        System.out.println();
        return 0;
    }
}