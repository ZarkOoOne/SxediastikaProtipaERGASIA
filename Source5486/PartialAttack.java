import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PartialAttack implements BattleStrategy {
    private final AlienArmy alienArmy;
    private final Warrior warrior;
    private final Scanner scanner;

    public PartialAttack(AlienArmy alienArmy, Warrior warrior, Scanner scanner) {
        this.alienArmy = alienArmy;
        this.warrior = warrior;
        this.scanner = scanner;
    }

    @Override
    public void executeStrategy() {
        int totalAliens = alienArmy.getAlienCount();
        int numToAttack = 0;

        while (true) {
            System.out.print("posoi Allies tha epitethoun (1-" + totalAliens + "); ");
            if (scanner.hasNextInt()) {
                numToAttack = scanner.nextInt();
                if (numToAttack > 0 && numToAttack <= totalAliens) break;
            } else {
                scanner.next();
            }
            System.out.println("mi egkiros arithmos. Prospathise Ksana");
        }
        
        System.out.println(">>> to AlienArmy kanei PartialAttack me " + numToAttack + " Alliens!");
        
        List<Alien> attackingAliens = new ArrayList<>(alienArmy.getAliens());
        Collections.shuffle(attackingAliens);
        attackingAliens = attackingAliens.subList(0, numToAttack);
        
        int damage = (int) (attackingAliens.size() * 2 / warrior.getVisibility());
        warrior.takeDamage(damage);

        alienArmy.setLastAttackInfo(new LastAttackInfo(attackingAliens, "partial"));
        alienArmy.notifyObservers();
    }
}