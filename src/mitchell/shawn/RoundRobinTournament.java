package mitchell.shawn;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by shawn on 8/12/14.
 */
public class RoundRobinTournament extends Tournament {

    public void closeRegistration() {
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
            closeRegistration();

        for (int i = 0; i < teams.size() - 1; i ++) {
            System.out.println("**** ROUND " + (i + 1) + " ****\n");
            for (Game game : makePairings())
                game.play();
            shiftPairings();
            for (Team team : teams)
                System.out.println(team);
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
