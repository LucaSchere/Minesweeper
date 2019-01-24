package ch.lucascherer;

/**
 * Die View gibt das Spielfeld auf der Kommandozeile aus.
 * 
 * @author Luca Scherer
 */
public class View {

    private Field field;
    private static final String divider = " ";

    /**
     * @param field Das Spielfeld mit allen Zellen.
     */
    public View(Field field){
        this.field = field;
    }
    
    /**
     * Das Spielfeld wird ausgegeben. Während dem Vorgang wird zuerst die X-
     * Achse ausgegeben. Danach folgt in jeder Zeile die Y-Koordinate und 
     * dessen Zellen.
     */
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
    /**
     * Ausgabe der X-Achse in Abhängigkeit der Spielfeldgrösse.
     */
    private void printXAxis(){
		System.out.print("\t");
		for (int y = 0; y < this.field.getFieldsize(); y++){
			System.out.print(y+ divider);
		}
		System.out.println();
		System.out.println();
	}
}
