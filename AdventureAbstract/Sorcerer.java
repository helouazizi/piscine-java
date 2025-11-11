public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxLength, int healCapacity) {
        super(name, maxLength);
        this.healCapacity = healCapacity;
    }

    public Sorcerer(String name, int maxLength) {
        super(name, maxLength);
        this.healCapacity = 0;
    }

    @Override
    public void heal(Character c) {
        if (this.getCurrentHealth() == 0)
            return;
        c.setCurrentHealth(c.getCurrentHealth() + this.healCapacity);
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.",
                    this.getName(), this.healCapacity);
        } else {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.",
                    this.getName(), this.getCurrentHealth(), this.healCapacity);
        }

    }

    @Override
    public void attack(Character c) {
        heal(this);
        c.takeDamage(10);
    }

    @Override
    public void takeDamage(int i) {
        int newHealth = this.getCurrentHealth() - i;

        if (newHealth < 0) {
            newHealth = 0;
        }

        this.setCurrentHealth(newHealth);
    }
}
