package ch.lucascherer;

public class Game {

    private Field field;
    private View view;
    private InputRequester inputRequester;
    private static boolean gameOver = false;


    protected Game() {
        this.field = new Field();
        this.view = new View(this.field);
        this.inputRequester = new InputRequester();
        run();
    }

    private void run() {
        this.field.generate();
        while (!gameOver) {
            this.view.showField();
            queryCoords();
            if(gameOver){
                if(inputRequester.request(Request.RESTART).isYes()){
                    restart();
                    Cell.clear();
                    this.field.generate();
                }
            }
        }
    }

    private void queryCoords() {
        Response response = inputRequester.request(Request.COMMAND);
        if (response.getStatus() != RequestStatus.ERROR) {
            Cell cell = Cell.at(response.getCoordinate());
            Command command = response.getCommand();
            if (command == Command.MARK) {
                cell.onMark();
            } else if (command == Command.HIT) {
                cell.onHit();
            }
        }else {
            queryCoords();
        }
    }

    public static void stop() {
        gameOver = true;
    }

    public static void restart() {
        gameOver = false;
    }
}