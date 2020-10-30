package dmacc.beans;

import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	private String player1;
	private String computerPlayer;
	private String winner = "noot";
	
	public Game(String player1) {
		super();
		this.player1 = player1;
		setComputerPlayerToRandom();
		determineWinner();
	}
	
	String setComputerPlayerToRandom(){
		Random ran = new Random();
		int numChoice = ran.nextInt(3);
		System.out.println(numChoice);
		if(numChoice == 0) {
			computerPlayer = "rock";
		}else if(numChoice == 1) {
			computerPlayer = "paper";
		}else if(numChoice == 2) {
			computerPlayer = "scissors";
		}else {
			computerPlayer = "how";
		}
		return computerPlayer;
	}
	
	String determineWinner() {
		if(computerPlayer == winner ) {
			this.winner = "Tie!";
		}
		if(computerPlayer == "rock") {
			if(player1 == "paper") {
				this.winner = "Player wins!";
			}else if(player1 == "scissors") {
				this.winner = "Computer wins!";
			}
		}else if(computerPlayer == "paper") {
			if(player1 == "scissors") {
				this.winner = "Player wins!";
			}else if(player1 == "rock") {
				this.winner = "Computer wins!";
			}
		}else if(computerPlayer == "scissors") {
			if(player1 == "rock") {
				this.winner = "Player wins!";
			}else if(player1 == "paper") {
				this.winner = "Computer wins!";
			}
		}
		
		System.out.println(winner);
		System.out.println(player1);
		System.out.println(computerPlayer);
		return winner;
	}
}
