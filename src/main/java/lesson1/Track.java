package lesson1;

public class Track {
    private double length;

    public Track(int length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getTimeToOvercomeTrack(CanRun tracker) {
        return tracker.run(this);
    }
}