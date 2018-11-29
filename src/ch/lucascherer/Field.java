package ch.lucascherer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Field {
	private Cell[][] cells;
	private List<MineCell> mines;
	private int fieldSize;
	private int rate;
	private Random rand = new Random();

	public Field(int fieldSize, int rate) {
		cells = new Cell[fieldSize][fieldSize];
		mines = new ArrayList<MineCell>();
		this.fieldSize = fieldSize;
		this.rate = rate;
		generate();
	}

	public Cell[][] getCells() {
		return this.cells;
	}

	public int getFieldsize() {
		return this.fieldSize;
	}

	public void generate() {
		for (int x = 0; x < this.fieldSize; x++) {
			for (int y = 0; y < fieldSize; y++) {
				this.cells[y][x] = randomField(this.rate, new Coordinate(x, y));
			}
		}
		updateNeighbours();
	}

	private Cell randomField(int rate, Coordinate coordinate) {

		int n = rand.nextInt(rate);
		if (n == 0) {
			MineCell mineCell = new MineCell(coordinate);
			this.mines.add(mineCell);
			return mineCell;
		}
		return new ClearCell(coordinate);

	}

	private void updateNeighbours() {
		for (MineCell mine : this.mines) {
			for (Coordinate neighbourCoordinates : this.getNeighbours(mine)) {
				 if (this.cells[neighbourCoordinates.getX()][neighbourCoordinates.getY()] instanceof ClearCell) { ClearCell
				 cell = (ClearCell) this.cells[neighbourCoordinates.getX()][neighbourCoordinates.getY()];
				 cell.incrementValue(); }
			}
		}
	}

	private List<Coordinate> getNeighbours(MineCell mine) {
		int mineX = mine.getCoordinate().getX();
		int mineY = mine.getCoordinate().getY();
		List<Coordinate> neighboursCoordinates = new ArrayList<Coordinate>();
		for (int x = mineX - 1; x < mineX + 2; x++) {
			for (int y = mineY - 1; y < mineY + 2; y++) {
				if (y >= 0 && x >= 0 && x <= 7 && y <= 7) {
					neighboursCoordinates.add(new Coordinate(x, y));
				}

			}
		}		
		// not working
		neighboursCoordinates.remove(4); //delete mineCell
		return neighboursCoordinates;
	}
}
