package ch.lucascherer;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Cell> cells;

    public Field(){
        cells = new ArrayList<Cell>();
    }

    public void addCell(Cell cell){
        this.cells.add(cell);
    }
}
