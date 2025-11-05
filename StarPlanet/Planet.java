import java.util.Objects;

public class Planet extends CelestialObject {

    private Star centerStar;

    // Default constructor
    public Planet() {
        super();                   // Call CelestialObject default constructor
        this.centerStar = new Star(); // Initialize centerStar with default Star
    }

    // Parameterized constructor
    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(name, x, y, z);      // Call CelestialObject parameterized constructor
        this.centerStar = centerStar;
    }

    // Getter
    public Star getCenterStar() {
        return centerStar;
    }

    // Setter
    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    // Equals based on centerStar only
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Planet other = (Planet) obj;
        return Objects.equals(centerStar, other.centerStar);
    }

    // HashCode based on centerStar only
    @Override
    public int hashCode() {
        return Objects.hash(centerStar);
    }

    // toString with formatted distance
    @Override
    public String toString() {
        double distanceWithCenterStar = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU",
                getName(),
                centerStar.getName(),
                distanceWithCenterStar);
    }
}
