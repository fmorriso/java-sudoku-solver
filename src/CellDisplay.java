import javax.swing.JSpinner;
import java.util.ArrayList;
import java.util.List;

public class CellDisplay extends JSpinner {
    private Cell cell;
    private List<Integer> numbers;

    private CellDisplay(){/* prevent uninitialized instances */}
    public CellDisplay(Cell cell) {
        this.cell = cell;
        // ask the cell for eligible numbers to display
        this.numbers = new ArrayList<Integer>();
        this.updateDisplay();
    }

    /**
     * Update the spinner with the list of eligible values to take the guess work
     * out of selecting a value for this cell.
     * We assume the Game Controller will make sure the other objects perform their
     * duties to make sure that when this method asks for the eligible values,
     * they have already been set and validated.
     */
    public void updateDisplay() {
        numbers.clear();
        numbers.addAll(cell.getEligibleValues());
    }
}
