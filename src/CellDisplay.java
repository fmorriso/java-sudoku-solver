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

    public void updateDisplay() {
        numbers = new ArrayList<Integer>();
        numbers.addAll(cell.getEligibleValues());
    }
}
