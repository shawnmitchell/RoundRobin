package mitchell.shawn;

import java.util.ArrayList;

/**
 * Created by shawn on 8/12/14.
 */
public abstract class Tournament {
    protected ArrayList<Team> teams;
    protected boolean registrationOpen = true;

    public Tournament() {
        teams = new ArrayList<Team>();
    }

    public void registerTeam(Team t) {
        if (registrationOpen)
            teams.add(t);
        else
            throw new IllegalStateException("Attempt to register team after registration is closed");
    }

    public abstract void start();
}
