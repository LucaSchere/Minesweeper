package ch.lucascherer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties{

    private static final String PROPERTIES_FILE = "src\\ch\\lucascherer\\app.properties";

    public Config(){

        InputStream input = null;
        try {
            input = new FileInputStream(PROPERTIES_FILE);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.load(input);
        }catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
