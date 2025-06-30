public class Alien {
    private static int nextId = 1;
    private final int id;

    public Alien() {
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "Alien-" + id;
    }
}