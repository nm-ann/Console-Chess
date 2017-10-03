import java.util.ArrayList;

public class Piece{
	protected int xLoc;
	protected int yLoc;
	protected char name;
	protected boolean player1;

	public Piece(int x, int y, char c, boolean b){
		this.xLoc = x;
		this.yLoc = y;
		this.name = c;
		player1 = b;
	}

	public int getX(){
		return this.xLoc;
	}

	public int getY(){
		return this.yLoc;
	}

	public char getName(){
		return this.name;
	}

	public void movePiece(int x, int y){
		this.xLoc = x;
		this.yLoc = y;
	}

	public boolean rules(int z, int a, char[][] loc){
		//each piece has its own rules, so there's nothing to write here
		return false;
	}

	public boolean attack(int z, int a, char[][] loc){
		//each piece has its own attack, so there's nothing to write here
		return false;
	}

	//this is to ensure the remove method of the arraylist
	//works properly. It tries to use the default equals
	//method, but that won't work with a custom object,
	//so the equals method must be overidden and replaced
	//with a custom equals method
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		else if(!(obj instanceof Piece)){
			return false;
		}
		Piece other = (Piece) obj;
		if(other.getX() == xLoc && other.getY() == yLoc && other.getName() == name){
			return true;
		}
		else{
			return false;
		}
	}
}