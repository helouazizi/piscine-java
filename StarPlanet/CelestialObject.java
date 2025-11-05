import java.util.Objects;

public class CelestialObject {
    public double x, y, z;
    public String name;
    public static double KM_IN_ONE_AU = 150000000;

    // Default constructor
    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public String getName() {
        return this.name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(CelestialObject defeoult, CelestialObject obj2) {
        double dx = obj2.x - defeoult.x;
        double dy = obj2.y - defeoult.y;
        double dz = obj2.z - defeoult.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject defeoult, CelestialObject obj2) {
        double d = getDistanceBetween(defeoult, obj2);

        return d * KM_IN_ONE_AU;
    }

    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", this.name, this.x, this.y, this.z);
    }

    public boolean equals(CelestialObject obj) {
        if (this == obj)
            return true; 
        if (obj == null || getClass() != obj.getClass())
            return false;
        return this.name == obj.name && this.x == obj.x && this.y == obj.y && this.z == obj.z;
    }

    public int hashCode() {
        return Objects.hash(name, x, y, z);
    }

}