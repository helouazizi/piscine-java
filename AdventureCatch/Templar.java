public class Templar extends Character implements Tank, Healer {
    private final int shield;
    private final int healCapacity;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.shield = shield;
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

    public int getShield() {
        return this.shield;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return String.format(
                    "%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",
                    this.getName(), this.shield, this.healCapacity);
        } else {
            return String.format(
                    "%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",
                    this.getName(), this.getCurrentHealth(), this.healCapacity, this.shield);
        }
    }

    @Override
    public   void attack(Character c) throws DeadCharacterException {
        if (this.isDead()) {
            throw new DeadCharacterException(this);
        }
        if (c.isDead()) {
            throw new DeadCharacterException(c);
        }
        heal(this);
        Weapon weapon = this.getWeapon();
        int damage = (weapon != null) ? weapon.getDamage() : 6;
        c.takeDamage(damage);

    }

    @Override
    public void takeDamage(int i) {
        int newHealth = this.getCurrentHealth() - (i - this.shield);

        if (newHealth < 0) {
            newHealth = 0;
        }

        this.setCurrentHealth(newHealth);
    }
}
