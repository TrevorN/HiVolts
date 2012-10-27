import java.awt.*;
public class Fence extends Item{
	public Fence(Grid g, int i, int j){
		super(g,i,j);
	}

	public void act(){

	}

	public void drawyoself(Graphics g){


		g.setColor(Color.GREEN);
		g.fillRect(x*64,y*64,64,64);
	}
	
	public String whoAmI(){

		return "Fence";

	}

}
