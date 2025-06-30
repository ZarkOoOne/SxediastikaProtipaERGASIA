import java.util.ArrayList;
import java.util.List;

public class AlienArmy implements Observable {
    private List<Alien> aliens;
    private List<Observer> observers;
    private BattleStrategy battleStrategy;
    private LastAttackInfo lastAttackInfo; 

    public AlienArmy(int initialSize) {
        this.aliens = new ArrayList<>();
        for (int i = 0; i < initialSize; i++) {
            this.aliens.add(new Alien());
        }
        this.observers = new ArrayList<>();
    }

    public void setBattleStrategy(BattleStrategy strategy) {
        this.battleStrategy = strategy;
    }

    public void executeBattleStrategy() {
        if (this.battleStrategy != null) {
            this.battleStrategy.executeStrategy();
        }
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    
    public void setLastAttackInfo(LastAttackInfo info) {
        this.lastAttackInfo = info;
    }

    public LastAttackInfo getLastAttackInfo() {
        return this.lastAttackInfo;
    }

    public void destroyAliens(List<Alien> aliensToDestroy) {
        int initialCount = this.aliens.size();
        this.aliens.removeAll(aliensToDestroy);
        int destroyedCount = initialCount - this.aliens.size();
        System.out.println("O Warrior katestrepse " + destroyedCount + " Alliens!");
    }

    public List<Alien> getAliens() { return this.aliens; }
    public int getAlienCount() { return this.aliens.size(); }
    public boolean isDefeated() { return this.aliens.isEmpty(); }
}