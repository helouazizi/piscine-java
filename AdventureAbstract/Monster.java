public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    public String toString() {

        return this.getCurrentHealth() > 0
                ? String.format("%s is a monster with %d HP", this.getName(), this.getCurrentHealth())
                : String.format("%s is a monster and is dead", this.getName());
    }

    @Override
    public void attack(Character c) {
        c.takeDamage(7);
    }

    @Override
    public void takeDamage(int i) {
        int reducedDamage = (int) Math.floor(i * 0.8);

        int newHealth = this.getCurrentHealth() - reducedDamage;

        if (newHealth < 0) {
            newHealth = 0;
        }

        this.setCurrentHealth(newHealth);
    }

}
