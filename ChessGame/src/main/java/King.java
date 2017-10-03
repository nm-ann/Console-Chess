public class King extends Piece{
	private boolean firstMove;

	public King(int x, int y, char c, boolean b){
		super(x, y, c, b);
		firstMove = true;
	}
	
	public boolean rules(int z, int a, char[][] loc){
		//a King may move one space in any direction, including diagonal
		if((xLoc + 1 == z && yLoc - 1 == a) || (xLoc + 1 == z && yLoc + 1 == a)){
			return true;
		}
		else if((xLoc - 1 == z && yLoc - 1 == a) || (xLoc- 1 == z && yLoc + 1 == a)){
			return true;
		}
		else if(xLoc + 1 == z || xLoc - 1 == z){
			return true;
		}
		else if(yLoc + 1 == a || yLoc - 1 == a){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean attack(int z, int a, char[][] loc){
		//a King may attack one space in any direction, including diagonal
		if((xLoc + 1 == z && yLoc - 1 == a) || (xLoc + 1 == z && yLoc + 1 == a)){
			return true;
		}
		else if((xLoc - 1 == z && yLoc - 1 == a) || (xLoc- 1 == z && yLoc + 1 == a)){
			return true;
		}
		else if(xLoc + 1 == z || xLoc - 1 == z){
			return true;
		}
		else if(yLoc + 1 == a || yLoc - 1 == a){
			return true;
		}
		else{
			return false;
		}
	}
}