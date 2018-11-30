package ch.lucascherer;

import java.util.ArrayList;
import java.util.List;

public class ClearCell extends Cell {

    private int neighbourMines = 0;

    public ClearCell(Coordinate coordinate){
        this.setValue("0");
        this.setCoordinate(coordinate);
    }

    public void incrementValue(){
        this.neighbourMines += 1;
        this.setValue(Integer.toString(neighbourMines));
    }
    @Override
    public void onHit(){
        this.setHidden(false);

    }
    public List<Cell> getNeighboursOfClearCell(List<Cell> cells){
        List<Cell> neighbours = new ArrayList<Cell>();
        for(Cell cell : cells){
            int cellX = cell.getCoordinate().getX();
            int cellY = cell.getCoordinate().getY();
            for (int x = cellX - 1; x < cellX + 2; x++) {
                for (int y = cellY - 1; y < cellY + 2; y++) {
                    // if inside the field
                    if (y >= 0 && x >= 0 && x <= Config.getInstance().getFieldSize() - 1 && y <= Config.getInstance().getFieldSize() - 1) {
                        // if not the mine it-self
                        if (!(x == cellX && y == cellY)) {
                            neighbours.add(Cell.at(Coordinate.of(x, y)));
                        }
                    }
                }
            }
            for(Cell neighbour : getNeighboursOfClearCell(neighbours)){
                neighbours.add(neighbour);
            }

        }
        return neighbours;
    }
}