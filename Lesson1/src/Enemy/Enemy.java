package src.Enemy;

import src.Heroes.Hero;

public class Enemy implements Mortal {
    private int health;
    private final int DAMAGE = 15;

    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        if (isAlive()) {
            this.setHealth(this.health - damage);
            if (isAlive()) {
                System.out.println("������� ���� " + damage + ". �������� �������� " + this.health + ".");
            } else {
                System.out.println("��������� ����");
            }
        }
    }

    public void attackHero(Hero hero) {
        System.out.println("���� ������� " + hero.getTypeHero());
        hero.takeDamage(DAMAGE);
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
