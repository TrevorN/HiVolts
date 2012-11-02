import java.io.*;
public class Hivolts_Display {


	public static void main(String[] args) {

		showGUI();	

	}
	
	private static void showGUI(){

		Grid hivoltsgrid = new Grid(12);

		hivoltsgrid.drawAll();

		
		byte[] input = new byte[2];
		while(true){
			try{
				System.in.available();
				
				System.in.read(input);

				if(input[0]!=0){

					hivoltsgrid.drawAll();

//					System.in.skip(System.in.available());
					System.out.println(input[0]);

				}
			}catch(IOException e){
				System.out.println("error");
			}
		}
	}
}
