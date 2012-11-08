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
				attemptMove(myX, myY + 1, false);
			} else {
				attemptMove(myX, myY - 1, false);
			}

			moved = true;

		} else if (playerY == myY) {
	
			if(myX < playerX){
				attemptMove(myX + 1, myY, false);
			} else {
				attemptMove(myX - 1, myY, false);
			}

			moved = true;
		}

		boolean checkFences = true;

		//Check if Diagonal is safe.
		for(int i = 0; i < 2; i++)
		{
			if(!moved)
			{
				if(playerX > myX)
				{
					if(playerY > myY)
					{
						moved = attemptMove(myX + 1, myY + 1, checkFences);
					} else {
						moved = attemptMove(myX + 1, myY - 1, checkFences);
					}
				} else {
					if(playerY > myY)
					{
						moved = attemptMove(myX - 1, myY + 1, checkFences);
					} else {
						moved = attemptMove(myX - 1, myY - 1, checkFences);
					}
				}
			}

			//Now try horizontal
			if(!moved)
			{
				if(Math.abs(myX - playerX) >= Math.abs(myY - playerY))
				{
					if(myX > playerX)
					{
						moved = attemptMove(myX - 1, myY, checkFences);
					} else {
						moved = attemptMove(myX + 1, myY, checkFences);
					}
				} else {
					if(myY > playerY)
					{
						moved = attemptMove(myX, myY - 1, checkFences);
					} else {
						moved = attemptMove(myX, myY + 1, checkFences);
					}
				}
			}

			checkFences = false;
		}

	}

	public boolean alive()
	{
		return alive;
	}

	public boolean attemptMove(int x, int y, boolean checkFences)
	{
		if((safeWhoAmI(myGrid.whatsAt(x, y)) != 'F' || !checkFences) && safeWhoAmI(myGrid.whatsAt(x, y)) != 'M')
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
			return i.whoAmI();
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
