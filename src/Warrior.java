public class Warrior extends BaseFighter {
    public Warrior(String name, int classType, int health, int attack, int defense) {
        super(name, classType, health, attack, defense);
    }

    public int getActionBonus(ActionType action) {
        if (action == ActionType.ATTACK) {
            return 2;
        }
        if (action == ActionType.MANEUVER) {
            return 1;
        }
        return 0;
    }

    public int getDefenseBonus(ActionType action) {
        return action == ActionType.DEFENSE ? 2 : 0;
    }

    public double getCriticalChance(ActionType action) {
        return action == ActionType.ATTACK ? 0.18 : 0.09;
    }

    public int getHealBonus(ActionType action) {
        return 0;
    }
}