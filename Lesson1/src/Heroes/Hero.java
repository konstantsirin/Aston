package src.Heroes;

import src.Enemy.Enemy;
import src.Enemy.Mortal;

public abstract class Hero implements Mortal {
    private final String name;
    private int health;
    private String typeHero = "Герой";

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    protected void setTypeHero(String typeHero) {
        this.typeHero = typeHero;
    }

    public String getTypeHero() {
        return this.typeHero;
    }

    abstract void attackEnemy(Enemy enemy);

    public void takeDamage(int damage) {
        if (isAlive()) {
            this.setHealth(this.health - damage);
            if (isAlive()) {
                System.out.println("Получен урон " + damage + ". Осталось здоровья " + this.health + ".");
            } else {
                System.out.println(typeHero + " " + getName() + " убит");
            }
        }
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}
