package ch.lucascherer;

import java.util.ArrayList;

import java.util.List;


public class Field {
    private Cell[][] cells;
    private int fieldSize;
    private double rate;
    private List<MineCell> mines;
    private RandomCellPicker randomCellPicker;

    public Field(int fieldSize, double rate) {
        cells = new Cell[fieldSize][fieldSize];
        mines = new ArrayList<MineCell>();
        randomCellPicker = new RandomCellPicker(rate, this);
        this.fieldSize = fieldSize;
        this.rate = rate;
    }

    public void generate() {
        for (int x = 0; x < this.fieldSize; x++) {
            for (int y = 0; y < fieldSize; y++) {
                this.cells[x][y] = randomCellPicker.randomCell(x, y);
            }
        }
        updateNeighbours();
    }

    private void updateNeighbours() {
        for (MineCell mine : this.mines) {
            List<int[]> neighbours = this.getNeighbours(mine);
            for (int[] neighbourCoordinates : neighbours) {
                if (this.cells[neighbourCoordinates[0]][neighbourCoordinates[1]] instanceof ClearCell) {
                    ClearCell
                            cell = (ClearCell) this.cells[neighbourCoordinates[0]][neighbourCoordinates[1]];
                    cell.incrementValue();
                }
            }
        }
    }
    private List<int[]> getNeighbours(MineCell mine) {
        int mineX = mine.getX();
        int mineY = mine.getY();
        List<int[]> neighboursCoordinates = new ArrayList<int[]>();
        for (int x = mineX - 1; x < mineX + 2; x++) {
            for (int y = mineY - 1; y < mineY + 2; y++) {
                // if inside the field
                if (y >= 0 && x >= 0 && x <= this.fieldSize-1 && y <= this.fieldSize-1) {
                    // if not the mine it-self
                    if (!(x == mineX && y == mineY)) {
                        neighboursCoordinates.add(new int[]{x, y});
                    }
                }
            }
        }
        return neighboursCoordinates;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public int getFieldsize() {
        return this.fieldSize;
    }

    public void addMine(MineCell mine){
        this.mines.add(mine);
    }
}
