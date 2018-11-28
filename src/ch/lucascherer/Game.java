package ch.lucascherer;


import java.util.*;
import java.util.Random;

public class Game {

    private HashMap<List<Integer>, Cell> cells = new HashMap<List<Integer>, Cell>();
    private List<Integer[]> mines = new ArrayList<Integer[]>();
    private Random rand = new Random();
    private Properties config;
    private Field field;
    private View view;

    private Scanner scanner = new Scanner(System.in);

    public boolean gameOver = false;

    public Game(){
        this.config = new Config();
        this.field = new Field();
        this.view = new View(this.field);
        run(Integer.parseInt(this.config.getProperty("fieldSize")),
                Integer.parseInt(this.config.getProperty("rate")));
    }

    private void run( int fieldSize, int rate){
        buildField( fieldSize, rate);

        while (!this.gameOver){
            clearScreen();
            queryCoords();
            showField(fieldSize);
        }

    }

    private void queryCoords(){
        System.out.println("Gib ein:");
        String line = this.scanner.nextLine();
        String[] params = line.split(" ");
        showField(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }

    private void showField(int y, int x){
        Cell cell = (Cell) this.cells.get(Arrays.asList(y,x));
        cell.setHidden(false);
    }

    /**
     * builds the field
     */
    private void buildField(int fieldSize, int rate){
        for(int x = 0; x < fieldSize; x++){
            for(int y = 0; y < fieldSize; y++) {
                this.cells.put(Arrays.asList(x, y), randomField(rate, new Coordinate(x, y)));
            }
        }
        updateNeighbours();
        showField(fieldSize);
    }

    /**
     * prints out the field
     */
    private void showField(int fieldSize){
        System.out.println();
        for(int i = 0; i < fieldSize; i++){
            for(int j = 0; j < fieldSize; j++){
                Cell cell = (Cell) this.cells.get(Arrays.asList(i, j));
                System.out.print(cell.getValue() + "\t");
            }
            System.out.println();
        }
    }

    private Cell randomField(int rate, Coordinate coordinate){

        int n = rand.nextInt(rate);
        if (n == 0) {
            //this.mines.add(new Integer[]{i, j});
            return new MineCell(coordinate);
        }
        return new ClearCell(coordinate);

    }

    private void updateNeighbours(){
        for(Integer[] mineCoordiate : this.mines) {
            for (List<Integer> neighbourCoordinates : this.getNeighbours(mineCoordiate[0], mineCoordiate[1])) {
                if (this.cells.get(neighbourCoordinates) instanceof ClearCell) {
                    ClearCell cell = (ClearCell) this.cells.get(neighbourCoordinates);
                    cell.incrementValue();
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
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}