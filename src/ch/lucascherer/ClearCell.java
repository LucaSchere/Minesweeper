package ch.lucascherer;

public class ClearCell extends Cell {

    private int neighbourMines = 0;

    public ClearCell(int x, int y){
        this.setValue(Integer.toString(neighbourMines));
        this.setX(x);
        this.setY(y);
    }

    public void incrementValue(){
        this.neighbourMines += 1;
        this.setValue(Integer.toString(neighbourMines));
    }
    @Override
    public void onHit(){
        this.setHidden(false);
    }
}