public class Sorcerer extends Character implements Healer {
    private int healCapacity;

    public Sorcerer(String name, int maxLength) {
        super(name, maxLength);
    }

    public Sorcerer(String name, int maxLength, int healCapacity) {
        super(name, maxLength);
        this.healCapacity = healCapacity;
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
}
