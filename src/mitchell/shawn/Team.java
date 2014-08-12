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

    @Override
    public int compareTo(Team that) {
        double diff = this.getSkillLevel() - that.getSkillLevel();
        return diff == 0 ? 0 : diff > 1 ? 1 : -1;
    }

    @Override
    public String toString() {
        return name + "[" + format.format(skillLevel) + "]";
    }
}
