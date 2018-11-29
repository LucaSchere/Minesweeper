package ch.lucascherer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties{

    private static final String PROPERTIES_FILE = "src\\ch\\lucascherer\\app.properties";
    private int fieldSize;
    private double rate;

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
        this.fieldSize = Integer.parseInt(this.getProperty("fieldSize"));
        this.rate = Double.parseDouble(this.getProperty("rate"));


    }
    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}