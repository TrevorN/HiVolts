import java.util.Random;
public class Grid {

	private Item[][] grid;

	private Mho[] mhos = new Mho[12];

	private Random randgen = new Random();

	private int size;

	char escCode = 0x1B;

	private Item defaultitem;

	public Grid(int t){

	 	defaultitem = (Item) new Item(this,-1,-1);	

		size = t;

		grid = new Item[size][size];
		
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				if(x == 0 || y == 0 || x+1 == size || y + 1 == size){

					grid[x][y] = new Fence(this,x,y);
			
				}
			}
		}
	
		for(int i = 0; i < 12; i ++){
			
			int x = randgen.nextInt(size - 2) + 1;
			int y = randgen.nextInt(size - 2) + 1;

			while(grid[x][y] != null){

				x = randgen.nextInt(size - 2) + 1;
				y = randgen.nextInt(size - 2) + 1;
			}	

			mhos[i] = new Mho(this,x,y);
			grid[x][y] = mhos[i]; 
		
		}

		for(int i = 0; i < 20; i++){

			int x = randgen.nextInt(size - 2) + 1;
			int y = randgen.nextInt(size - 2) + 1;

			while(grid[x][y] != null){
				x = randgen.nextInt(size - 2) + 1;
				y = randgen.nextInt(size - 2) + 1;
			}

			grid[x][y] = new Fence(this,x,y);
		}


		int x = randgen.nextInt(size - 2) + 1;
		int y = randgen.nextInt(size - 2) + 1;

		while(grid[x][y] != null){
			x = randgen.nextInt(size - 2) + 1;
			y = randgen.nextInt(size - 2) + 1;
		}

		grid[x][y] = new You(this,x,y);


		int back=12*6;
		int up=12*6;
		System.out.print(String.format("%c[%dD", escCode, back));
		System.out.print(String.format("%c[%dA", escCode, up));
		System.out.print(String.format("%c7", escCode));
	}
	
	public void invokeMhos(){
		for(Mho m : mhos)
		{
			if(m.alive())
			m.act();
		}
	}

	public boolean noMho(){
		for(Mho m : mhos)
		{
			if(m.alive())
			return false;
		}

		return true;
	}

	public Item whatsAt(int x, int y){

		return grid[x][y];

	}

	public void translateItem(int x, int y, int newX, int newY)
	{

		grid[newX][newY] = grid[x][y];
		grid[x][y] = null;
		grid[newX][newY].newLoc(newX, newY);

	}

	public void removeItem(int x, int y)
	{
		grid[x][y] = null;	
	}	
	
	public void drawAll(){
	

//		Runtime.getRuntime().exec("cls");

		System.out.print(String.format("%c8", escCode));
		System.out.print(String.format("%c[%dm",escCode,47));
//		int row = 0;
//		int column =0;
//		System.out.print(String.format("%c[%d;%df", escCode, row, column));
		for(int i = 0; i < size; i++){

			for(int j = 0; j < size; j++){

//				System.out.print(String.format("%c[%d,%dm",escCode,8,47));//randgen.nextInt(6)+40));

				if(grid[j][i] != null){
					grid[j][i].drawyoself();
				}else{
					defaultitem.drawyoself();
				}

			}
			System.out.print(String.format("%c[%dB", escCode, 6)); //move down
			System.out.print(String.format("%c[%dD", escCode, 12*12));// move left
//			System.out.println();

		}


	}
}
