import java.util.Random;
public class Hivolts_Display {


	public static void main(String[] args) {

		showGUI();	

	}
	
	private static void showGUI(){

		Grid hivoltsgrid = new Grid(12);

		while(true){
			hivoltsgrid.drawAll();
		}		
	}
}
