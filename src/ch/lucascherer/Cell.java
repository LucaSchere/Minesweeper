package ch.lucascherer;

public abstract class Cell {

	private static final String DEFAULT_VALUE = "X";
	private boolean isHidden = true;
	private Coordinate coordinate;
	private String value = DEFAULT_VALUE;

	public String getValue() {
		//if (!isHidden()) {
			return this.value;
		//} else {
		//	return this.getDefaultValue();
		//}
	}

	public abstract void onHit();

	public String getDefaultValue() {
		return DEFAULT_VALUE;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean hidden) {
		isHidden = hidden;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
}