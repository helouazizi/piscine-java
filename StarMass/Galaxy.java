import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        this.celestialObjects.add(celestialObject);
    }

    public Map<String,Integer> computeMassRepartition() {
        Map<String, Integer> massRepartition = new HashMap<>();
        massRepartition.put("Star", 0);
        massRepartition.put("Planet", 0);
        massRepartition.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            int mass = obj.getMass();

            if (obj instanceof Star) {
                massRepartition.put("Star", massRepartition.get("Star") + mass);
            } else if (obj instanceof Planet) {
                massRepartition.put("Planet", massRepartition.get("Planet") + mass);
            } else {
                massRepartition.put("Other", massRepartition.get("Other") + mass);
            }
        }

        return massRepartition;
    }
}
