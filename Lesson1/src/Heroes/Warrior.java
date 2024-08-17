package src.Heroes;

import src.Enemy.Enemy;

public class Warrior extends Hero {
    private final int DAMAGE = 35;
    public Warrior(String name, Integer health) {
        super(name, health);
        setTypeHero("����");
    }

    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive() && isAlive()) {
            System.out.println(getTypeHero() + " " + getName() + " ������� �����");
            enemy.takeDamage(DAMAGE);
        }
    }
}
