import java.util.List;

public class LastAttackInfo {
    private final List<Alien> attackingAliens;
    private final String attackType;

    public LastAttackInfo(List<Alien> attackingAliens, String attackType) {
        this.attackingAliens = attackingAliens;
        this.attackType = attackType;
    }

    public List<Alien> getAttackingAliens() {
        return attackingAliens;
    }

    public String getAttackType() {
        return attackType;
    }
}