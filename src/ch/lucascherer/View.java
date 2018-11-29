package ch.lucascherer;

import java.util.Arrays;

public class View {

    private Field field;

    public View(Field field){
        this.field = field;
    }
    
    public void showField() {
    	int i = 0;
    	System.out.println();
        for(Cell cell : this.field.getCells()){
        	if(i % this.field.getFieldsize() == 0) System.out.println();
            System.out.print(cell.getValue());
            i++;
        }
    }
}
