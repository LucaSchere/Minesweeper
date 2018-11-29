package ch.lucascherer;

public class InputValidator {

    public InputValidator(){
    }

    public boolean validate(String[] s){
        if (s.length == 3){
            return true;
        }
        return false;
    }
}
