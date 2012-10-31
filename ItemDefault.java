public class ItemDefault extends Item{
	private int direction=0;

	public ItemDefault(Grid g, int i, int j){
		super(g,i,j);
	}

	public void act(){

	}

	public String whoAmI(){

		return "Default";

	}
}
