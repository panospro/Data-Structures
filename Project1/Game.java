//The Game class will represent the game
public class Game {
	
	int round;					// the current game round.
	

	Game(){
		round=0;
	}
	
	Game(int round){
		this.round=round;
	}
	
	Game(Game game){
		round=game.getRound();
	}
	
	
	//this function returns the round of the game
	public int getRound() {
		return round;
	}
	
	//this function sets the round of the game
	public void setRound(int round) {
		this.round = round;
	}

	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();   															//Create an object of type Game
		game=new Game(0); //Set round to 0
		Board board=new Board(); //Create an object of type Board
		Player player1=new Player(); //Create an object of type Player
		Player player2=new Player(); //Create an object of type Player
		board.setN(15); //Set the dimension of the dashboard to 15
		board=new Board(15,4,(((board.getN()*board.getN()*3)+1)/2)); //Define game supplies and walls
		board.createBoard(); //Create dashboard
		player1=new Player(0,"theseus",0,board,1,board.getN()*2-1); //Define player1 elements
		player2=new Player(1,"minotaur",0,board,board.getN()/2,board.getN()); //Define player 2 elements
				 
		 
		for(int i=0;i<100;i++) {
		
			int player1x=player1.getX();
			int player1y=player1.getY();
			int player2x=player2.getX();
			int player2y=player2.getY();
			int player1Score=player1.getScore();
			if(i==0) {
				System.out.println("Number of Round "+(game.getRound()));
				//System.out.println();
				board.getStringRepresentation((player1.getX()+(player1.getY()*board.getN())), (player2.getX()+(player2.getY()*board.getN())));
			}
			System.out.println("Number of Round "+(game.getRound()+1));
			//System.out.println();
			player1.move(player1.getX()+(player1.getY()*board.getN()));
			
			if(player1.getX()>player1x) {
				System.out.println("Player1 went right");
			}
			if(player1.getX()<player1x) {
				System.out.println("Player1 went left");
			}
			if(player1.getY()>player1y) {
				System.out.println("Player1 went down");
			}
			if(player1.getY()<player1y) {
				System.out.println("Player1 went up");
			}
			player2.move(player2.getX()+(player2.getY()*board.getN()));
			
			if(player2.getX()>player2x) {
				System.out.println("Player2 went right");
			}
			if(player2.getX()<player2x) {
				System.out.println("Player2 went left");
			}
			if(player2.getY()>player2y) {
				System.out.println("Player2 went down");
			}
			if(player2.getY()<player2y) {
				System.out.println("Player2 went up");
			}
			board.getStringRepresentation((player1.getX()+(player1.getY()*board.getN())), (player2.getX()+(player2.getY()*board.getN())));
			for(int o=0;o<board.getS();o++) {
				if(player1.getScore()>player1Score) {
					if(board.getSupplies()[o].getSupplyTileId()==(player1.getX()+player1.getY()*board.getN())) {
						board.getSupplies()[o].setSupplyTileId(0);
						board.getSupplies()[o].setX(0);
						board.getSupplies()[o].setY(0);
					}
				}
			}
		  if(player1.getScore()==board.getS()) {
			  System.out.println("Player_1 won the game"); 
		  	  break;
		  }
		  if((player1.getX()==player2.getX())&&(player1.getY()==player2.getY())) {
			  System.out.println("Player_2 won the game"); 
		  	  break;
		  }
			game.setRound(++game.round);
		  
		  if(i==99) {
			  System.out.println("It's a draw");
		  }
		}
		
		
		
		
		
		
		


	}

}




