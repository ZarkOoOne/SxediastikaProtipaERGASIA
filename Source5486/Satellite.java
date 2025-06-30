import java.util.ArrayList;
import java.util.List;

public class Satellite implements Observer {
    private List<Alien> observedAliens = new ArrayList<>();
    private final AlienArmy army;

    public Satellite(AlienArmy army) {
        this.army = army;
        this.army.attach(this); 
    }

    @Override
    public void update() {
        LastAttackInfo info = army.getLastAttackInfo();
        if (info != null && "partial".equalsIgnoreCase(info.getAttackType())) {
            List<Alien> attackingAliens = info.getAttackingAliens();
            int countToObserve = attackingAliens.size() / 2;
            for (int i = 0; i < countToObserve; i++) {
                this.observedAliens.add(attackingAliens.get(i));
            }
            System.out.println("[Satellite] Vrethikan " + countToObserve + " Alliens se PartialAttack.");
        }
    }

    public List<Alien> getObservedAliens() {
        return new ArrayList<>(observedAliens);
    }

    public void clearObservations() {
        this.observedAliens.clear();
    }
}