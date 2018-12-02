package ch.lucascherer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClearCell extends Cell {

    private int neighbourMines = 0;
    private List<Cell> alreadyClearedCells = new ArrayList<Cell>();

    public ClearCell(Coordinate coordinate) {
        this.setValue("0");
        this.setCoordinate(coordinate);
    }

    public void incrementValue() {
        this.neighbourMines += 1;
        this.setValue(Integer.toString(neighbourMines));
    }

    @Override
    public void onHit() {
        setHidden(false);
        if (this.getValue().equals("0")) {
            for (Cell cell : getNeighboursOfClearCell(Arrays.asList((Cell) this))) {
                cell.setHidden(false);
            }
        }

    }

    @Override
    public void onMark(){
        setMarked(true);
    }

    public List<Cell> getNeighboursOfClearCell(List<Cell> cells) {
        List<Cell> neighbours = new ArrayList<Cell>();
        for (Cell cell : cells) {
            int cellX = cell.getCoordinate().getX();
            int cellY = cell.getCoordinate().getY();
            for (int x = cellX - 1; x < cellX + 2; x++) {
                for (int y = cellY - 1; y < cellY + 2; y++) {
                    // if inside the field
                    if (y >= 0 && x >= 0 && x <= Config.getInstance().getFieldSize() - 1 && y <= Config.getInstance().getFieldSize() - 1) {
                        Cell neighbour = Cell.at(Coordinate.of(x, y));
                        // if right next to cell
                        if (cellX == x || cellY == y) {
                            if (cell instanceof ClearCell && cell.getValue().equals("0")) {
                                if (!isInAlreadyClearedCells(neighbour)) {
                                    alreadyClearedCells.add(neighbour);
                                    neighbours.add(neighbour);
                                }
                            }
                        }
                    }
                }
            }
            for (Cell neighbour : getNeighboursOfClearCell(neighbours)) {
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    public boolean isInAlreadyClearedCells(Cell cell) {
        for (Cell cell2 : alreadyClearedCells) {
            if (cell == cell2) {
                return true;
            }

        }
        return false;
    }
}