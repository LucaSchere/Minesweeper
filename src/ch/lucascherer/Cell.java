package ch.lucascherer;

import java.util.ArrayList;
import java.util.List;

public abstract class Cell {

    private final static String hiddenValue = " ";
    private final static String markedValue = "!";
    private boolean isHidden = true;
    private boolean isMarked = false;
    private Coordinate coordinate;
    private String value = hiddenValue;
    private static RandomCellPicker randomCellPicker = new RandomCellPicker();
    private static List<Cell> cells = new ArrayList<Cell>();

    public static Cell at(Coordinate coordinate) {
        for (Cell cell : cells) {
            if (cell.getCoordinate().getX() == coordinate.getX() && cell.getCoordinate().getY() == coordinate.getY()) {
                return cell;
            }
        }
        return randomCellPicker.randomCell(coordinate, cells);
    }

    public static void clear() {
        cells.clear();
    }

    public static boolean allMinesMarked() {
        int i = 0;
        int o = 0;
        for (Cell cell : cells) {
            if (cell instanceof MineCell) {
                o++;
                if (cell.isMarked()) i++;
            }
        }
        return i == o;
    }

    public abstract void onHit();

    public abstract void onMark();

    public String getOutput() {
        if (isHidden()) {
            if (isMarked()) {
                return markedValue;
            }
            return hiddenValue;
        } else {
            return value;
        }
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }


    public boolean isMarked() {
        return isMarked;
    }

    public void setMarked(boolean marked) {
        isMarked = marked;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static List<Cell> getCells() {
        return cells;
    }


}