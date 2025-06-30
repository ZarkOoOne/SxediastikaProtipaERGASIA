import java.util.ArrayList;
import java.util.List;

public class Warrior {
    private int power;
    private double visibility;
    private List<Observer> intelSources;
    private BattleStrategy battleStrategy; 

    public Warrior(int initialPower, double initialVisibility, AlienArmy alienArmy) {
        this.power = initialPower;
        this.visibility = initialVisibility;
        this.intelSources = new ArrayList<>();
        this.battleStrategy = new WarriorAttack(this, alienArmy);
    }

    public void executeBattleStrategy() {
        this.battleStrategy.executeStrategy();
    }

    public void takeDamage(int damage) {
        this.power -= damage;
        System.out.println("o Warrior dexetai " + damage + " damage. Power pou apomenh: " + this.power);
        decreaseVisibility();
    }
    
    public void addIntelSource(Observer source) { this.intelSources.add(source); }
    public List<Observer> getIntelSources() { return this.intelSources; }
    public int getPower() { return power; }
    public double getVisibility() { return visibility; }
    public boolean isDefeated() { return this.power <= 0; }
    
    public void increaseVisibility() {
        this.visibility += 0.25;
        System.out.println("i oratotita tou Warrior afksithike se " + String.format("%.2f", this.visibility));
    }
    
    public void decreaseVisibility() {
        this.visibility = Math.max(0.2, this.visibility - 0.1);
        System.out.println("i ortatotita tou Warrior afksithike se " + String.format("%.2f", this.visibility));
    }
}