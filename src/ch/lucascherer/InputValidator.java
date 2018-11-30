package ch.lucascherer;

import ch.lucascherer.Exceptions.UnknownCommandException;
import ch.lucascherer.Exceptions.UnreachableCellException;
import ch.lucascherer.Exceptions.WrongFormatException;

import java.io.IOException;

public class InputValidator {

    private Field field;

    public InputValidator(Field field) {
        this.field = field;
    }

    public Command validate(String[] s) throws WrongFormatException, UnreachableCellException, UnknownCommandException {
        if (s.length == 3 && isNumeric(s[1]) && isNumeric(s[2])) {
            int s1 = Integer.parseInt(s[1]);
            int s2 = Integer.parseInt(s[2]);

            if (s1 >= 0 && s1 < this.field.getFieldsize() && s2 >= 0 && s2 < this.field.getFieldsize()) {


                if (s[0].toUpperCase().equals("M")) {
                    return Command.MARK;
                } else if (s[0].toUpperCase().equals("T")) {
                    return Command.HIT;
                } else {
                    throw new UnknownCommandException();
                }
            } else {
                throw new UnreachableCellException(this.field.getFieldsize());
            }

        } else {
            throw new WrongFormatException(this.field.getFieldsize());
        }
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
