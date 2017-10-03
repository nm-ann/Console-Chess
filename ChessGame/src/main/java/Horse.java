public class Horse extends Piece{
	private boolean firstMove;

	public Horse(int x, int y, char c, boolean b){
		super(x, y, c, b);
		firstMove = true;
	}
	
	public boolean rules(int z, int a, char[][] loc){
		//a Knight may move in a 1x2/2x1 L shape
		if((xLoc + 1 == z && yLoc + 2 == a) || (xLoc + 1 == z && yLoc - 2 == a)){
			return true;
		}
		else if((xLoc - 1 == z && yLoc + 2 == a) || (xLoc - 1 == z && yLoc - 2 == a)){
			return true;
		}
		else if((xLoc + 2 == z && yLoc + 1 == a) || (xLoc + 2 == z && yLoc - 1 == a)){
			return true;
		}
		else if((xLoc - 2 == z && yLoc + 1 == a) || (xLoc - 2 == z && yLoc - 1 == a)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean attack(int z, int a, char[][] loc){
		//a Knight may attack in a 1x2/2x1 L shape
		if((xLoc + 1 == z && yLoc + 2 == a) || (xLoc + 1 == z && yLoc - 2 == a)){
			return true;
		}
		else if((xLoc - 1 == z && yLoc + 2 == a) || (xLoc - 1 == z && yLoc - 2 == a)){
			return true;
		}
		else if((xLoc + 2 == z && yLoc + 1 == a) || (xLoc + 2 == z && yLoc - 1 == a)){
			return true;
		}
		else if((xLoc - 2 == z && yLoc + 1 == a) || (xLoc - 2 == z && yLoc - 1 == a)){
			return true;
		}
		else{
			return false;
		}
	}
}