package src.Heroes;

import src.Enemy.Enemy;

public class Mage extends Hero {
    private final int DAMAGE = 30;

    public Mage(String name, Integer health) {
        super(name, health);
        setTypeHero("Маг");
    }

    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive() && isAlive()) {
            System.out.println(getTypeHero() + " " + getTypeHero() + " атакует врага");
            enemy.takeDamage(DAMAGE);
        }
    }
}
