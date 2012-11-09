import java.io.*;
import java.util.Random;
public class Hivolts_Display {


	public static void main(String[] args) {

		showGUI();	

	}
	
	private static void showGUI(){

		boolean win = false;
		int x=-1;
		int y=-1;
		Grid hivoltsgrid = new Grid(12);

		hivoltsgrid.drawAll();

		
		byte[] input = new byte[2];
		for(int i = 1; i < 11; i++){

			for(int j =1; j<11; j++){

				if(hivoltsgrid.whatsAt(i,j)!= null && hivoltsgrid.whatsAt(i,j).whoAmI()=='Y'){
					
					x=i;
					y=j;

				}
			}
		}

		while(true){
			try{
				System.in.available();
				
				System.in.read(input);

				if(input[0]!=0){


					switch(input[0]){
						case 'q':
//							System.out.println("NW");
							if(!willDie(hivoltsgrid,x-1,y-1)){
								hivoltsgrid.translateItem(x,y,x-1,y-1);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 'w':
//							System.out.println("N");
							if(!willDie(hivoltsgrid,x,y-1)){
								hivoltsgrid.translateItem(x,y,x,y-1);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 'e':
//							System.out.println("NE");
							if(!willDie(hivoltsgrid,x+1,y-1)){
								hivoltsgrid.translateItem(x,y,x+1,y-1);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 'a':
//							System.out.println("W");
							if(!willDie(hivoltsgrid,x-1,y)){
								hivoltsgrid.translateItem(x,y,x-1,y);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 's':
//							System.out.println("nop");
							break;
						case 'd':
//							System.out.println("E");
							if(!willDie(hivoltsgrid,x+1,y)){
								hivoltsgrid.translateItem(x,y,x+1,y);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 'z':
//							System.out.println("SW");
							if(!willDie(hivoltsgrid,x-1,y+1)){
								hivoltsgrid.translateItem(x,y,x-1,y+1);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 'x':
//							System.out.println("S");
							if(!willDie(hivoltsgrid,x,y+1)){
								hivoltsgrid.translateItem(x,y,x,y+1);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 'c':
//							System.out.println("SE");
							if(!willDie(hivoltsgrid,x+1,y+1)){
								hivoltsgrid.translateItem(x,y,x+1,y+1);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
						case 'j':
							int jumpval = jump(hivoltsgrid);
							hivoltsgrid.translateItem(x,y,jumpval/11,jumpval%11);
							if(!willDie(hivoltsgrid,jumpval/11,jumpval%11)){
								hivoltsgrid.translateItem(x,y,jumpval/11,jumpval%11);
							}else{
								hivoltsgrid.removeItem(x,y);
							}
							break;
					}
//					System.in.skip(System.in.available());
					
					if(input[0]!='j')
					hivoltsgrid.invokeMhos();

					x=-1;
					y=-1;

					for(int i = 1; i < 11; i++){

						for(int j =1; j<11; j++){

							if(hivoltsgrid.whatsAt(i,j)!= null && hivoltsgrid.whatsAt(i,j).whoAmI()=='Y'){
								
								x=i;
								y=j;

							}
						}
					}
					if(x!=-1&&y!=-1){
						hivoltsgrid.drawAll();
					}else{
						die();
					}
				win = true;
				for(int i = 1; i < 11; i++){

					for(int j =1; j<11; j++){

						if(hivoltsgrid.whatsAt(i,j)!= null && hivoltsgrid.whatsAt(i,j).whoAmI()=='M'){
							
							win = false;

						}
					}
				}
				if(win==true){
					win();
				}

				}			
			}catch(IOException e){
				System.out.println("error");
			}
		}
	}

	static int jump(Grid hg){
		
		Random randjump = new Random();
		boolean valid = false;
		int x = 0;
		int y = 0;
		while(!valid){
			x = randjump.nextInt(10)+1;
			y = randjump.nextInt(10)+1;
			if(hg.whatsAt(x,y) == null || hg.whatsAt(x,y).whoAmI() != 'F'){
				valid = true;
			}

		}
		return 11*x+y;
	}
	static boolean willDie(Grid hg, int x, int y){
		
		boolean dead = false;
		if(hg.whatsAt(x,y) != null){
			if(hg.whatsAt(x,y).whoAmI() == 'F' || hg.whatsAt(x,y).whoAmI() == 'M'){
				dead = true;
			}
		}

		return dead;
	}

	protected static void die(){
		Random randcolo = new Random();
		int esccode =0x1b;
		while(true){	

			
			System.out.print(String.format("%c[%dA", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dB", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dC", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dD", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dm", esccode, randcolo.nextInt(6)+40));
			System.out.print(String.format("%c[%dD", esccode, 1));//compensate for space`
			System.out.print(" ");
		}
	}

	protected static void win(){
		Random randcolo = new Random();
		int esccode =0x1b;
		while(true){	

			
			System.out.print(String.format("%c[%dA", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dB", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dC", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dD", esccode, randcolo.nextInt(8)));
			System.out.print(String.format("%c[%dm", esccode, randcolo.nextInt(6)+40));
			System.out.print(String.format("%c[%dD", esccode, 3));//compensate for space`
			System.out.print("WIN");
		}
	}
}
