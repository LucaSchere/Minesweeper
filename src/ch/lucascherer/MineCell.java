package ch.lucascherer;

public class MineCell extends Cell {

    public MineCell(int x, int y){
        this.setValue("B");
        this.setX(x);
        this.setY(y);
    }
    @Override
    public void onHit(){

    }
}