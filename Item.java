import java.awt.*;
public abstract class Item{

	protected Grid mygrid;
	protected int x,y;
	public Item(Grid g, int x1, int y1){
	
		mygrid=g;
		x=x1;
		y=y1;

	}

	public int getY(){


		return y;

	}
	public int getX(){

		return x;

	}
	public void setY(int r){

		y=r;

	}
	public void setX(int r){

		x=r;

	}



	public abstract void act();

	public abstract void drawyoself(Graphics g);

}	
