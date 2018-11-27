package ch.lucascherer;

public class ClearField extends Field {

    private int neighbourMines = 0;

    public ClearField(){
        this.setValue(Integer.toString(neighbourMines));
    }

    public void incrementValue(){
        this.neighbourMines += 1;
        this.setValue(Integer.toString(neighbourMines));
    }
    @Override
    public void onHit(){

    }
}