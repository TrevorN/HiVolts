import java.awt.*;
public class You extends Item{
	private int direction=0;
	public You(Grid g, int i, int j){
		super(g,i,j);
	}
	public void drawyoself(){

		System.out.print("Y");

	}

	public void setDirection(int r){
		direction = r;
	}

	public String whoAmI(){

		return "You";

	}
}
