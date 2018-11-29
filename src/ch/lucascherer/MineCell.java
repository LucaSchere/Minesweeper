package ch.lucascherer;

public class MineCell extends Cell {

    public MineCell(Coordinate coordinate){
        this.setValue("B");
        this.setCoordinate(coordinate);
    }
    @Override
    public void onHit(){

    }
}