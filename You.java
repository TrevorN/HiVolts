public class You extends Item{

	private int direction=0;

	public You(Grid g, int i, int j){
		super(g,i,j);
		name = 'Y';
		color = 2;
	}

	public void setDirection(int r){
		direction = r;
	}

}
