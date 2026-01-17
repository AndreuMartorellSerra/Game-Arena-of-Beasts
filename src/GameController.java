public class GameController {
    private final ConsoleView view = new ConsoleView();
    private final CombatEngine engine = new CombatEngine();

    public void start() {
        String playerName = view.askPlayerName();
        Stats[] stats = loadStats();
        int playerWins = 0;
        int botWins = 0;
        int round = 1;
        while (playerWins < 2 && botWins < 2) {
            view.display("\n========== COMBAT " + round + " ==========");
            int playerChoice = view.askFighterChoice();
            int botChoice = (int) (Math.random() * 5) + 1;
            Fighter player = createFighter(playerName + " (" + className(playerChoice) + ")", stats[playerChoice - 1], playerChoice);
            Fighter bot = createFighter("Bot (" + className(botChoice) + ")", stats[botChoice - 1], botChoice);
            int winner = engine.runBattle(player, bot, view);
            if (winner == 1) {
                playerWins++;
                view.display("🏆 Wins " + player.getName() + " the combat!");
            } else {
                botWins++;
                view.display("💀 Wins " + bot.getName() + " the combat!");
            }
            round++;
        }
        view.display("\n=================================");
        view.display(playerWins > botWins ? "🏆 FINAL WINNER: " + playerName : "💀 FINAL WINNER: BOT");
    }

    private Stats[] loadStats() {
        Stats[] stats = new Stats[5];
        stats[Fighter.WIZARD - 1] = new Stats(30, 13, 9);
        stats[Fighter.OGRE - 1] = new Stats(41, 11, 1);
        stats[Fighter.HYDRA - 1] = new Stats(32, 11, 10);
        stats[Fighter.DEMON - 1] = new Stats(34, 12, 6);
        stats[Fighter.DRAGON - 1] = new Stats(25, 14, 13);
        return stats;
    }

    private Fighter createFighter(String name, Stats stats, int classType) {
        switch (classType) {
            case Fighter.WIZARD:
                return new Mage(name, classType, stats.getLife(), stats.getAttack(), stats.getDefense());
            case Fighter.OGRE:
                return new Tank(name, classType, stats.getLife(), stats.getAttack(), stats.getDefense());
            case Fighter.HYDRA:
                return new Warrior(name, classType, stats.getLife(), stats.getAttack(), stats.getDefense());
            case Fighter.DEMON:
                return new Warrior(name, classType, stats.getLife(), stats.getAttack(), stats.getDefense());
            case Fighter.DRAGON:
                return new Mage(name, classType, stats.getLife(), stats.getAttack(), stats.getDefense());
            default:
                return new Warrior(name, classType, stats.getLife(), stats.getAttack(), stats.getDefense());
        }
    }

    private String className(int classType) {
        switch (classType) {
            case Fighter.WIZARD:
                return "Wizard";
            case Fighter.OGRE:
                return "Ogre";
            case Fighter.HYDRA:
                return "Hydra";
            case Fighter.DEMON:
                return "Demon";
            case Fighter.DRAGON:
                return "Dragon";
            default:
                return "Unknown";
        }
    }
}