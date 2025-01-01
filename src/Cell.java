import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class Cell {

    private static final ArrayList<Integer> fullListOfValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    private UUID uniqueID;
    private int value;
    private int row; // the full row this cell is a member of
    private int col; // the full column this cell is a member of
    private ArrayList<Integer> eligibleValues;
    private GameController gameController;

    private Cell() {/* prevent uninitialized instances */}

    public ArrayList<Integer> getEligibleValues() { return eligibleValues; }

    public Cell(int row, int col, int value, GameController gameController) {
        this.uniqueID = UUID.randomUUID();
        this.row = row;
        this.col = col;
        this.value = value;
        this.gameController = gameController;
        resetEligibleValues();
    }

    public UUID getUniqueID() { return uniqueID; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getValue() { return value; }

    public void setValue(int value) {
        // sanity check which only allows new values of 1-9.
        if (value < 1 || value > 9) {
        	throw new IllegalArgumentException("Value must be between 1 and 9");
        }
        if (!eligibleValues.contains(value)) {
        	throw new IllegalArgumentException(String.format("value %d is not in the list of eligble values for this cell: %s", value, eligibleValues));
        }
        // set the current value ...
        this.value = value;
        // ... and remove it from the list of eligible values.
        if (eligibleValues.contains(value)) {
            eligibleValues.remove(value);
        }
    }

    public void resetEligibleValues() {
        updateEligibleValues(fullListOfValues);
    }

    public void updateEligibleValues(ArrayList<Integer> values){
        if (eligibleValues == null) {
            eligibleValues = new ArrayList<>(values);
        } else {
            eligibleValues.clear();
            this.eligibleValues.addAll(values);
        }
    }

    @Override
    public String toString() {
        return MessageFormat.format("Cell'{'uniqueId={0}, value={1}, row={2}, col={3}, eligibleValues={4}'}'",
                uniqueID, value, row, col, eligibleValues);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cell)) return false;
        Cell that = (Cell) o;
        return this.uniqueID.equals(that.uniqueID);
    }
}
