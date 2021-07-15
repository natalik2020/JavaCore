package lesson1;

public class Wall {
    private double height;

    public Wall(int height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getTimeToOvercomeWall(CanJump jumper) {
        return jumper.jump(this);
    }
}
