
import java.awt.*;
import java.util.Random;
public class Grid {


	private Item[][] these;

	private Random boardscramble= new Random();
	private int size;
	public Grid(int t){
		size=t;

		these= new Item[t][t];
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(i==0||j==0||j+1==size||i+1==size){

					these[i][j]=(Item) new Fence(this,i,j);
				}else{
					
					these[i][j]=new Item(this,i,j);
				}

			}
		}
		int innerfence = size-2;
		int[] points = new int[innerfence*innerfence+1];
		for(int i=0;i<13; i++){
			
			int r = boardscramble.nextInt(innerfence)+1;
			int s = boardscramble.nextInt(innerfence)+1;

			do{
				r = boardscramble.nextInt(innerfence)+1;

				s = boardscramble.nextInt(innerfence)+1;
				if(points[(r-1)*10+s-1]==0){
					
					points[(r-1)*10+s-1]=1;
				}
			}while(points[(r-1)*10+s-1]==0)

			if(i==0){
				these[r][s]= (Item) new You(this,r,s); 
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
