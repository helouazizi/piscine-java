import java.util.Objects;

public class Planet extends CelestialObject {

    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Planet other = (Planet) obj;
        return this.name.equals(other.name) && this.x == other.x && this.y == other.y && this.z == other.z && this.centerStar.equals(other.centerStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,x,y,z,centerStar);
    }

    @Override
    public String toString() {
        double distanceWithCenterStar = getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU",
                getName(),
                centerStar.getName(),
                distanceWithCenterStar);
    }
}
