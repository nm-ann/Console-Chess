import java.util.Scanner;

public class Chess{
	public static void main(String[] args){
		final Scanner scanner = new Scanner(System.in);
		final Board board = new Board();

		boolean player1 = true;

		board.initPieces();
		board.initBoard();

		while(true){
			//draw the current board every turn
			board.drawBoard();
			if(player1){
				//check if player 2 has won
				board.player2Win();
				System.out.println("\nPlayer 1's turn. Enter a piece x y and a square x y like so: x y z a \n");
			}
			else{
				//check if player 1 has won
				board.player1Win();
				System.out.println("\nPlayer 2's turn. Enter a piece x y and a square x y like so: x y z a \n");
			}
			//now, accept the player's input
			//the input is parsed as a string, so it can check for "exit" and "skip"
			//if exit, the game will exit, if skip, it will become the other player's turn
			int x = 0;
			int y = 0;
			int z = 0;
			int a = 0;
			String input = scanner.nextLine();
			String inputSplit[];
				if(input.equals("exit")){
					break;
				}
				else if(input.equals("skip")){
					player1 = !player1;
					continue;
				}
				//after it checks them for "exit" and "split", it's turned into an array
				//which will be checked for correct input (4 integers less than 9 and greater than -1)
				else{
					if(input.split(" ").length != 4){
						System.out.println("Illegal Input: Must input 4 numbers");
						continue;
					}
					inputSplit = input.split(" ");
				}
				try{
					if(Integer.parseInt(inputSplit[0]) < 9 && Integer.parseInt(inputSplit[0]) > -1){
						x = Integer.parseInt(inputSplit[0]);
					}
					else{
						System.out.println("Illegal Input: Number isn't between 8 and 0");
						continue;
					}
				}
				catch(NumberFormatException e){
					System.out.println("Illegal Input: input is not a number");
					continue;
				}
				try{
					if(Integer.parseInt(inputSplit[1]) < 9 && Integer.parseInt(inputSplit[1]) > -1){
						y = Integer.parseInt(inputSplit[1]);
					}
					else{
						System.out.println("Illegal Input: Number isn't between 8 and 0");
						continue;
					}
				}
				catch(NumberFormatException e){
					System.out.println("Illegal Input: input is not a number");
					continue;
				}
				try{
					if(Integer.parseInt(inputSplit[2]) < 9 && Integer.parseInt(inputSplit[2]) > -1){
						z = Integer.parseInt(inputSplit[2]);
					}
					else{
						System.out.println("Illegal Input: Number isn't between 8 and 0");
						continue;
					}
				}
				catch(NumberFormatException e){
					System.out.println("Illegal Input: input is not a number");
					continue;
				}
				try{
					if(Integer.parseInt(inputSplit[3]) < 9 && Integer.parseInt(inputSplit[3]) > -1){
						a = Integer.parseInt(inputSplit[3]);
					}
					else{
						System.out.println("Illegal Input: Number isn't between 8 and 0");
						continue;
					}
				}
				catch(NumberFormatException e){
					System.out.println("Illegal Input: input is not a number");
					continue;
				}

			if(player1){
				//if it's an invalid move, prompt the player again
				if(!board.player1Move(x, y, z, a)){
					continue;
				}
			}
			else{
				//if it's an invalid move, prompt the player again
				if(!board.player2Move(x, y, z, a)){
					continue;
				}
			}
			//it's not the next player's turn
			player1 = !player1;
		}
	}
}