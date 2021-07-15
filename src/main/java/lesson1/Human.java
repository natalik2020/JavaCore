package lesson1;

public class Human implements CanJump, CanRun {
    private final String name;
    private int jumpingHeight;
    private int runLength;

    public Human(String name, int jumpingHeight, int runLength) {
        this.jumpingHeight = jumpingHeight;
        this.name = name;
        this.runLength = runLength;
    }

    public int getJumpingHeight() {
        return jumpingHeight;
    }

    public void setJumpingHeight(int jumpingHeight) {
        this.jumpingHeight = jumpingHeight;
    }

    public int getRunLength() {
        return runLength;
    }

    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    @Override
    public double jump(Wall wall) {
        System.out.println("Я человек " + name + ", я прыгаю!");
        if (jumpingHeight < wall.getHeight()) {
            System.out.println("Не допрыгнул, выбываю из игры!");
        }
        System.out.println("Затратил " + wall.getHeight() / jumpingHeight);
        System.out.println();
        return wall.getHeight() / jumpingHeight;
    }

    @Override
    public double run(Track track) {
        System.out.println("Я человек " + name + ", я бегу!");
        if (runLength < track.getLength()) {
            System.out.println("Не допбежал, выбываю из игры!");
        }
        System.out.println("Затратил " + track.getLength() / runLength);
        System.out.println();
        return track.getLength() / runLength;
    }
}
