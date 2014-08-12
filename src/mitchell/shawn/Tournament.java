package mitchell.shawn;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shawn on 8/12/14.
 */
public class Tournament {
    private ArrayList<Team> teams;
    private boolean registrationOpen = true;

    public Tournament() {
        teams = new ArrayList<Team>();
    }

    public void registerTeam(Team t) {
        if (registrationOpen)
            teams.add(t);
        else
            throw new IllegalStateException("Attempt to register team after registration is closed");
    }

    public void cloaseRegistraion() {
        if (teams.size() % 2 == 1)
            teams.add(new Team("dummy", 0));
        registrationOpen = false;
        sortTeamsBySkill();
    }

    private void sortTeamsBySkill() {
        Collections.sort(teams);
    }

    public void start() {
        if (registrationOpen)
            cloaseRegistraion();

        for (int i = 0; i < teams.size() - 1; i ++) {
            System.out.println("**** ROUND " + (i + 1) + " ****\n");
            for (Team team : teams)
                System.out.println(team);
            for (Game game : makePairings())
                game.play();
            shiftPairings();
        }
    }

    private void shiftPairings() {
        for (int i = 0; i < teams.size() -1; i++)
            teams.add(teams.remove(teams.size()-2));
    }

    private ArrayList<Game> makePairings() {
        ArrayList<Game> games = new ArrayList<Game>(teams.size() / 2);
        for (int i = 0; i < teams.size() / 2; i++)
            games.add(new Game(teams.get(i), teams.get(teams.size() - (i + 1))));
        return games;
    }

}
