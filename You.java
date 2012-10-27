import java.awt.*;
public class You extends Item{
	private int direction=0;
	public You(Grid g, int i, int j){
		super(g,i,j);
	}
	public void drawyoself(Graphics g){

		g.setColor(Color.YELLOW);
		g.fillRect(x*64,y*64,64,64);
	}

	public void setDirection(int r){
		direction = r;
	}

	public String whoAmI(){

		return "You";

	}
}
