package src.Enemy;

import org.w3c.dom.ls.LSOutput;

public class Zombie extends Enemy {
    public Zombie(Integer health) {
        super(health);
    }

    @Override
    public boolean isAlive() {
        if (getHealth() < 0) {
            boolean isResurrected = Math.random() > 0.5;
            if (isResurrected) {
                System.out.println("Зомби ожил!!!");
                setHealth(50);
            }
            return isResurrected;
        }

        return true;
    }
}
