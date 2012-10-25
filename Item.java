import java.awt.*;
public class Item{

	protected Grid mygrid;
	protected int x,y;
	public Item(Grid g, int x1, int y1){
	
		mygrid=g;
		x=x1;
		y=y1;

	}

	public void move(){}
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



	public void drawyoself(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x*64,y*64,64,64);
	}

}	
