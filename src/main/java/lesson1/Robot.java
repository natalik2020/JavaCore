package lesson1;

public class Robot implements CanRun, CanJump {
    private final int jumpingHeight;
    private final String name;
    private int runLength;
    private int jumpingHigh;

    public int getJumpingHigh() {
        return jumpingHigh;
    }

    public Robot(String name, int jumpingHeight, int runLength) {
        this.jumpingHeight = jumpingHeight;
        this.name = name;
        this.runLength = runLength;
    }

    public void setJumpingHigh(int jumpingHigh) {
        this.jumpingHigh = jumpingHigh;
    }

    @Override
    public double jump(Wall wall) {
        System.out.println("Я робот " + name + ", я прыгаю!");
        if (jumpingHeight < wall.getHeight()) {
            System.out.println("Не допрыгнул, выбываю из игры!");
        }
        System.out.println("Затратил " + wall.getHeight() / jumpingHeight);
        System.out.println();
        return wall.getHeight() / jumpingHeight;
    }

    @Override
    public double run(Track track) {
        System.out.printf("Я робот, %s я пробежал!\n", name);
        if (runLength < track.getLength()) {
            System.out.println("Не допбежал, выбываю из игры!");
        }
        System.out.println();
        return 0;
    }
}
