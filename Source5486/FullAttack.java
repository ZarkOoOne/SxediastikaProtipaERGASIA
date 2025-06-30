import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FullAttack implements BattleStrategy {
    private final AlienArmy alienArmy;
    private final Warrior warrior;

    public FullAttack(AlienArmy alienArmy, Warrior warrior) {
        this.alienArmy = alienArmy;
        this.warrior = warrior;
    }

    @Override
    public void executeStrategy() {
        List<Alien> attackingAliens = new ArrayList<>(alienArmy.getAliens());
        System.out.println(">>> to AllienArmy kanei FullAttack me " + attackingAliens.size() + " Alien!");
        
        int damage = (int) (attackingAliens.size() * 2 / warrior.getVisibility());
        warrior.takeDamage(damage);

        alienArmy.setLastAttackInfo(new LastAttackInfo(attackingAliens, "full"));
        alienArmy.notifyObservers();
    }
}