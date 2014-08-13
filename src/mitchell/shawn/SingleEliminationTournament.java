package mitchell.shawn;


/**
 * Created by shawn on 8/12/14.
 */
public class SingleEliminationTournament extends Tournament {

    public void closeRegistration() {
        int entrants = teams.size();
        double total = Math.pow(2, Math.ceil(Math.log(entrants)/Math.log(2)));
        for (int i = entrants; i < total; i++)
            registerTeam(new Team("BYE", 0));
    }

    public void start() {

    }
}
