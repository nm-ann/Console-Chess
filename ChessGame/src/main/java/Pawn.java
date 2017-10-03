public class Pawn extends Piece{
	private boolean firstMove;

	public Pawn(int x, int y, char c, boolean b){
		super(x, y, c, b);
		firstMove = true;
	}

	public boolean rules(int z, int a, char[][] loc){
		//a pawn may move one space forward
		//so player 1 can only move up and player 2 can only move down
		if(player1){
			//during a pawn's first move it can move 2 spaces
			if(firstMove){
				firstMove = false;
				if(yLoc - 2 == a && xLoc == z){
					return true;
				}
				else if(yLoc - 1 == a && xLoc == z){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				if(yLoc - 1 == a && xLoc == z){
					return true;
				}
				else{
					return false;
				}
			}
		}
		else{
			//during a pawn's first move it can move 2 spaves
			if(firstMove){
				firstMove = false;
				if(yLoc + 2 == a && xLoc == z){
					return true;
				}
				else if(yLoc + 1 == a && xLoc == z){
					return true;
				}
				else{
					return false;
				}
			}
			else{
				if(yLoc + 1 == a && xLoc == z){
					return true;
				}
				else{
					return false;
				}
			}
		}
	}

	public boolean attack(int z, int a, char[][] loc){
		//a pawn may attack one space forward, diagonally
		if(player1){
			if((xLoc + 1 == z && yLoc - 1 == a) || (xLoc - 1 == z && yLoc - 1 == a)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			if((xLoc + 1 == z && yLoc + 1 == a) || (xLoc - 1 == z && yLoc + 1 == a)){
				return true;
			}
			else{
				return false;
			}
		}
	}
}