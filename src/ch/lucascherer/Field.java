package ch.lucascherer;

import java.util.ArrayList;

import java.util.List;


public class Field {
    private int fieldSize = Config.getInstance().getFieldSize();
        public void generate() {
        for (int y = 0; y < this.fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                Cell.at(Coordinate.of(x, y));
            }
        }
        updateNeighboursOfMine();
    }

    private void updateNeighboursOfMine() {
        for (Cell mine : Cell.getCells()) {
            if (mine instanceof MineCell) {
                for (Cell neighbour : getNeighboursOfMineCell((MineCell) mine)) {
                    if (neighbour instanceof ClearCell) {
                        ((ClearCell) neighbour).incrementValue();
                    }
                }
            }
        }
    }

    public List<Cell> getNeighboursOfMineCell(MineCell cell) {
        int cellX = cell.getCoordinate().getX();
        int cellY = cell.getCoordinate().getY();
        List<Cell> neighbours = new ArrayList<Cell>();
        for (int x = cellX - 1; x < cellX + 2; x++) {
            for (int y = cellY - 1; y < cellY + 2; y++) {
                // if inside the field
                if (y >= 0 && x >= 0 && x <= this.fieldSize - 1 && y <= this.fieldSize - 1) {
                    // if not the mine it-self
                    if (!(x == cellX && y == cellY)) {
                        neighbours.add(Cell.at(Coordinate.of(x, y)));
                    }
                }
            }
        }
        return neighbours;
    }



    public int getFieldsize() {
        return this.fieldSize;
    }

}
