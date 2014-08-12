package mitchell.shawn;

import java.text.DecimalFormat;

/**
 * Created by shawn on 8/12/14.
 */
public class Game {
    // we will give the home team an advantage
    private static double HomeTeamEdge = 1.1;
    private static String pattern = "###.###";
    private static DecimalFormat format = new DecimalFormat(pattern);

    private Team home;
    private Team away;
    private double homeTeamScore = 0;
    private double awayTeamScore = 0;
    private boolean homeTeamWon = false;
    private boolean gamePlayed = false;

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
    public void play() {
        homeTeamScore = calculateHomeTeamScore();
        awayTeamScore = calculateAwayTeamScore();
        homeTeamWon = homeTeamScore >= awayTeamScore;
        gamePlayed = true;
    }

    public Team winner() {
        if (! gamePlayed)
            throw new IllegalStateException("There is no winner until the game is played");
        return homeTeamWon ? home : away;
    }

    public boolean homeTeamWon() {
        return homeTeamWon;
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

    @Override
    public String toString() {
        if (gamePlayed)
            return results();
        else
            return players();
    }

    private String results() {
        if (! gamePlayed)
            throw new IllegalStateException("There are no results until the game is played");
        return home.getName() + "[Home] : " + format.format(homeTeamScore) + " " + away.getName() + " : " + format.format(awayTeamScore);
    }

    private String players() {
        return home.getName() + "[Home] vs " + away.getName();
    }
}
