import java.awt.*;
public abstract class Item{

	protected Grid myGrid;

	protected int x, y;

	public Item(Grid g, int x, int y){
	
		myGrid = g;
		this.x = x;
		this.y = y;

	}

	public void move(){}

	public String whoAmI(){}

	public void drawyoself(Graphics g){}

}	
