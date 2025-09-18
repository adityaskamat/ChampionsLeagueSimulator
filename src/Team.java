import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> squad;
    private int budget;
    private int groupStagePoints;
    private int goalsFor;
    private int goalsAgainst;
    private int wins = 0;
    private int draws = 0;
    private int losses = 0;

    public Team(String name, int budget) {
        this.name = name;
        this.budget = budget;
        this.squad = new ArrayList<>();
        this.groupStagePoints = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getBudget() {
        return this.budget;
    }

    public void addPlayer(Player player) {
        squad.add(player);
        budget -= player.getCost();
    }

    public ArrayList<Player> getSquad() {
        return squad;
    }

    public int getStrength() {
        // Sort squad descending by overall
        squad.sort((p1, p2) -> p2.getOverall() - p1.getOverall());

        int strength = 0;

        for (int i = 0; i < squad.size(); i++) {
            if (i < 11) {
                // Starting 11 count fully
                strength += squad.get(i).getOverall();
            } else {
                // Bench players give partial contribution
                strength += squad.get(i).getOverall() * 0.3;
            }
        }

        return strength;
    }

    public void adjustGoals(int forGoals, int againstGoals) {
        goalsFor += forGoals;
        goalsAgainst += againstGoals;
    }

    public void addPoints(int points) {
        groupStagePoints += points;
    }

    public int getGoalsFor() {
        return this.goalsFor;
    }

    public int getGoalsAgainst() {
        return this.goalsAgainst;
    }

    public int getGroupStagePoints() {
        return this.groupStagePoints;
    }

    public void resetGroupStats() {
        this.groupStagePoints = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
        this.wins = 0;
        this.draws = 0;
        this.losses=0;
    }

    public void recordMatch(int goalsScored, int goalsConceded) {
        goalsFor += goalsScored;
        goalsAgainst += goalsConceded;

        if (goalsScored > goalsConceded) {
            wins++;
            groupStagePoints += 3;
        } else if (goalsScored == goalsConceded) {
            draws++;
            groupStagePoints += 1;
        } else {
            losses++;
        }
    }

    public int getGoalDifference() {
        return goalsFor - goalsAgainst;
    }

    @Override
    public String toString() {
        return name + " | Pts: " + groupStagePoints + " | W: " + wins + " D: " + draws + " L: " + losses + " | GF: " + goalsFor + " GA: " + goalsAgainst + " GD: " + getGoalDifference();
    }

}
