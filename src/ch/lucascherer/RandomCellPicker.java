package ch.lucascherer;

import java.util.List;
import java.util.Random;

public class RandomCellPicker {

    private Random rand = new Random();
    private double rate;

    public RandomCellPicker() {
        this.rate = Config.getInstance().getRate();
    }

    public Cell randomCell(Coordinate coordinate, List<Cell> cells) {
        if (rand.nextDouble() <= this.rate / 100) {
            MineCell mineCell = new MineCell(coordinate);
            cells.add(mineCell);
            return mineCell;
        }
        ClearCell clearCell = new ClearCell(coordinate);
        cells.add(clearCell);
        return clearCell;

    }

}
