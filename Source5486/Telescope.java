import java.util.ArrayList;
import java.util.List;

public class Telescope implements Observer {
    private List<Alien> observedAliens = new ArrayList<>();
    private final AlienArmy army;

    public Telescope(AlienArmy army) {
        this.army = army;
        this.army.attach(this); 
    }

    @Override
    public void update() {
        LastAttackInfo info = army.getLastAttackInfo();
        if (info != null && "full".equalsIgnoreCase(info.getAttackType())) {
            this.observedAliens.addAll(info.getAttackingAliens());
            System.out.println("[Telescope] Vrethikan " + info.getAttackingAliens().size() + " Alliens se FullAttack.");
        }
    }

    public List<Alien> getObservedAliens() {
        return new ArrayList<>(observedAliens);
    }

    public void clearObservations() {
        this.observedAliens.clear();
    }
}