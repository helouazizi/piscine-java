import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super();
        this.magnitude = 0.0;
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        super(name, x, y, z);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double m) {
        this.magnitude = m;

    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", super.getName(), this.magnitude);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Star)) {
            return false;
        }
        Star o = (Star) other;
        return this.getName() == o.getName() &&
               this.getX() == o.getX() &&
               this.getY() == o.getY() &&
               this.getZ() == o.getZ() &&
               this.magnitude == o.magnitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), super.getX(), super.getY(), super.getZ(), this.magnitude);
    }
}