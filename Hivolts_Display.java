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

					switch(input[0]){
						case 'q':
							System.out.println("NW");
							break;
						case 'w':
							System.out.println("N");
							break;
						case 'e':
							System.out.println("NE");
							break;
						case 'a':
							System.out.println("W");
							break;
						case 's':
							System.out.println("nop");
							break;
						case 'd':
							System.out.println("E");
							break;
						case 'z':
							System.out.println("SW");
							break;
						case 'x':
							System.out.println("S");
							break;
						case 'c':
							System.out.println("SE");
							break;
					}
//					System.in.skip(System.in.available());

				}
			}catch(IOException e){
				System.out.println("error");
			}
		}
	}
}
