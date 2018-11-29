package ch.lucascherer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Field {
	private List<Cell> cells;
	private List<Coordinate> mines;
	private int fieldSize;
	private int rate;
	private Random rand = new Random();

	public Field(int fieldSize, int rate) {
		cells = new ArrayList<Cell>();
		mines = new ArrayList<Coordinate>();
		this.fieldSize = fieldSize;
		this.rate = rate;
	}

	public void addCell(Cell cell) {
		this.cells.add(cell);
	}

	public List<Cell> getCells() {
		return this.cells;
	}

	public int getFieldsize() {
		return this.fieldSize;
	}

	public void generate() {
		for (int x = 0; x < this.fieldSize; x++) {
			for (int y = 0; y < fieldSize; y++) {
				this.cells.add(randomField(this.rate, new Coordinate(x, y)));
			}
		}
		updateNeighbours();
	}

	private Cell randomField(int rate, Coordinate coordinate) {

		int n = rand.nextInt(rate);
		if (n == 0) {
			this.mines.add(coordinate);
			return new MineCell(coordinate);
		}
		return new ClearCell(coordinate);

	}

	private void updateNeighbours() {
		for (Coordinate mineCoordiate : this.mines) {
			for (List<Integer> neighbourCoordinates : this.getNeighbours(mineCoordiate.getX(), mineCoordiate.getY())) {
				/*
				 * if (this.cells.get(neighbourCoordinates) instanceof ClearCell) { ClearCell
				 * cell = (ClearCell) this.cells.get(neighbourCoordinates);
				 * cell.incrementValue(); }
				 */
			}
		}
	}

	private List<List<Integer>> getNeighbours(int mineX, int mineY) {
		List<Coordinate> neighboursCoordinates = new ArrayList<Coordinate>();
		for (int x = mineX - 1; x < mineX + 2; x++) {
			for (int y = mineY - 1; y < mineY + 2; y++) {
				if (y >= 0 && x >= 0) {
					neighboursCoordinates.add(new Coordinate(x, y));
				}

			}
		}
		// remove mine it-self
		neighbours.remove(Arrays.asList(i, j));
		return neighbours;
	}
}
