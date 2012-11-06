public class Mho extends Item{

	boolean alive = true;

	public Mho(Grid g, int x, int y){

		super(g,x,y);
		name = 'M';
		color = 4;
	
	}

	public void act(){

		int playerX = 0;
		int playerY = 0;

		//First, to find the players location.
		for(int x = 1; x < 11; x++)
		{
			boolean keepLooking = true;

			for(int y = 1; y < 11; y++)
			{
				if(safeWhoAmI(myGrid.whatsAt(x, y)) == 'Y')
				{
					keepLooking = false;
					playerX = x;
					playerY = y;
				}

				if(!keepLooking) break;
			}
		}

		boolean moved = false;

		//Is a direct move possible?
		if(playerX == myX)
		{
			if(myY < playerY){
				move(myX, myY + 1);
			} else {
				move(myX, myY - 1);
			}

			moved = true;

		} else if (playerY == myY) {
	
			if(myX < playerX){
				move(myX + 1, myY);
			} else {
				move(myX - 1, myY);
			}

			moved = true;
		}

		//Check if Diagonal is safe.
		if(!moved)
		{
			if(playerX > myX)
			{
				if(playerY > myY)
				{
					moved = attemptMove(int x + 1, int  y + 1);
				} else {
					moved = attemptMove(int x + 1, int y - 1);
				}
			} else {
				if(playerY > myY)
				{
					moved = attemptMove(int x - 1, int  y + 1);
				} else {
					moved = attemptMove(int x - 1, int y - 1);
				}
			}
		}
	}

	public boolean alive()
	{
		return alive;
	}

	public boolean attemptMove(int x, int y)
	{
		if(safeWhoAmI(myGrid.whatsAt(x, y)) != 'F' && safeWhoAmI(myGrid.whatsAt(x, y))
		{
			move(x, y);
			return true;
		}

		return false;
	}

	public char safeWhoAmI(Item i)
	{
		if(i == null)
		{
			return 'E';
		} else {
			i.whoAmI();
		}
	}

	private void move(int x, int y)
	{
		if(myGrid.whatsAt(x, y).whoAmI() == 'F')
		{
			alive = false;
			myGrid.removeItem(myX, myY);	
		} else if(myGrid.whatsAt(x, y).whoAmI() == 'Y') {
			System.exit(0);
		} else {
			myGrid.translateItem(myX, myY, x ,y);
		} 
	}


}
