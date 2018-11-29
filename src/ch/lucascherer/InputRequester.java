package ch.lucascherer;

import java.util.Scanner;

public class InputRequester {

    private Scanner scanner;
    private InputValidator validator;

    public InputRequester() {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator();
    }

    public String[] request() {
        System.out.println("Gib ein Kommando: ");
        String[] line = this.scanner.nextLine().split("");
        this.validator.validate(line);
        return line;

    }
}
