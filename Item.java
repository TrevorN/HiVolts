public class Item{

	char escCode = 0x1B;

	protected Grid myGrid;

	protected int x, y;
	
	protected char name = ' ';

	protected int color = 0; //1-8

	public Item(Grid g, int x, int y){
	
		myGrid = g;
		this.x = x;
		this.y = y;

	}

	public String whoAmI(){
		return Character.toString(name);
	}

	public void drawyoself(){
		
		
		for(int i = 0; i < 6; i++){

			for(int j = 0; j < 12; j++){

				System.out.print(String.format("%c[30;%dm",escCode,40+color));
				if(i==6){

					System.out.print(String.format("%c[30;%dm",escCode,40+color));

				}
					

				System.out.print(name);

			}
			
			System.out.print(String.format("%c[%dD", escCode, 12));

			System.out.print(String.format("%c[%dB", escCode, 1));
			//line return

		}

		System.out.print(String.format("%c[%dA", escCode, 6));
		System.out.print(String.format("%c[%dC", escCode, 12));

	}

}	
