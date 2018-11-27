package ch.lucascherer;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.*;
import java.util.Random;

public class Game {

    private HashMap<List<Integer>, Field> cells = new HashMap<List<Integer>, Field>();
    private List<Integer[]> mines = new ArrayList<Integer[]>();
    private Random rand = new Random();
    private Properties config;

    public Game(){
        this.config = new Config();
        run(Integer.parseInt(this.config.getProperty("fieldSize")),
                Integer.parseInt(this.config.getProperty("rate")));
    }

    private void run( int fieldSize, int rate){
        buildField( fieldSize, rate);
        updateNeighbours();
        /* TODO Loop with user-request
           TODO showField() every loop
        */
        showField(fieldSize);
    }

    /**
     * builds the field
     */
    private void buildField(int fieldSize, int rate){
        for(int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++) {
                this.cells.put(Arrays.asList(i, j), randomField(rate, i, j));
            }
        }
    }

    /**
     * prints out the field
     */
    private void showField(int fieldSize){
        for(int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                Field field = (Field) this.cells.get(Arrays.asList(i, j));
                System.out.print(field.getValue() + " ");
            }
            System.out.println();
        }
    }

    private Field randomField(int rate, int i, int j){

        int n = rand.nextInt(rate);
        if (n == 0) {
            this.mines.add(new Integer[]{i, j});
            return new MineField();
        }
        return new ClearField();

    }

    private void updateNeighbours(){
        for(Integer[] mineCoordiate : this.mines) {
            for (List<Integer> neighbourCoordinates : this.getNeighbours(mineCoordiate[0], mineCoordiate[1])) {
                if (this.cells.get(neighbourCoordinates) instanceof ClearField) {
                    ClearField field = (ClearField) this.cells.get(neighbourCoordinates);
                    field.incrementValue();
                }
            }
        }
    }
    private List<List<Integer>> getNeighbours(int i, int j){
        List<List<Integer>> neighbours = new ArrayList<List<Integer>>();
        for (int x = i -1; x < i + 2; x++){
            for(int y = j -1; y < j+ 2; y++){
                if(y >= 0 && x >= 0){
                    neighbours.add(Arrays.asList(x, y));
                }

            }
        }
        // remove mine it-self
        neighbours.remove(Arrays.asList(i, j));
        return neighbours;
    }
}