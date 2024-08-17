package src;

import src.Enemy.Enemy;
import src.Heroes.Archer;
import src.Heroes.Hero;
import src.Heroes.Mage;
import src.Heroes.Warrior;

public class TrainingGround {
    public static void main(String[] args) {
        Enemy enemy = new Enemy(100);

        Warrior warrior = new Warrior("Петрушка", 100);
        warrior.attackEnemy(enemy);

        Mage mage = new Mage("Магушка", 100);
        mage.attackEnemy(enemy);

        Archer archer = new Archer("Лучнушка", 100);
        archer.attackEnemy(enemy);
    }

}
