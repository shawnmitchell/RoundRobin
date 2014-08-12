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
        // event.registerTeam(new Team("nora", GetRandomSkillLevel()));
   }
}
