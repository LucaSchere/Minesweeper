package ch.lucascherer;

public abstract class Cell {

	private static final String DEFAULT_VALUE = " ";
	private boolean isHidden = true;
    private int x;
	private int y;
	private String value = DEFAULT_VALUE;

	public String getValue() {
		if (!isHidden()) {
			return this.value;
		} else {
			return this.getDefaultValue();
		}
	}

	public abstract void onHit();

	public void onMark(){
	    this.setValue("!");
    }

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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}