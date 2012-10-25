import java.awt.*;
import java.util.Random;
public class Grid {

	private Item[][] these;

	private Random boardScrambler = new Random();
	private int size;
	public Grid(int t){
		size = t;

		these = new Item[t][t];
		
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				if(x == 0 || y == 0 || x+1 == size || y + 1 == size){

					these[x][y] = (Item) new Fence(this,x,y);
				}
			}
		}
	
		for(int i=0; i<12; i++){
			
			int x = boardScrambler.nextInt(size-2)+1;
			int y = boardScrambler.nextInt(size-2)+1;

			while(){
				
				if(points[(r-1)*10+s-1]==0){
					points[(r-1)*10+s-1] = 1;
				}

				r = boardScrambler.nextInt(size-2)+1;
				s = boardScrambler.nextInt(size-2)+1;
			}	

			these[r][s]= (Item) new Mho(this,r,s); 
			System.out.print(r);
			System.out.println("," + s);
		}
		
	}
	
	public void setItem(int x, int y, int x2, int y2){

//		these[x][y].setX(x2);
//		these[x][y].setY(y2);

		these[x2][y2]=these[x][y];
		these[x][y]=new Item(this, x, y);
	}


	public int getItemX(int x, int y){
		return these[x][y].getX();
	}
	public int getItemY(int x, int y){
		return these[x][y].getY();
	}


	public void moveItem(int x, int y){
		these[x][y].move();
	}
	
	public void drawAll(Graphics g){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				these[i][j].drawyoself(g);
			}
		}
	}
}
