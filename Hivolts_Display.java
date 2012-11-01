import java.io.*;
public class Hivolts_Display {


	public static void main(String[] args) {

		showGUI();	

	}
	
	private static void showGUI(){

		Grid hivoltsgrid = new Grid(12);

		hivoltsgrid.drawAll();

		byte[] input = new byte[1];
		while(true){
			try{
				System.in.available();
				
				System.in.read(input);

				if(input[0]){

					hivoltsgrid.drawAll();

				}
			}catch(IOException e){
				System.out.println("error");
			}
		}
	}
}
