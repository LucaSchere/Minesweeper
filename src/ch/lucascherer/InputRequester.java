package ch.lucascherer;

import ch.lucascherer.Exceptions.UnknownCommandException;
import ch.lucascherer.Exceptions.UnreachableCellException;
import ch.lucascherer.Exceptions.WrongFormatException;

import java.util.Scanner;

public class InputRequester {

    private Scanner scanner;
    private InputValidator validator;

    public InputRequester(Field field) {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator(field);
    }

    public Response request() {
        System.out.println("Gib ein Kommando: ");
        String[] line = this.scanner.nextLine().split("");
        try{
            Command command = this.validator.validate(line);
            return new Response(command, Coordinate.of(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
        }catch (UnreachableCellException e){
            System.out.println(e.message);
            request();
        }catch (UnknownCommandException e){
            System.out.println(e.message);
            request();
        }catch (WrongFormatException e){
            System.out.println(e.message);
            request();
        }
        return new Response(Command.ERROR);
    }
}
