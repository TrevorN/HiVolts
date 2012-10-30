public abstract class Item{

	protected Grid myGrid;

	protected int x, y;

	public Item(Grid g, int x, int y){
	
		myGrid = g;
		this.x = x;
		this.y = y;

	}

	public abstract void act();

	public abstract String whoAmI();

	public abstract void drawyoself();

}	
