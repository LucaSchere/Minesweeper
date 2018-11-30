package ch.lucascherer.Exceptions;

public class WrongFormatException extends Exception {

    private int fieldSize;
    public String message;
    public WrongFormatException(int fieldSize) {

        this.fieldSize = fieldSize - 1;
        this.message = "Dein Kommando sollte so aussehen: [M/T][0-" + this.fieldSize +"][0-" + this.fieldSize +"]";
    }
}
