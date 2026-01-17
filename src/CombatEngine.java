public class CombatEngine {
    private final BotAI botAI = new BotAI();
    private final CombatLogger logger = new CombatLogger();

    public int runBattle(Fighter player, Fighter bot, ConsoleView view) {
        int turn = 1;
        while (player.isAlive() && bot.isAlive()) {
            logger.info("\n--- TURN " + turn + " ---");
            view.showBattle(player, bot);
            ActionType playerAction = view.askAction();
            ActionType botAction = botAI.chooseAction(bot, player);
            resolveTurn(player, bot, playerAction, botAction);
            player.nextTurn();
            bot.nextTurn();
            turn++;
        }
        return player.isAlive() ? 1 : 2;
    }

    private void resolveTurn(Fighter actor, Fighter target, ActionType actorAction, ActionType targetAction) {
        int actorDamage = computeDamage(actor, actorAction, target, targetAction);
        int targetDamage = computeDamage(target, targetAction, actor, actorAction);
        applyActionEffects(actor, actorAction);
        applyActionEffects(target, targetAction);
        if (actorDamage > 0) {
            target.applyDamage(actorDamage);
        }
        if (targetDamage > 0) {
            actor.applyDamage(targetDamage);
        }
        logger.action(actor.getName(), actorAction, actorDamage, actorDamage, actorDamage > 0 && actor.getCriticalChance(actorAction) > 0.18, actorDamage == 0 && actorAction == ActionType.ATTACK);
        logger.action(target.getName(), targetAction, targetDamage, targetDamage, targetDamage > 0 && target.getCriticalChance(targetAction) > 0.18, targetDamage == 0 && targetAction == ActionType.ATTACK);
    }

    private int computeDamage(Fighter actor, ActionType actorAction, Fighter target, ActionType targetAction) {
        if (actorAction == ActionType.DEFENSE) {
            return 0;
        }
        if (actorAction == ActionType.MANEUVER) {
            if (targetAction == ActionType.ATTACK && Math.random() < 0.4) {
                return 0;
            }
            return 0;
        }
        int actorRoll = roll(actor.getAttack() + actor.getActionBonus(actorAction));
        int targetRoll = roll(target.getDefense() + target.getDefenseBonus(targetAction));
        int damage = Math.max(0, actorRoll - targetRoll);
        if (actorAction == ActionType.TRICK && targetAction != ActionType.MANEUVER) {
            damage += 2;
        }
        if (Math.random() < actor.getCriticalChance(actorAction)) {
            damage += 2;
        }
        return damage;
    }

    private void applyActionEffects(Fighter actor, ActionType action) {
        if (action == ActionType.DEFENSE) {
            actor.heal(actor.getHealBonus(action));
        }
        if (action == ActionType.TRICK && Math.random() < 0.2) {
            actor.applyPenalty();
        }
    }

    private int roll(int points) {
        int total = 0;
        for (int i = 0; i < Math.max(1, points); i++) {
            if (Math.random() < 0.5) {
                total++;
            }
        }
        return total;
    }
}