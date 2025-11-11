public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon massue) {
        super(name, maxHealth, massue);
    }

    public String toString() {

        return this.getCurrentHealth() > 0
                ? String.format("%s is a monster with %d HP", this.getName(), this.getCurrentHealth())
                : String.format("%s is a monster and is dead", this.getName());
    }

    @Override
    public void attack(Character c) throws DeadCharacterException {
        if (this.isDead()) {
            throw new DeadCharacterException(this);
        }
        if (c.isDead()) {
            throw new DeadCharacterException(c);
        }
        Weapon weapon = this.getWeapon();
        int damage = (weapon != null) ? weapon.getDamage() : 7;
        c.takeDamage(damage);
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
