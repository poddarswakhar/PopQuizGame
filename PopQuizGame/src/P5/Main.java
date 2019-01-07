package P5;

import java.util.Arrays;
import java.util.Collections;



public class Main {				
	static Game game;			
	
	static String[][] questions = { {"Cricket", "top all-rounder?", "Best Batsman?", "Best Bowler?", "Best fielder?"},
		                            { "Bollywood", "Hero Of dilwale dulhania le jayenge?", "who is krish?", "SRK stands for?", "beautiful heroine?"},
		                            { "World", "Capital Of Bangladesh?", "Capital Of India?", "Capital Of Canada?", "Capital of Australia?"}
		};
	
	static String[][] answers = 	{ {"", "sakib", "virat", "mustafiz", "sabbir"},
                                      { "", "shahrukh", "hriktik", "shahrukh khan", "ashwariya"},
                                      { "", "Dhaka", "Delhi", "Ottawa", "Canberra"}
};
		
	
	
	
	
	
	
	
	public static void main(String[] args) {
		String ans;
		do{								
			//Reset the game
			game = new Game();		
			
			
			//Get number of players (from 1 to 3)
			int numPlayers = game.askForInt("How many players", 1, 3);

			//Add up to 3 players to the game
			for (int i = 0; i < numPlayers; i++) {
				String name = game.askForText("What is player " + i + " name?");
				game.addPlayer(name);				
			}
			
			
			
			
			
			int maxQuestions=0;
			int c=0;
			
			if (numPlayers==1)maxQuestions=4;
			else if (numPlayers==2)maxQuestions=2;
			else if (numPlayers==3)maxQuestions=1;

			
			int numQuestions = game.askForInt("How many questions should each player get?", 1, maxQuestions );

			for (int k=0;k<numQuestions;k++){
				
			for (int i = 0; i < numPlayers; i++) {
				int e = (int)(1+Math.random()*4);
				game.setCurrentPlayer(i);//draw rectangle around player 0, and currentPlayer = player0
				String p = game.askForText("Select Category: Cricket, Bollywood or World?" );
				String q = p.toLowerCase();
				String answer;
				if (q.equals("cricket")){
					c=0;
				answer = game.askForText(questions[c][e]);}
				else if (q.equals("bollywood")){ c=1;
					answer = game.askForText(questions[c][e]);}
				else if (q.equals("world")){ c=2;
					answer = game.askForText(questions[c][e]);}
				else answer = "none";
				
				if(answer.equalsIgnoreCase(answers[c][e])){
					game.correct();
					//display "Correct", increment score, change frame color to green
				}
				else while (!answer.equalsIgnoreCase(answers[c][e])){
					game.incorrect();	//display "incorrect", change frame color of player to red
				answer = game.askForText(questions[c][e]);
				
				}
				
			}}	
			
			//Do you want to play again? make sure you get valid input
			ans = game.askForText("Play again? (Y/N)"); 
			while(ans != null && !ans.toUpperCase().equals("Y") && !ans.toUpperCase().equals("N"))
				ans = game.askForText("Invalid input. Play again? (Y/N)");
		}while(ans.toUpperCase().equals("Y"));	//play again if the user answers "Y" or "y"

		System.exit(1); 	//This statement terminates the program
		
	}
	



	
	
	
}
