public class Player {
    private String name;
    private int overall;
    private int cost;

    public Player(String name, int overall, int cost) {
        this.name = name;
        this.overall = overall;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public int getOverall() {
        return this.overall;
    }

    public int getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return name + " (Overall: " + overall + ", Cost: " + cost + ")";
    }
}
