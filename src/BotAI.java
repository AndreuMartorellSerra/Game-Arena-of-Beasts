public class BotAI {
    public ActionType chooseAction(Fighter bot, Fighter opponent) {
        double healthRatio = (double) bot.getHealth() / bot.getMaxHealth();
        if (healthRatio < 0.35) {
            return ActionType.DEFENSE;
        }
        if (opponent.getHealth() < opponent.getMaxHealth() * 0.25) {
            return ActionType.ATTACK;
        }
        if (bot.getAttack() > opponent.getDefense() && bot.getHealth() >= opponent.getHealth()) {
            return ActionType.ATTACK;
        }
        if (opponent.getAttack() > bot.getDefense()) {
            return ActionType.MANEUVER;
        }
        return Math.random() < 0.55 ? ActionType.ATTACK : ActionType.TRICK;
    }
}