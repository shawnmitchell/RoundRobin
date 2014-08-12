package mitchell.shawn;

public class Main {

    private static double GetRandomSkillLevel() {
        return Math.random() * 10;
    }

    public static void main(String[] args) {
	    // write your code here
        Team shawn = new Team("Shawn", GetRandomSkillLevel());
        Team lori = new Team("Lori", GetRandomSkillLevel());

        Tournament event = new Tournament();
        event.registerTeam(shawn);
        event.registerTeam(lori);
        event.cloaseRegistraion();

        Game game = new Game(shawn, lori);
        System.out.println(shawn.getName() + "[" + shawn.getSkillLevel() + "] vs " + lori.getName() + "[" + lori.getSkillLevel() + "]");
        for (int i = 0; i < 20; i++) {
            Team winner = game.play();
            System.out.println("The winner is... " + winner.getName() + " " + game.getHomeTeamScore() + " to " + game.getAwayTeamScore());
        }
   }
}
