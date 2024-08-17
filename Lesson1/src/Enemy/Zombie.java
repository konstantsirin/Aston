package src.Enemy;

import org.w3c.dom.ls.LSOutput;

public class Zombie extends Enemy {
    private int countLive = 1;
    public Zombie(Integer health) {
        super(health);
    }

    @Override
    public boolean isAlive() {

        if (getHealth() < 0 && countLive == 1) {
            boolean isResurrected = Math.random() > 0.5;
            if (isResurrected) {
                countLive--;
                System.out.println("Зомби ожил!!!");
                setHealth(50);
            }
            return isResurrected;
        } else if (getHealth() < 0 && countLive == 0) {
            return false;
        }

        return true;
    }
}
