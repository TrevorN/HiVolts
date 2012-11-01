public class You extends Item{

	private int direction=0;

	public You(Grid g, int i, int j){
		super(g,i,j);
		name = 'Y';
		color= = 6;
	}

	public void setDirection(int r){
		direction = r;
	}

	public void act(){

	}

	public String whoAmI(){

		return "You";

	}
}
