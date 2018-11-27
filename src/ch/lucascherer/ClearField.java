package ch.lucascherer;

public class ClearField extends Field {

    private int neighbourMines = '0';

    @Override
    public void onClick(){

    }
    @Override
    public Character getValue(){
        return ( char ) this.neighbourMines;
    }
    public void incrementValue(){
        this.neighbourMines += 1;
    }
}