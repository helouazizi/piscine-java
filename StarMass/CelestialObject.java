import java.util.Objects;

public class CelestialObject {
    private String name;
    private double x;
    private double y;
    private double z;
    private int mass; 
    public static final double KM_IN_ONE_AU = 150000000;

    public CelestialObject() {
        this("Soleil", 0.0, 0.0, 0.0, 0);
    }

    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
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

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public static double getDistanceBetween(CelestialObject c1, CelestialObject c2) {
        double x = (c2.x - c1.x) * (c2.x - c1.x);
        double y = (c2.y - c1.y) * (c2.y - c1.y);
        double z = (c2.z - c1.z) * (c2.z - c1.z);
        double result = Math.sqrt(x + y + z);
        return result;
    }

    public static double getDistanceBetweenInKm(CelestialObject c1, CelestialObject c2) {
        double x = (c2.x - c1.x) * (c2.x - c1.x);
        double y = (c2.y - c1.y) * (c2.y - c1.y);
        double z = (c2.z - c1.z) * (c2.z - c1.z);
        double result = Math.sqrt(x + y + z);
        return result * KM_IN_ONE_AU;
    }

    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    public boolean equals(CelestialObject c1) {
        if (c1 == null) {
            return false;
        }
        if (c1.hashCode() != hashCode()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(x, y, z, name);
    }
}