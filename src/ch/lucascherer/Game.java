package ch.lucascherer;


import java.util.*;
import java.util.Random;

public class Game {

    private Properties config;
    private Field field;
    private View view;

    private Scanner scanner = new Scanner(System.in);

    public boolean gameOver = false;

    public Game(){
        this.config = new Config();
        this.field = new Field(Integer.parseInt(this.config.getProperty("fieldSize")),Integer.parseInt(this.config.getProperty("rate")));
        this.view = new View(this.field);
        run();
    }

    private void run(){
        this.field.generate();
        this.view.showField();

        while (!this.gameOver){
            clearScreen();
            queryCoords();
            this.view.showField();
        }

    }

    private void queryCoords(){
        System.out.println("Gib ein:");
        String line = this.scanner.nextLine();
        String[] params = line.split(" ");
        showField(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }

    private void showField(int y, int x){
        //Cell cell = (Cell) this.cells.get(Arrays.asList(y,x));
        //cell.setHidden(false);
    }

   
    public static void clearScreen() {
        System.out.flush();
    }
}