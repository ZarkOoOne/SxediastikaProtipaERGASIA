import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AlienArmy alienArmy = new AlienArmy(40);
        Warrior warrior = new Warrior(150, 1.0, alienArmy);

        Satellite satellite = new Satellite(alienArmy);
        Telescope telescope = new Telescope(alienArmy);

        warrior.addIntelSource(satellite);
        warrior.addIntelSource(telescope);

        System.out.println("--- to paixnidi ksekina! ---");
        int turn = 0;

        while (!warrior.isDefeated() && !alienArmy.isDefeated()) {
            System.out.println("\n-------------------------------------------");
            System.out.println("gyros " + (turn + 1));
            System.out.println("Katastasi Warrior: Power=" + warrior.getPower() + ", Oratotita=" + String.format("%.2f", warrior.getVisibility()));
            System.out.println("Katastasi AlienArmy: " + alienArmy.getAlienCount() + " Allien apomenoun.");
            System.out.println("-------------------------------------------");

            if (turn % 2 == 0) {
                warrior.executeBattleStrategy();
            } else { 
                System.out.println("epelekse epithesi gia to AllienArmy:");
                System.out.println("1. Full Attack");
                System.out.println("2. Partial Attack");
                System.out.print("epelekse [1-2]: ");
                
                int choice = 0;
                if(scanner.hasNextInt()) choice = scanner.nextInt();
                else scanner.next();
                
                BattleStrategy selectedStrategy;
                if (choice == 1) {
                    selectedStrategy = new FullAttack(alienArmy, warrior);
                } else {
                    selectedStrategy = new PartialAttack(alienArmy, warrior, scanner);
                }
                
                alienArmy.setBattleStrategy(selectedStrategy);
                alienArmy.executeBattleStrategy();
            }
            
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            turn++;
        }

        System.out.println("\n--- GAME OVER ---");
        if (warrior.isDefeated()) {
            System.out.println("AllienArmy Won! Warrior is dead.");
        } else {
            System.out.println("Warrior Won! AllienArmy is dead.");
        }
        scanner.close();
    }
}