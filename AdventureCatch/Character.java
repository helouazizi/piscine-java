import java.util.List;
import java.util.ArrayList;

public abstract class Character {
    private static List<Character> allCharacters = new ArrayList<>();
    private final String name;
    private final int maxHealth;
    private int currentHealth;
    private Weapon weapon;
    public boolean isDead = false;

    public Character(String name, int maxHealth, Weapon weapon) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    protected void setCurrentHealth(int n) {
        this.currentHealth = Math.min(n, this.maxHealth);
        if (this.currentHealth <= 0) {
            this.currentHealth = 0;
            this.isDead = true;
        }
    }

    public Weapon getWeapon() {
        return this.weapon;
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

    public boolean isDead() {
        return this.isDead;
    }

    abstract public void attack(Character c) throws DeadCharacterException;

    abstract public void takeDamage(int damage) throws DeadCharacterException;

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
        while (!c1.isDead() && !c2.isDead()) {
            try {
                c1.attack(c2);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
            }
            if (c2.isDead()) return c1;

            try {
                c2.attack(c1);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
            }
            if (c1.isDead()) return c2;
        }
        return c1;
    }
}
