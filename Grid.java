import java.awt.*;
import java.util.Random;
public class Grid {

	private Item[][] grid;

	private Random boardScrambler = new Random();

	private int size;

	public Grid(int t){
		
		size = t;

		grid = new Item[size][size];
		
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				if(x == 0 || y == 0 || x+1 == size || y + 1 == size){

					grid[x][y] = (Item) new Fence(this,x,y);
			
				}
			}
		}
	
		for(int i = 0; i < 12; i ++){
			
			int x = boardScrambler.nextInt(size - 2) + 1;
			int y = boardScrambler.nextInt(size - 2) + 1;

			while(grid[x][y] != null){

				x = boardScrambler.nextInt(size - 2) + 1;
				y = boardScrambler.nextInt(size - 2) + 1;
			}	

			grid[x][y] = (Item) new Mho(this,x,y); 
			System.out.println(x + ", " + y);
		
		}	
	}
	
	public void addItem(Item toAdd, int x, int y){
		
		grid[x][y] = toAdd;
		drawAll();

	}

	public void actItem(int x, int y){
	
		grid[x][y].act();
		drawAll();

	}

	public Item whatsAt(int x, int y)
	{

		return grid[x][y];

	}
	
	private void drawAll(Graphics g){
	
		for(int i = 0; i < size; i++){

			for(int j = 0; j < size; j++){

				if(grid[i][j] != null){
					grid[i][j].drawyoself(g);
				}

			}

		}

	}
}
