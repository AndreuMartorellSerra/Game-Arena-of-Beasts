public abstract class BaseFighter implements Fighter {
    protected final String name;
    protected final int classType;
    protected final int maxHealth;
    protected final int baseAttack;
    protected final int baseDefense;
    protected int health;
    protected int attack;
    protected int defense;
    protected int turn;
    protected int recoveryTurn;

    protected BaseFighter(String name, int classType, int health, int attack, int defense) {
        this.name = name;
        this.classType = classType;
        this.maxHealth = health;
        this.health = health;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.attack = attack;
        this.defense = defense;
        this.turn = 1;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getClassType() {
        return classType;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void nextTurn() {
        turn++;
        if (turn == recoveryTurn) {
            attack = baseAttack;
            defense = baseDefense;
        }
    }

    public void applyPenalty() {
        if (Math.random() < 0.5) {
            defense = Math.max(1, defense / 2);
        } else {
            attack = Math.max(1, attack / 2);
        }
        recoveryTurn = turn + 2;
    }

    public void applyDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getActionBonus(ActionType action) {
        return 0;
    }

    public int getDefenseBonus(ActionType action) {
        return 0;
    }

    public double getCriticalChance(ActionType action) {
        return 0.08;
    }

    public int getHealBonus(ActionType action) {
        return 0;
    }
}