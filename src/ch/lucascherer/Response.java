package ch.lucascherer;

public class Response {

    private Command command;
    private Answer answer;
    private RequestStatus status;
    private Coordinate coordinate;

    public  Response(Command command, Coordinate coordinate, RequestStatus status){
        this.command = command;
        this.coordinate = coordinate;
        this.status = status;
    }
    public Response(RequestStatus command){
        this.status = command;
    }
    public Response(Answer answer, RequestStatus status){
        this.answer = answer;
        this.status = status;
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
    public Answer getAnswer() {
        return answer;
    }


}
