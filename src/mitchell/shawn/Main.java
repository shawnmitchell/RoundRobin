package mitchell.shawn;

public class Main {
    private static int NumberOfTeams = 20;

    private static double GetRandomSkillLevel() {
        return Math.random() * 10;
    }

    public static void main(String[] args) {
        RoundRobinTournament event = new RoundRobinTournament();

        for (int i = 0; i < NumberOfTeams; i++) {
            event.registerTeam(new Team("Team" + (i+1), GetRandomSkillLevel()));
        }
        event.closeRegistration();

        event.start();

        SingleEliminationTournament bracket = new SingleEliminationTournament();
        for (int i = 0; i < NumberOfTeams; i++)
            bracket.registerTeam(new Team("Team" + (i+1), GetRandomSkillLevel()));
        bracket.closeRegistration();
        bracket.start();
   }
}
