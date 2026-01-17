public class CombatLogger {
    public void info(String message) {
        System.out.println(message);
    }

    public void action(String actor, ActionType action, int roll, int damage, boolean critical, boolean missed) {
        String note = missed ? " missed" : critical ? " critical" : "";
        System.out.printf("%s uses %s%s and deals %d damage%n", actor, action, note, damage);
    }

    public void summary(String message) {
        System.out.println(message);
    }
}