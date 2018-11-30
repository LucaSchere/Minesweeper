package ch.lucascherer;


public class View {

    private Field field;
    private static final String divider = " ";

    public View(Field field){
        this.field = field;
    }
    
    public void showField() {
		printXAxis();
    	for(int y = 0; y < this.field.getFieldsize(); y++) {
			//print Y Axis
			System.out.print(y+"\t");
    		for(int x = 0; x < this.field.getFieldsize(); x++) {
    			Cell cell = Cell.at(Coordinate.of(x,y));
    			String value = cell.getOutput();
    			System.out.print(value);
    			System.out.print(divider);
    		}
    		System.out.println();
    	}
    }
    private void printXAxis(){
		System.out.print("\t");
		for (int y = 0; y < this.field.getFieldsize(); y++){
			System.out.print(y+ divider);
		}
		System.out.println();
		System.out.println();
	}
}
