# Java Sudoku

A simple implementation of the Sudoku game

## Tools Used

| Tool     |  Version |
| :------- | -------: |
| Java     | 23.0.1.0 |
| IntelliJ | 2024.3.1 |
| VSCode   |   1.96.2 |

## Change History

| Date       | Description                        |
|:-----------|:-----------------------------------|
| 2024-12-12 | Initial creation                   |
| 2024-12-30 | adjust grid sizes, colors, borders |
| 2024-12-31 | update access token                |
| 2025-01-02 | add method tracing capability      |


## References

- [Sudoku Rules](https://sudoku.com/sudoku-rules/)
- [Mastering Sudoku for Beginners](https://masteringsudoku.com/sudoku-rules-beginners/)
- [IntelliJ GUI Designer - Tutorial](https://www.jetbrains.com/help/idea/design-gui-using-swing.html)

## Developer Notes

### GridBagLayout and GridBagConstraints

GridBagConstraints allow you to set the following properties to control the layout of individual components:

- `gridx`: The column of the grid.
- `gridy`: The row of the grid.
- `gridwidth`: The number of columns a component spans.
- `gridheight`: The number of rows a component spans.
- `weightx, weighty`: How the extra space is distributed.
- `anchor`: How the component is aligned within its grid cell.
- `fill`: Determines how the component should resize within the grid cell.
