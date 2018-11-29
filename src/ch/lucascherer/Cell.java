package ch.lucascherer;

public abstract class Cell {
//test

    private static final String DEFAULT_VALUE = "X";
    private boolean isHidden = true;
    public Coordinate coordinate;

    private String value = DEFAULT_VALUE;

    public String getValue() {
        if (!isHidden()) {
            return this.value;
        }else{
            return this.getDefaultValue();
        }
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
}