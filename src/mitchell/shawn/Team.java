package mitchell.shawn;

import java.text.DecimalFormat;

/**
 * Created by shawn on 8/12/14.
 */
public class Team implements Comparable<Team> {
    // skill level from 1 - 10
    private double skillLevel;
    private String name;
    private static String pattern = "###.###";
    private static DecimalFormat format = new DecimalFormat(pattern);
    private int wins = 0;
    private int losses = 0;

    public Team(String name, double skillLevel) {
        if (skillLevel > 10 || skillLevel < 0)
            throw new IllegalArgumentException("Skill Level must be between 0 and 10");
        this.skillLevel = skillLevel;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSkillLevel() {
        return skillLevel;
    }

    public void recordWin() {
        wins++;
    }

    public void recordLoss() {
        losses++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    @Override
    public int compareTo(Team that) {
        return Double.compare(skillLevel, that.getSkillLevel());
    }

    @Override
    public String toString() {
        return name + "[" + format.format(skillLevel) + "] (" + getWins() + " / " + getLosses() + ")";
    }
}
