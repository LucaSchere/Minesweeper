package ch.lucascherer;

public class Game {

    private Field field;
    private View view;
    private InputRequester inputRequester;

    private boolean gameOver = false;

    public Game(){
        this.field = new Field();
        this.view = new View(this.field);
        this.inputRequester = new InputRequester(this.field);
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
        Response response = inputRequester.request();
        Cell cell = Cell.at(response.getCoordinate());
        Command command = response.getCommand();
        if(command == Command.MARK){
            cell.onMark();
        }else if(command == Command.HIT){
            cell.onHit();
        }
    }
}