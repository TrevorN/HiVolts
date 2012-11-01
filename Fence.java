public class Fence extends Item{

	public Fence(Grid g, int i, int j){

		super(g,i,j);
		name = 'F';
		color = 1;
		
	}

	public void act(){

	}

	public String whoAmI(){

		return "Fence";

	}

}
