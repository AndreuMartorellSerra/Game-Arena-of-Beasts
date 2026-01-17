public class Mage extends BaseFighter {
    public Mage(String name, int classType, int health, int attack, int defense) {
        super(name, classType, health, attack, defense);
    }

    public int getActionBonus(ActionType action) {
        if (action == ActionType.TRICK) {
            return 3;
        }
        if (action == ActionType.ATTACK) {
            return 1;
        }
        return 0;
    }

    public int getDefenseBonus(ActionType action) {
        return action == ActionType.DEFENSE ? 1 : 0;
    }

    public double getCriticalChance(ActionType action) {
        return action == ActionType.TRICK ? 0.22 : 0.1;
    }

    public int getHealBonus(ActionType action) {
        return action == ActionType.DEFENSE ? 3 : 0;
    }
}