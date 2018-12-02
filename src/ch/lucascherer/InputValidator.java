package ch.lucascherer;

import ch.lucascherer.Exceptions.UnknownCommandException;
import ch.lucascherer.Exceptions.UnreachableCellException;
import ch.lucascherer.Exceptions.WrongFormatException;


public class InputValidator {


    public InputValidator() {
    }

    public Command validate(String[] s) throws WrongFormatException, UnreachableCellException, UnknownCommandException {
        int fieldSize = Config.getInstance().getFieldSize();
        if (s.length == 3 && isNumeric(s[1]) && isNumeric(s[2])) {
            int s1 = Integer.parseInt(s[1]);
            int s2 = Integer.parseInt(s[2]);
            if (s1 >= 0 && s1 < fieldSize&& s2 >= 0 && s2 < fieldSize) {


                if (s[0].toUpperCase().equals("M")) {
                    return Command.MARK;
                } else if (s[0].toUpperCase().equals("T")) {
                    return Command.HIT;
                } else {
                    throw new UnknownCommandException();
                }
            } else {
                throw new UnreachableCellException(fieldSize);
            }

        } else {
            throw new WrongFormatException(fieldSize);
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
