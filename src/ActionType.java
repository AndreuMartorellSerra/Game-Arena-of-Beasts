public enum ActionType {
    ATTACK,
    DEFENSE,
    MANEUVER,
    TRICK;

    public static ActionType fromLetter(char letter) {
        switch (letter) {
            case 'A': return ATTACK;
            case 'D': return DEFENSE;
            case 'M': return MANEUVER;
            case 'T': return TRICK;
            default: return null;
        }
    }
}