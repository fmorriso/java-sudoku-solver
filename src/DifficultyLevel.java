public enum DifficultyLevel {
    EASY(0b0000, "Easy"),
    MEDIUM(0b0001, "Medium"),
    HARD(0b0010, "HARD"),
    EVIL(0b0100, "EVIL");

    private final int value;
    private final String description;

    public int getValue() {return value;}
    public String getDescription() {return description;}

    DifficultyLevel(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
