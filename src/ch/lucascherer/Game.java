package ch.lucascherer;

import java.util.*;
import java.util.Random;

public class Game {

    private HashMap<List<Integer>, Field> cells = new HashMap<List<Integer>, Field>();
    private Random rand = new Random();
    private Properties config;

    public Game(){
        this.config = new Config();
        run(Integer.parseInt(this.config.getProperty("fieldSize")),
                Integer.parseInt(this.config.getProperty("rate")));
    }

    private void run( int fieldSize, int rate){
        buildField( fieldSize, rate);
        showField(fieldSize);
    }

    /**
     * builds the field
     */
    private void buildField(int fieldSize, int rate){
        for(int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                this.cells.put(Arrays.asList(i, j), randomField(rate));
            }
        }
    }

    /**
     * prints out the field
     */
    private void showField(int fieldSize){
        Iterator it = this.cells.entrySet().iterator();
        int i = 0;
        while (it.hasNext()){
            if (i % fieldSize == 0){
                System.out.println();
            }
            Map.Entry pair = (Map.Entry)it.next();
            try {
                Field field = (Field) pair.getValue();
                System.out.print(field.getValue() + "  ");
                it.remove();
                i++;
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }

        }
        System.out.println();
    }

    private Field randomField(int rate){
        int n = rand.nextInt(rate);
        if (n == 0) {
            return new MineField();
        }
        return new ClearField();

    }
}
