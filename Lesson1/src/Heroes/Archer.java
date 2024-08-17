package src.Heroes;

import src.Enemy.Enemy;

public class Archer extends Hero {
    private final int DAMAGE = 25;

    public Archer(String name, Integer health) {
        super(name, health);
        setTypeHero("������");
    }

    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive() && isAlive()) {
            System.out.println(getTypeHero() + " " + getTypeHero() + " ������� �����");
            enemy.takeDamage(DAMAGE);
        }
    }
}
