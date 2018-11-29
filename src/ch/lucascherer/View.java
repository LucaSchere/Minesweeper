package ch.lucascherer;


public class View {

    private Field field;

    public View(Field field){
        this.field = field;
    }
    
    public void showField() {
    	Cell[][] cells = this.field.getCells();
    	for(int i = 0; i < this.field.getFieldsize(); i++) {
    		for(int j = 0; j < this.field.getFieldsize(); j++) {
    			System.out.print(cells[i][j].getValue());
    		}
    		System.out.println();
    	}
   
    }
}
