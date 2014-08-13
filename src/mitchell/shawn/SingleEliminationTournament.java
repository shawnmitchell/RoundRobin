package mitchell.shawn;


import java.util.ArrayList;

/**
 * Created by shawn on 8/12/14.
 */
public class SingleEliminationTournament extends Tournament {
    private int numberOfRounds = 0;

    public void closeRegistration() {
        int entrants = teams.size();
        double total = Math.pow(2, Math.ceil(Math.log(entrants)/Math.log(2)));
        for (int i = entrants; i < total; i++)
            registerTeam(new Team("BYE", 0));
        numberOfRounds = (int)(Math.log(total) / Math.log(2));
    }

    public void start() {
        if (registrationOpen)
            closeRegistration();
        for (int i = 0; i < numberOfRounds; i++) {
            System.out.println("**** ROUND " + i + " ****");
            ArrayList<Team> survivors = new ArrayList<Team>((int)(Math.pow(2, numberOfRounds-i)));
            for (Team team : teams)
                if (team.getLosses() == 0)
                    survivors.add(team);

            int numSurvivors = survivors.size();
            for (int j = 0; j < numSurvivors / 2; j++) {
                new Game(survivors.get(j), survivors.get(numSurvivors - (j+1))).play();
            }
            for (Team team : survivors)
                System.out.println(team);
        }
    }
}
