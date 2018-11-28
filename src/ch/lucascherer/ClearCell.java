package ch.lucascherer;

public class ClearCell extends Cell {

    private int neighbourMines = 0;

    public ClearCell(Coordinate coordinate){
        this.setValue(Integer.toString(neighbourMines));
        this.coordinate = coordinate;
    }

    public void incrementValue(){
        this.neighbourMines += 1;
        this.setValue(Integer.toString(neighbourMines));
    }
    @Override
    public void onHit(){

    }
}