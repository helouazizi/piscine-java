
import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private static List<Character> allCharacters = new ArrayList<>();
    private final String name;
    private final int maxHealth;
    private int currentHealth;

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }

    protected void setCurrentHealth(int n) {
        this.currentHealth = Math.min(n, this.maxHealth);
    }

    public String getName() {
        return this.name;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    abstract public void attack(Character c);
    // {
    // c.takeDamage(9);
    // }

    abstract public void takeDamage(int i);
    // {
    // currentHealth -= i;
    // if (currentHealth < 0) {
    // currentHealth = 0;
    // }
    // }

    public String toString() {

        return this.currentHealth > 0
                ? String.format("%s : %d/%d", this.getName(), this.getCurrentHealth(), this.maxHealth)
                : String.format("%s : KO", this.getName());
    }

    public static String printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");

        if (allCharacters.isEmpty()) {
            sb.append("Nobody's fighting right now !\n");
        } else {
            sb.append("Characters currently fighting :\n");
            for (Character c : allCharacters) {
                sb.append(" - ").append(c.toString()).append("\n");
            }
        }

        sb.append("------------------------------------------\n");
        return sb.toString();

    }

    public static Character fight(Character c1, Character c2) {
        while (c1.currentHealth != 0 || c2.currentHealth != 0) {
            c1.attack(c2);
            if (c2.currentHealth == 0) {
                return c1;
            }

            c2.attack(c1);
            if (c1.currentHealth == 0) {
                return c2;
            }
        }
        return c1;

    }

}
