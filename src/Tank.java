public class Tank extends BaseFighter {
    public Tank(String name, int classType, int health, int attack, int defense) {
        super(name, classType, health, attack, defense);
    }

    public int getActionBonus(ActionType action) {
        return action == ActionType.MANEUVER ? 1 : 0;
    }

    public int getDefenseBonus(ActionType action) {
        if (action == ActionType.DEFENSE) {
            return 4;
        }
        return action == ActionType.MANEUVER ? 2 : 0;
    }

    public double getCriticalChance(ActionType action) {
        return 0.07;
    }

    public int getHealBonus(ActionType action) {
        return action == ActionType.DEFENSE ? 2 : 0;
    }
}