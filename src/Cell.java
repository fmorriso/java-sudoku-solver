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
    private Grid parent;

    private Cell() {/* prevent uninitialized instances */}

    public ArrayList<Integer> getEligibleValues() { return eligibleValues; }

    public Cell(int row, int col, int value, Grid parent) {
        this.uniqueID = UUID.randomUUID();
        this.row = row;
        this.col = col;
        this.value = value;
        resetEligibleValues();
        this.parent = parent;
    }

    public UUID getUniqueID() { return uniqueID; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getValue() { return value; }

    public void setValue(int value) {
        // sanity check which only allows new values of 1-9.
        if (value < 1 || value > 9) {throw new IllegalArgumentException("Value must be between 1 and 9");}
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
        this.eligibleValues.clear();
        this.eligibleValues.addAll(values);
    }

    public boolean isEligibleToContain(int value) {
        //TODO: need more logic here to consider parent rows, parent columns and sibling cells
        return eligibleValues.contains(value);
    }

    @Override
    public String toString() {
        return MessageFormat.format("Cell'{' uniqueId={0}, value={1}, row={2}, col={3}, eligibleValues={4}'}'",
                uniqueID, value, row, col, eligibleValues);
    }
}
