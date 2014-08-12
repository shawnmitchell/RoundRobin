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

        System.out.println(shawn + " vs " + lori);
        for (int i = 0; i < 20; i++) {
            Game game = null;
            if (i % 2 == 0)
                game = new Game(shawn, lori);
            else
                game = new Game(lori, shawn);
            game.play();
            Team winner = game.winner();
            System.out.println(winner.getName() + " " + game);
        }
   }
}
