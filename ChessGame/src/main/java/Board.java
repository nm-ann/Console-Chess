import java.util.ArrayList;

public class Board{
	private char[][] locations;
	private ArrayList<Piece> pieces1 = new ArrayList<Piece>();
	private ArrayList<Piece> pieces2 = new ArrayList<Piece>();

	public void initPieces(){
		locations = new char[9][9];
		//first for player 1
		//load pawns
		for(int i = 0; i < 8; i ++){
			pieces1.add(new Pawn(i + 1 , 7, 'p', true));
		}
		//load rooks
		pieces1.add(new Rook(1 , 8, 'r', true));
		pieces1.add(new Rook(8 , 8, 'r', true));
		//load knights/"horses"
		pieces1.add(new Horse(2 , 8, 'h', true));
		pieces1.add(new Horse(7 , 8, 'h', true));
		//load bishops
		pieces1.add(new Bishop(3 , 8, 'b', true));
		pieces1.add(new Bishop(6 , 8, 'b', true));
		//load queen
		pieces1.add(new Queen(4 , 8, 'q', true));
		//load king
		pieces1.add(new King(5 , 8, 'k', true));

		//now for player 2
		//load pawns
		for(int i = 0; i < 8; i ++){
			pieces2.add(new Pawn(i + 1 , 2, 'P', false));
		}
		//load rooks
		pieces2.add(new Rook(1 , 1, 'R', false));
		pieces2.add(new Rook(8 , 1, 'R', false));
		//load knights/"horses"
		pieces2.add(new Horse(2 , 1, 'H', false));
		pieces2.add(new Horse(7 , 1, 'H', false));
		//load bishops
		pieces2.add(new Bishop(3 , 1, 'B', false));
		pieces2.add(new Bishop(6 , 1, 'B', false));
		//load queen
		pieces2.add(new Queen(4 , 1, 'Q', false));
		//load king
		pieces2.add(new King(5 , 1, 'K', false));
	}
	public void initBoard(){
		//initialize a 8x8 board of dots with numbers going across the bottom 
		//and down the left side
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(j == 0 && i < 8){
					locations[i][j] = Character.forDigit(i + 1, 10);
				}
				else if(i == 8){
					locations[i][j] = Character.forDigit(j, 10);
				}
				else{
					locations[i][j] = '.';
					//draw player1's pieces
					for(Piece p : pieces1){
						if(p.getX() == j && p.getY() == i + 1){
							locations[i][j] = p.getName();
							break;
						}
					}
					//draw player2's pieces
					for(Piece p : pieces2){
						if(p.getX() == j && p.getY() == i + 1){
							locations[i][j] = p.getName();
							break;
						}
					}
				}
			}
		}
	}

	public void drawBoard(){
		//draw the board with the pieces in the appropraite spots
		//any square without a piece is represented by a dot
		System.out.print("\n");
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				System.out.print(locations[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public boolean player1Move(int x, int y, int z, int a){
		//your turn
		for(Piece p1 : pieces1){
			//ensure that the player has a piece in the selected square
			if(p1.getX() == x && p1.getY() == y){
				//if the player tries to move to an empty space
				if(locations[a-1][z] == '.'){
					if(p1.rules(z, a, locations)){
						p1.movePiece(z, a);
						locations[y-1][x] = '.';
						locations[p1.getY() - 1][p1.getX()] = p1.getName();
						return true;
					}
					else{
						System.out.println("That piece does not move that way!");
						return false;
					}
				}
				//if the player tries to attack the other player
				//check which piece it's attacking, move to that square, and remove that piece
				else{
					for(Piece p2 : pieces2){
						if(locations[a-1][z] == p2.getName() && p2.getX() == z && p2.getY() == a){
							if(p1.attack(z, a, locations)){
								p1.movePiece(z, a);
								locations[y-1][x] = '.';
								locations[p1.getY() - 1][p1.getX()] = p1.getName();
								pieces2.remove(p2);
								return true;
							}
							else{
								System.out.println("That piece cannot attack that way!");
								return false;
							}
						}
					}
				}
			}
		}
		System.out.println("Illegal move.");
		return false;
	}

	public boolean player2Move(int x, int y, int z, int a){
		//your turn
		for(Piece p2 : pieces2){
			//ensure that the player has a piece in the selected square
			if(p2.getX() == x && p2.getY() == y){
				//if the player tries to move to an empty space
				if(locations[a-1][z] == '.'){
					if(p2.rules(z, a, locations)){
						p2.movePiece(z, a);
						locations[y-1][x] = '.';
						locations[p2.getY() - 1][p2.getX()] = p2.getName();
						return true;
					}
					else{
						System.out.println("That piece cannot move there!");
						return false;
					}
				}
				else{
					//if the player tries to attack the other player
					//check which piece it's attacking, move to that square, and remove that piece
					for(Piece p1 : pieces1){
						if(locations[a-1][z] == p1.getName() && p1.getX() == z && p1.getY() == a){
							if(p2.attack(z, a, locations)){
								p2.movePiece(z, a);
								locations[y-1][x] = '.';
								locations[p2.getY() - 1][p2.getX()] = p2.getName();
								pieces1.remove(p1);
								return true;
							}
							else{
								System.out.println("That piece cannot attack that way!");
								return false;
							}
						}
					}
				}
			}
		}
		System.out.println("Illegal move.");
		return false;
	}

	public void player1Win(){
		for(Piece p : pieces2){
			if(p instanceof King){
				return;
			}
		}
		System.out.println("\nPlayer 1 wins!");
		System.exit(0);
	}

	public void player2Win(){
		for(Piece p : pieces1){
			if(p instanceof King){
				return;
			}
		}
		System.out.println("\nPlayer 2 wins!");
		System.exit(0);
	}
}