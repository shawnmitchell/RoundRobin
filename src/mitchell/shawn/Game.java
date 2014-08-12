package mitchell.shawn;

/**
 * Created by shawn on 8/12/14.
 */
public class Game {
    // we will give the home team an advantage
    private static double HomeTeamEdge = 1.1;

    private Team home;
    private Team away;
    private double homeTeamScore = 0;
    private double awayTeamScore = 0;

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

    public double getHomeTeamScore() {
        return homeTeamScore;
    }

    public double getAwayTeamScore() {
        return awayTeamScore;
    }

    // notice that in the event of a tie, the home team wins
    public Team play() {
        homeTeamScore = calculateHomeTeamScore();
        awayTeamScore = calculateAwayTeamScore();
        return homeTeamScore >= awayTeamScore ? home : away;
    }

    private double getRawScore() {
        return Math.random() * 10;
    }

    private double calculateHomeTeamScore() {
        return getTeamScore(home) * HomeTeamEdge;
    }

    private double calculateAwayTeamScore() {
        return getTeamScore(away);
    }

    private double getTeamScore(Team team) {
        return getRawScore() * team.getSkillLevel();
    }
}
