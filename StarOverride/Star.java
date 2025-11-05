import java.util.Objects;

public class Star extends CelestialObject {

    private double magnitude;

    public Star() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
        this.magnitude = 0.0;
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String toString() {
        return String.format("%s shines at the (%.2f) magnitude", this.name, this.magnitude);
    }

    public boolean equals(CelestialObject obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Star other = (Star) obj;
        return Objects.equals(name, other.name)
                && x == other.x
                && y == other.y
                && z == other.z
                && magnitude == other.magnitude;
    }

    public int hashCode() {
        return Objects.hash(name, x, y, z, magnitude);
    }

}