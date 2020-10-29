package dmacc.beans;

import java.util.Random;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Game {
	private String player1;
	private String computerPlayer;
	private String winner;
	
	public Game(String player1) {
		super();
		this.player1 = player1;
		this.setComputerPlayerToRandom();
		this.determineWinner();
	}
	
	String setComputerPlayerToRandom(){
		Random ran = new Random();
		int numChoice = ran.nextInt(2);
		System.out.println(numChoice);
		switch(numChoice) {
		case 0:
			computerPlayer = "rock";
		case 1:
			computerPlayer = "paper";
		case 2:
			computerPlayer = "scissors";
		}
		return computerPlayer;
	}
	
	String determineWinner() {
		if(computerPlayer == winner ) {
			winner = "Tie!";
		}else if(computerPlayer == "rock" && player1 == "paper") {
			winner = "Player wins!";
		}else if(computerPlayer == "rock" && player1 == "scissors") {
			winner = "Computer wins!";
		}else if(computerPlayer == "paper" && player1 == "scissors") {
			winner = "Player wins!";
		}else if(computerPlayer == "paper" && player1 == "rock") {
			winner = "Computer wins!";
		}else if(computerPlayer == "scissors" && player1 == "rock") {
			winner = "Player wins!";
		}else if(computerPlayer == "scissors" && player1 == "paper") {
			winner = "Computer wins!";
		}else {
			winner = "How did this happen";
		}
		return winner;
	}
}
