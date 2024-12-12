import java.util.ArrayList;
import java.util.Arrays;

public class Cell {
    private int value;
    private int row; // the full row this cell is a member of
    private int col; // the full column this cell is a member of
    private ArrayList<Integer> eligibleValues;
    private Grid parent;

    private Cell() {/* prevent uninitialized instances */}

    public ArrayList<Integer> getEligibleValues() { return eligibleValues; }

    public Cell(int row, int col, int value, Grid parent) {
        this.row = row;
        this.col = col;
        this.value = value; // NOTE: we accept values 0-9 during construction to allow zero to signify an empty cell.
        this.eligibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.parent = parent;
    }

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

    public boolean isEligibleToContain(int value) {
        //TODO: need more logic here to consider parent rows
        return eligibleValues.contains(value);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "value=" + value +
                ", row=" + row +
                ", col=" + col +
                ", eligibleValues=" + eligibleValues +
                ", parent=" + parent +
                '}';
    }
}
