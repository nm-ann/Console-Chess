public class Rook extends Piece{
	private boolean firstMove;

	public Rook(int x, int y, char c, boolean b){
		super(x, y, c, b);
		firstMove = true;
	}

	public boolean rules(int z, int a, char[][] loc){
		//ensures no other pieces are in the way of the move
		if(!checkBetween(z, a, loc)){
			return false;
		}
		//a Rook may move anywhere, so long as it stays on either its x or y coordinate
		if(xLoc == z || yLoc == a){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean attack(int z, int a, char[][] loc){
		//ensures no other pieces are in the way of the move
		if(!checkBetween(z, a, loc)){
			return false;
		}
		//a Rook may attack anywhere, so long as it stays on either its x or y coordinate
		if(xLoc == z){
			return true;
		}
		else if(yLoc == a){
			return true;
		}
		else{
			return false;
		}
	}

	//this checks the squares in between their current square and the one they're attacking
	//to ensure there aren't any pieces in the way
	public boolean checkBetween(int z, int a, char[][] loc){
		if(xLoc == z){
			if(yLoc > a){
				for(int i = 1; i < yLoc - a; i++){
					if(loc[(yLoc-i)-1][xLoc] != '.'){
						return false;
					}
				}
			}
			else if(yLoc < a){
				for(int i = 1; i < a - yLoc; i++){
					if(loc[(yLoc+i)-1][xLoc] != '.'){
						return false;
					}
				}
			}
		}
		else if(yLoc == a){
			if(xLoc > z){
				for(int i = 1; i < xLoc - z; i++){
					if(loc[yLoc-1][xLoc-i] != '.'){
						return false;
					}
				}
			}
			if(xLoc < z){
				for(int i = 1; i < z - xLoc; i++){
					if(loc[yLoc-1][xLoc+i] != '.'){
						return false;
					}
				}
			}
		}

		return true;
	}
}