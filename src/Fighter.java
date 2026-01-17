public interface Fighter {
    int WIZARD = 1;
    int OGRE = 2;
    int HYDRA = 3;
    int DEMON = 4;
    int DRAGON = 5;

    String getName();
    int getHealth();
    int getMaxHealth();
    int getAttack();
    int getDefense();
    int getClassType();
    void nextTurn();
    void applyPenalty();
    void applyDamage(int amount);
    void heal(int amount);
    boolean isAlive();
    int getActionBonus(ActionType action);
    int getDefenseBonus(ActionType action);
    double getCriticalChance(ActionType action);
    int getHealBonus(ActionType action);
}