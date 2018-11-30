package ch.lucascherer;

public class Response {

    private Command command;
    private Coordinate coordinate;

    public  Response(Command command, Coordinate coordinate){
        this.command = command;
        this.coordinate = coordinate;
    }
    public Response(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
