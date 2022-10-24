import java.util.Random;

//Player class will represent the player
public class Player {
	
	int playerId;// the player code.
	String name; //the player's name.
	Board board? // the game board.
	int score; // the player's score, which goes up by one each time they find a supply.
	int x; // the x coordinate of the tile where the player is
	int y; // the y coordinate of the tile where the player is
	

	Player(){
		playerId=0;
		name=null;
		score=0;
		x=0;
		y=0;

	}
	
	
	Player(int playerId,String name,int score,Board board,int x,int y){
		this.playerId=playerId;
		this.name=name;
		this.score=score;
		this.x=x;
		this.y=y;
		this.board = new Board(board);
		for(int i=0;i<((board.getN()*2)+1)*board.getN();i++) {
			this.board.getTiles()[i]=board.getTiles()[i];
		}
		for(int j=0;j<board.getS();j++) {
			this.board.getSupplies()[j]=board.getSupplies()[j];
		}
		
	}
	
	
	Player(Player player){
		playerId=player.getPlayerId();
		name=player.getName();
		score=player.getScore();
		x=player.getX();
		y=player.getY();
	}
	/* This function will randomly select one of the player's available moves to calculate the player's next position, move the player
    at the new location and will return an array of integers containing the id and coordinates of the corresponding tile after the move and the id of the supplies
	that he collected during his particular move. It will also print a corresponding message on the console whenever one collects a resource or cannot move. */
	//We created an array table with 4 positions where the id,x,y and supplies that the player will have collected after making his move will be located.
	//Then we made a counter that will take a value depending on the side on which there is no wall and then with a switch, the player
	//based on the value of the counter it will make a random move (rand), thus changing its x and y.
	int[] move(int id) {
		
		int[] array=new int[4];		
		
			Random rand4 = new Random(); 
			Random rand5 = new Random();
			Random rand6 = new Random();
			
			int rand1= rand4.nextInt(2); 
			int rand2 = rand5.nextInt(3); 
			int rand3 = rand6.nextInt(4); 
			int counter=0;
		
	
			if((board.getTiles()[id].isDown())==false&&(x!=1&&y!=29)) {
				counter+=1;
			}
			if((board.getTiles()[id].isUp())==false) {
				counter+=10;
			}
			if((board.getTiles()[id].isLeft())==false) {
				counter+=100;
			}
			if((board.getTiles()[id].isRight())==false) {
				counter+=1000;
			}
			
			
			/*
			* right x+=2 left x-=2 up y-=2 down y+=2
			*/
				switch(counter) {
				
				case 1: y+=2;
						break;
				
				case 10: y-=2;
						break;
				
				case 100: x-=2;
						break;
						
				case 1000:	x+=2;
						break;
						
				case 11: if(rand1==0) {
							y-=2;
						}
						else y+=2;
						break;
						
				case 101: if(rand1==0) {
							y+=2;
							}
						  else x-=2;
						break;	
						
				case 1001: if(rand1==0) {
							y+=2;
							}
						   else x+=2;
						break;
						
				case 110: if(rand1==0) {
							y-=2;
							}
						  else x-=2;
						break;	
						
				case 1010: if(rand1==0) {
							y-=2;
						   }
						   else x+=2;
						break;	
				case 1100: if(rand1==0) {
							x-=2;
							}
				  			else x+=2;
						break; 
				
				case 111: if(rand2==0) {
							y-=2;
							}
						else if(rand2==1) {
							y+=2;
							}
						  else x-=2;
						break;
					
				case 1101: if(rand2==0) {
								y+=2;
								}
						  else if(rand2==1) {
								x-=2;
								}
						  else x+=2;
						break;
					
				case 1110: if(rand2==0) {
							y-=2;
							}
						  else if(rand2==1) {
							x-=2;
							}
						  else x+=2;
							break;
							
				case 1011: if(rand2==0) {
							y-=2;
							}
						  else if(rand2==1) {
							y+=2;
							}
						  else x+=2;
							break;
				
				case 1111: if(rand3==0) {
							y-=2;
							}
						   else if(rand3==1) {
							y+=2;
							}
						   else if(rand3==2) {
								x-=2;
								}
						   else x+=2;
						   break;
		
				default: System.out.println("You can't move");
						break;
		 
				}
				
				
				
		

		int newId=x+y*board.getN();
		
		for(int i=0;i<board.getS();i++) {
			if((newId==board.getSupplies()[i].getSupplyTileId())&&getPlayerId()==0) {
				board.getSupplies()[i].setX(0);
				board.getSupplies()[i].setY(0);
				++score;
				System.out.println("You collected the supply with id "+ board.getSupplies()[i].getSupplyId());
			}
		}
		
		
		array[0]=newId;
		array[1]=getX();
		array[2]=getY();
		array[3]=score;
		
		/*System.out.println("Player"+(getPlayerId()+1)+ " new id = "+array[0]);
		System.out.println("Player"+(getPlayerId()+1)+  " new x = "+array[1]);
		System.out.println("Player"+(getPlayerId()+1)+  " new y = "+array[2]);
		System.out.println("Player"+(getPlayerId()+1)+ " score = "+array[3]); */
		return array;
		
		
		
																
	}
	
	
	
	public int getPlayerId() {
		return playerId;
	}
	
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
}
	
	

