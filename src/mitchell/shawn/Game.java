package mitchell.shawn;

/**
 * Created by shawn on 8/12/14.
 */
public class Game {
    // we will give the home team an advantage
    private static double HomeTeamEdge = 1.1;

    private Team home;
    private Team away;

    public Game(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    // notice that in the event of a tie, the home team wins
    public Team play() {
        double homeTeamScore = getHomeTeamScore();
        double awayTeamScore = getAwayTeamScore();
        return homeTeamScore >= awayTeamScore ? home : away;
    }

    private double getRawScore() {
        return Math.random() * 10;
    }

    private double getHomeTeamScore() {
        return getTeamScore(home) * HomeTeamEdge;
    }

    private double getAwayTeamScore() {
        return getTeamScore(away);
    }

    private double getTeamScore(Team team) {
        return getRawScore() * team.getSkillLevel();
    }
}
