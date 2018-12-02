package ch.lucascherer;

public class MineCell extends Cell {

    public MineCell(Coordinate coordinate){
        this.setValue("B");
        this.setCoordinate(coordinate);
    }
    @Override
    public void onHit(){
        setHidden(false);
        System.out.println("Game Over!");
        Game.stop();
    }
    @Override
    public void onMark(){
        setMarked(true);
        if(Cell.allMinesMarked()){
            System.out.println("Du hast gewonnen!");
            Game.stop();
        }
    }
}