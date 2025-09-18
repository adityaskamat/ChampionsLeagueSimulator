import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Group {

    private String name;
    private ArrayList<Team> teams;

    public Group(String name, ArrayList<Team> teams) {
        this.name = name;
        this.teams = teams;
    }

    public void playGroupStage() {
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                simulateMatch(teams.get(i), teams.get(j)); // i home, j away
                simulateMatch(teams.get(j), teams.get(i)); // j home, i away
            }
        }
    }

    // simple match simulation
    private void simulateMatch(Team t1, Team t2) {
        int t1Goals = generateGoals(t1.getStrength(), t2.getStrength());
        int t2Goals = generateGoals(t2.getStrength(), t1.getStrength());

        t1.recordMatch(t1Goals, t2Goals);
        t2.recordMatch(t2Goals, t1Goals);

        System.out.println(t1.getName() + " " + t1Goals + " - " + t2Goals + " " + t2.getName());
    }

    // Helper method for realistic scoring
    private int generateGoals(int teamStrength, int opponentStrength) {
        double ratio = (double) teamStrength / (teamStrength + opponentStrength);

        // Random value, skewed toward lower numbers
        double rand = Math.random();
        double skew = Math.pow(rand, 1.2);

        // Scale so realistic range is 0–5
        double scaled = skew * 5 * ratio;

        // Add a small random “boost” to allow occasional 4–5 goals
        double bonus = Math.random() * 0.5;

        int goals = (int) Math.round(scaled + bonus);

        // Cap at 5
        if (goals > 5) goals = 5;
        return goals;
    }

    public void printStandings() {
        Collections.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                if (t2.getGroupStagePoints() != t1.getGroupStagePoints())
                    return t2.getGroupStagePoints() - t1.getGroupStagePoints();
                else
                    return t2.getGoalDifference() - t1.getGoalDifference();
            }
        });

        System.out.println("=== Group " + name + " Standings ===");
        for (Team t : teams) {
            System.out.println(t);
        }
    }

    // get top 2 teams for knockout stage
    public ArrayList<Team> getTop2Teams() {
        printStandings(); // optional, show standings
        ArrayList<Team> top2 = new ArrayList<>();
        top2.add(teams.get(0));
        top2.add(teams.get(1));
        return top2;
    }

}
