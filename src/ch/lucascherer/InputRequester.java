package ch.lucascherer;

import ch.lucascherer.Exceptions.UnknownCommandException;
import ch.lucascherer.Exceptions.UnreachableCellException;
import ch.lucascherer.Exceptions.WrongFormatException;

import java.util.Scanner;

public class InputRequester {

    private Scanner scanner;
    private InputValidator validator;

    public InputRequester() {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator();
    }

    public Response request(Request request) {
        if (request == Request.COMMAND){
            return requestCommand();
        }else if(request == Request.RESTART){
            return requestRestart();
        }
        return new Response(RequestStatus.ERROR);
    }
    private Response requestCommand(){

        System.out.println("Gib ein Kommando: ");
        String[] line = this.scanner.nextLine().split("");
        try{
            Command command = this.validator.validate(line);
            return new Response(command, Coordinate.of(Integer.parseInt(line[1]), Integer.parseInt(line[2])), RequestStatus.SUCCES);
        }catch (UnreachableCellException e){
            System.out.println(e.message);

        }catch (UnknownCommandException e){
            System.out.println(e.message);

        }catch (WrongFormatException e){
            System.out.println(e.message);

        }
        return new Response(RequestStatus.ERROR);
    }

    private Response requestRestart(){
        System.out.println("Neustarten? (J/N)");
        String answer = this.scanner.nextLine();
        if(answer.toUpperCase().equals("J")){
            return new Response(Answer.YES, RequestStatus.SUCCES);
        }
        return new Response(Answer.NO, RequestStatus.SUCCES);
    }
}
