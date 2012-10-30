public class Fence extends Item{
	public Fence(Grid g, int i, int j){
		super(g,i,j);
	}

	public void act(){

	}

	public void drawyoself(){

		System.out.print("F");

	}
	
	public String whoAmI(){

		return "Fence";

	}

}
