public class Planet extends CelestialObject {

    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star star) {
        super(name, x, y, z);
        this.centerStar = star;
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
        return centerStar != null ? centerStar.equals(other.centerStar) : other.centerStar == null;
    }

    @Override
    public int hashCode() {
        return centerStar != null ? centerStar.hashCode() : 0;
    }

    @Override
    public String toString() {
        double distanceWithCenterStar = getDistanceBetween(centerStar, centerStar);
        return getName() + " circles around " + centerStar.getName() +
                " at the " + distanceWithCenterStar + " AU";
    }

}