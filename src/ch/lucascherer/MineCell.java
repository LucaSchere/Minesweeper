package ch.lucascherer;

public class MineCell extends Cell {

    public MineCell(Coordinate coordinate){
        this.setValue("\uD83D\uDCA3");
        this.setCoordinate(coordinate);
    }
    @Override
    public void onHit(){

    }
}