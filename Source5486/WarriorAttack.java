import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WarriorAttack implements BattleStrategy {
    private final Warrior warrior;
    private final AlienArmy alienArmy;

    public WarriorAttack(Warrior warrior, AlienArmy alienArmy) {
        this.warrior = warrior;
        this.alienArmy = alienArmy;
    }

    @Override
    public void executeStrategy() {
        System.out.println(">>> o Warrior etoimazetai gia epithesi!");
        
        Set<Alien> aliensToDestroy = new HashSet<>();
        List<Observer> intelSources = warrior.getIntelSources();

        for (Object source : intelSources) {
            if (source instanceof Satellite) {
                aliensToDestroy.addAll(((Satellite) source).getObservedAliens());
                ((Satellite) source).clearObservations();
            } else if (source instanceof Telescope) {
                aliensToDestroy.addAll(((Telescope) source).getObservedAliens());
                ((Telescope) source).clearObservations();
            }
        }

        if (aliensToDestroy.isEmpty()) {
            System.out.println("O Warrior den exei plirofories gia stoxous kai i epithesi apotinxanei.");
        } else {
            System.out.println("o Warrior stoxevei " + aliensToDestroy.size() + " Allien me vasi tis plirofories pou exei.");
            alienArmy.destroyAliens(new ArrayList<>(aliensToDestroy));
        }

        warrior.increaseVisibility();
    }
}