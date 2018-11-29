package ch.lucascherer;

import java.io.IOException;
import java.util.*;

public class Game {

    private Config config;
    private Field field;
    private View view;
    private InputRequester inputRequester;

    private boolean gameOver = false;

    public Game(Config config){
        this.config = config;
        this.field = new Field(this.config.getFieldSize(), this.config.getRate());
        this.view = new View(this.field);
        this.inputRequester = new InputRequester();
        run();
    }

    private void run(){
        this.field.generate();
        while (!this.gameOver){
            queryCoords();
            this.view.showField();
        }

    }

    private void queryCoords(){
        String[] params = inputRequester.request();
        Cell cell = this.field.getCells()[Integer.parseInt(params[0])][Integer.parseInt(params[1])];
        cell.onHit();
    }
}