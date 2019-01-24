package ch.lucascherer;

import java.util.List;
import java.util.Random;

/**
 * Der RandomCellPicker liest die Minenrate aus den Configs
 * und bestimmt, ob eine Mine oder eine leere Zelle zurück gegeben wird.
 * 
 * @author Luca Scherer
 */
public class RandomCellPicker {

    private Random rand = new Random();
    private double rate;

    /**
     * Im Konstruktor wird die Minenrate aus den Configs ausgelesen.
     */
    public RandomCellPicker() {
        this.rate = Config.getInstance().getRate();
    }

    /**
     * Gibt eine Mine oder eine leere Zelle zurück.
     * @param coordinate An dieser Koordinate wird die Zelle liegen.
     * @param cells Liste mit allen registrierten Zellen des Spielfeldes.
     * @return Entweder eine Mine oder eine leere Zelle.
     */
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
