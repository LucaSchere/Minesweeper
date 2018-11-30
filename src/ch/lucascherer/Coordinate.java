package ch.lucascherer;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {

    private static List<Coordinate> coordinateList = new ArrayList<Coordinate>();
    private int x;
    private int y;

    private Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        coordinateList.add(this);
    }

    public static Coordinate of(int x, int y){
        for(Coordinate coordinate : coordinateList){
            if(coordinate.getX() == x && y == coordinate.getY()){
                return coordinate;
            }
        }
        return new Coordinate(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
