package ch.lucascherer.Exceptions;

public class UnreachableCellException extends Exception {

    private int fieldSize;
    public String message;
    public UnreachableCellException(int fieldSize){

        this.fieldSize = fieldSize - 1;
        this.message = "Deine Koordinaten treffen keine Zelle! Sie müssen zwischen 0 und " + this.fieldSize + " liegen!";
    }
}
