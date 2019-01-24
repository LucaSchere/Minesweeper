package ch.lucascherer;

public class Response {

    private Command command;
    private RequestStatus status;
    private Coordinate coordinate;
    private boolean answerIsYes;

    public  Response(Command command, Coordinate coordinate, RequestStatus status){
        this.command = command;
        this.coordinate = coordinate;
        this.status = status;

    }
    public Response(RequestStatus command){
        this.status = command;
    }
    public Response(boolean yes, RequestStatus status){
        this.status = status;
        this.answerIsYes = yes;
    }

    public Command getCommand() {
        return command;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public boolean isYes(){
        return answerIsYes;
    }

}
