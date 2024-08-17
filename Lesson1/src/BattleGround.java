package src;

import src.Enemy.Enemy;
import src.Enemy.Zombie;
import src.Heroes.Archer;
import src.Heroes.Hero;
import src.Heroes.Mage;
import src.Heroes.Warrior;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BattleGround {
    public static void main(String[] args) {
        // Enemy enemy = new Enemy(100);
        ArrayList<Zombie> zombieArray = new ArrayList<>();
        zombieArray.add(new Zombie(100));
        zombieArray.add(new Zombie(100));
        zombieArray.add(new Zombie(100));
        zombieArray.add(new Zombie(100));
        zombieArray.add(new Zombie(100));
        zombieArray.add(new Zombie(100));
        zombieArray.add(new Zombie(100));
        zombieArray.add(new Zombie(100));

        Warrior warrior = new Warrior("Петрушка", 100);
        Mage mage = new Mage("Магушка", 100);
        Archer archer = new Archer("Лучнушка", 100);

        for (Zombie zombie: zombieArray) {
            while (zombie.isAlive()) {

                if (!warrior.isAlive() && !mage.isAlive() && !archer.isAlive()) return;

                if (warrior.isAlive()) {
                    zombie.attackHero(warrior);
                } else if (mage.isAlive()) {
                    zombie.attackHero(mage);
                } else if (archer.isAlive()) {
                    zombie.attackHero(archer);
                }
                if (warrior.isAlive()) warrior.attackEnemy(zombie);
                if (mage.isAlive()) mage.attackEnemy(zombie);
                if (archer.isAlive()) archer.attackEnemy(zombie);
            }
        }




    }
}
