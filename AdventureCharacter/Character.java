public class Character {
    private final String name;
    private final int maxHealth;
    private int currentHealth;

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
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

    public void attack(Character c) {
        c.takeDamage(9);
    }

    public void takeDamage(int i) {
        currentHealth -= i;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public String toString() {

        return this.currentHealth > 0
                ? String.format("%s : %d/%d", this.getName(), this.getCurrentHealth(), this.maxHealth)
                : String.format("%s : KO", this.getName());
    }

}
