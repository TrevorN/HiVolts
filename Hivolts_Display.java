import java.io.*;
public class Hivolts_Display {


	public static void main(String[] args) {

		showGUI();	

	}
	
	private static void showGUI(){

		int x=0;
		int y=0;
		Grid hivoltsgrid = new Grid(12);

		hivoltsgrid.drawAll();

		
		byte[] input = new byte[2];
		while(true){
			try{
				System.in.available();
				
				System.in.read(input);

				if(input[0]!=0){

					for(int i = 1; i < 11; i++){

						for(int j =1; j<11; j++){

							if(hivoltsgrid.whatsAt(i,j)!= null && hivoltsgrid.whatsAt(i,j).whoAmI()=='Y'){
								
								x=i;
								y=j;

							}
						}
					}

					switch(input[0]){
						case 'q':
//							System.out.println("NW");
							hivoltsgrid.translateItem(x,y,x-1,y-1);
							break;
						case 'w':
//							System.out.println("N");
							hivoltsgrid.translateItem(x,y,x,y-1);
							break;
						case 'e':
//							System.out.println("NE");
							hivoltsgrid.translateItem(x,y,x+1,y-1);
							break;
						case 'a':
//							System.out.println("W");
							hivoltsgrid.translateItem(x,y,x-1,y);
							break;
						case 's':
//							System.out.println("nop");
							break;
						case 'd':
//							System.out.println("E");
							hivoltsgrid.translateItem(x,y,x+1,y);
							break;
						case 'z':
//							System.out.println("SW");
							hivoltsgrid.translateItem(x,y,x-1,y+1);
							break;
						case 'x':
//							System.out.println("S");
							hivoltsgrid.translateItem(x,y,x,y+1);
							break;
						case 'c':
//							System.out.println("SE");
							hivoltsgrid.translateItem(x,y,x+1,y+1);
							break;
					}
//					System.in.skip(System.in.available());
					
					hivoltsgrid.invokeMhos();

					hivoltsgrid.drawAll();

				}
			}catch(IOException e){
				System.out.println("error");
			}
		}
	}
}
