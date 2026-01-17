import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);
    private final Screen screen;

    public ConsoleView() {
        this(new ConsoleScreenRenderer());
    }

    public ConsoleView(Screen screen) {
        this.screen = screen;
    }

    public String askPlayerName() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        return name.isEmpty() ? "Player" : name;
    }

    public int askFighterChoice() {
        int option = 0;
        while (option < 1 || option > 5) {
            System.out.println("Choose your fighter:");
            System.out.println("1 - Wizard");
            System.out.println("2 - Ogre");
            System.out.println("3 - Hydra");
            System.out.println("4 - Demon");
            System.out.println("5 - Dragon");
            System.out.print("> ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                option = 0;
            }
        }
        return option;
    }

    public ActionType askAction() {
        ActionType action = null;
        while (action == null) {
            System.out.println("Choose strategy: (A/D/T/M)");
            String line = scanner.nextLine().trim().toUpperCase();
            if (line.isEmpty()) {
                continue;
            }
            action = ActionType.fromLetter(line.charAt(0));
        }
        return action;
    }

    public void display(String line) {
        System.out.println(line);
    }

    public void showBattle(Fighter player, Fighter bot) {
        screen.clear();
        screen.drawVerticalLine(0, 70, 15);
        int player1Col = 40;
        int player2Col = 110;
        screen.drawGraphics(Graphics.getGraphics(player.getClassType()), 0, 5);
        screen.drawText("Name: " + player.getName(), 5, player1Col);
        screen.drawText("Life: " + player.getHealth() + " / " + player.getMaxHealth(), 6, player1Col);
        screen.drawText("Attack: " + player.getAttack(), 7, player1Col);
        screen.drawText("Defense: " + player.getDefense(), 8, player1Col);
        screen.drawGraphics(Graphics.getGraphics(bot.getClassType()), 0, 80);
        screen.drawText("Name: " + bot.getName(), 5, player2Col);
        screen.drawText("Life: " + bot.getHealth() + " / " + bot.getMaxHealth(), 6, player2Col);
        screen.drawText("Attack: " + bot.getAttack(), 7, player2Col);
        screen.drawText("Defense: " + bot.getDefense(), 8, player2Col);
        screen.render();
    }
}