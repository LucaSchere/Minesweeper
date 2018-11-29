package ch.lucascherer;

import java.util.Random;

public class RandomCellPicker {

    private Random rand = new Random();
    private double rate;
    private Field field;

    public RandomCellPicker(double rate, Field field) {
        this.rate = rate;
        this.field = field;
    }

    public Cell randomCell(int x, int y) {
        if (rand.nextDouble() <= this.rate/100){
            MineCell mineCell = new MineCell(x, y);
            field.addMine(mineCell);
            return mineCell;
        }
        return new ClearCell(x, y);

    }

}
