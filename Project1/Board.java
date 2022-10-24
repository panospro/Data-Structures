import java.util.Random;

//The Board class will represent the game board 
public class Board {

	int N; // the board dimensions NxN


	int S; // the number of supplies on the board.

	int W; // the number of walls you can add to the maze.
	
	Tile[] tiles;  // an array of Tile objects. ids take values from 0 to NxN - 1
	
	Supply[] supplies; // an array of objects of type Supply.
	//the empty constructor of the Board class
	Board() {
	
	}

	//the constructor of the Board class that accepts class variables as arguments
	Board(int N, int S, int W) {
		this.N = N;
		this.S = S;
		this.W = W;
		tiles = new Tile[((2*N+1) * N)];
		supplies = new Supply[S];

	}
	
	//the constructor of the Board class that accepts an object of type Board as argument
	Board(Board board) {
		N = board.getN();
		S = board.getS();
		W = board.getW();
		tiles = new Tile[((board.getN()*2+1)* board.getN())]; // -1
		supplies = new Supply[board.getS()];
	}


	// This function will initialize the Tile array objects randomly.
	//Initialize the tiles of the array, then set the id,x,y to the tiles, then set which tiles will have walls.
	//Argument of the walls is done first from the outer walls and then to the inner ones of the maze in a random way.
	//Also when a wall is defined on one side of a tile, it is also defined on its corresponding neighbor on the opposite side (if allowed).
	//We created counter variables that check how many walls each tile has and if another wall can be defined on it.
	void createTile() {			
		
		
			for(int o=0;o<(2*N+1)*N;o++) {
				tiles[o]=new Tile();
			}
			
			for(int k=0;k<(2*N)+1;k++) {
				for(int j=0;j<N;j++) {
					int i=j+k*N;
					tiles[i].setTileId(i);
					tiles[i].setX(j);
					tiles[i].setY(k);
				}
			}
			
			for(int i=0;i<(2*N+1)*N;i++) {
				if(tiles[i].getX()==0&& (tiles[i].getY()%2==0)&& tiles[i].getY()<2*N-1) {
					tiles[i].setDown(true);
					tiles[i+2*N].setUp(true);
					tiles[i+N+1].setLeft(true);
					tiles[i+N-1].setRight(true);
					W--;
				}
			}
			
			for(int i=0;i<(2*N+1)*N;i++) {
				if(tiles[i].getX()==(N-1)&& (tiles[i].getY()%2==0)&& tiles[i].getY()<2*N-1) {
					tiles[i].setDown(true);
					tiles[i+2*N].setUp(true);
					tiles[i+N-1].setRight(true);
					tiles[i+N+1].setLeft(true);
					W--;
				}
			}
			
			for(int i=0;i<(2*N+1)*N;i++) {
				if(tiles[i].getY()==0&& (tiles[i].getX()%2==0)&& tiles[i].getX()<N-2) {
					tiles[i].setRight(true);
					tiles[i+2].setLeft(true);
					tiles[i+N+1].setUp(true);
					if(i>=N) {
						tiles[i-N+1].setDown(true);
					}
					W--;
				}
			}
			
			for(int i=0;i<(2*N+1)*N;i++) {
				if(tiles[i].getX()>1&&(tiles[i].getY()==(2*N)&& (tiles[i].getX()%2==0)&& tiles[i].getX()<N-2)) {
					tiles[i].setRight(true);
					tiles[i+2].setLeft(true);
					tiles[i-N+1].setDown(true);
					if(i<N+1) {
						tiles[i+N+1].setUp(true);
					}
					W--;
				}
			}
			
			for(int k=1;k<(2*N+1);k+=2) {
				for(int j=1;j<N;j+=2) {
					int counter=0;
					int counter1=0;
					int counter3=0;
					int counter4=0;
					int i=j+k*N;
				
				
				if(tiles[i-2].isDown()) {
					++counter1;
				}
				if(tiles[i-2].isUp()) {
					++counter1;
				}
				if(tiles[i-2].isRight()) {
					++counter1;
				}
				if(tiles[i-2].isLeft()) {
					++counter1;
				}
				
				if(counter1>=2) {
					
					continue;
				}
				
			
				if(tiles[i-N].isDown()) {
					++counter3;
				}
				if(tiles[i-N].isUp()) {
					++counter3;
				}
				if(tiles[i-N].isRight()) {
					++counter3;
				}
				if(tiles[i-N].isLeft()) {
					++counter3;
				}
				
				if(counter3>=2) {
					
					continue;
				}
				if(tiles[i+N].isDown()) {
					++counter4;
				}
				if(tiles[i+N].isUp()) {
					++counter4;
				}
				if(tiles[i+N].isRight()) {
					++counter4;
				}
				if(tiles[i+N].isLeft()) {
					++counter4;
				}
				
				if(counter4>=2) {
					
					continue;
				}
				
					if(tiles[i].isDown()) {
						++counter;
					}
					if(tiles[i].isUp()) {
						++counter;
					}
					if(tiles[i].isRight()) {
						++counter;
					}
					if(tiles[i].isLeft()) {
						++counter;
					}
					
					
					if(counter>=2) {
					
						continue;
					}
				
					else if (counter == 1 && W > 0) {
			
						Random rand = new Random();
						int number = rand.nextInt(4);
			
						switch (number) {
			
						case 0:
							tiles[i].setDown(true);
							if(i<2*N) {
								tiles[i+2*N].setUp(true);
							}
							tiles[i+N+1].setLeft(true);
							tiles[i+N-1].setRight(true);
							W--;
							break;
			
						case 1:
							tiles[i].setRight(true);
							tiles[i+2].setLeft(true);
							tiles[i+N+1].setUp(true);
							if(i>=N) {
								tiles[i-N+1].setDown(true);
							}
							W--;
							break;
			
						case 2:
							tiles[i].setLeft(true);
							tiles[i-2].setRight(true);
							tiles[i+N-1].setUp(true);
							if(i>N) {
								tiles[i-N-1].setDown(true);
							}
							W--;
							break;
						case 3:
							tiles[i].setUp(true);
							tiles[i-N+1].setRight(true);
							if(i>2*N) {
								tiles[i-N-N].setDown(true);
							}
							tiles[i-N-1].setLeft(true);
							
							W--;
							break;
			
						}
					}
			
					else if (counter == 0 && W > 0) {
						Random rand = new Random();
						for (int o = 0; o < 2; o++) {
							int number = rand.nextInt(5);
			
							switch (number) {
			
							case 0:
								tiles[i].setUp(true);
								tiles[i-N+1].setRight(true);
								tiles[i-N-N].setDown(true);
								tiles[i-N-1].setLeft(true);
								W--;
								break;
			
							case 1:
								tiles[i].setDown(true);
								tiles[i+2*N].setUp(true);
								tiles[i+N+1].setLeft(true);
								tiles[i+N-1].setRight(true);
								W--;
								break;
			
							case 2:
								tiles[i].setRight(true);
								tiles[i+2].setLeft(true);
								tiles[i+N+1].setUp(true);
								if(i>=N) {
									tiles[i-N+1].setDown(true);
								}
								W--;
								break;
			
							case 3:
								tiles[i].setLeft(true);
								tiles[i-2].setRight(true);
								tiles[i+N-1].setUp(true);
								if(i>N) {
									tiles[i-N-1].setDown(true);
								}
								W--;
								break;
			
							default:
								break;
							}
						}
					}
				}
		}
	}

	//This function will initialize the objects of the supplies array randomly.
	//Initializes the array supplies
	//Created numberX and numberY variables to generate random possible x,y values that will define the x,y of the supplies.
	//Using a do while loop will continuously generate a number x,y until one is created in which the supplies can be placed
	//Then using the double for we check if the supplies are in a different position, if yes then continue, if not then decrement the counter by one and repeat the cycle to put the supply in a different position
	void createSupply() {	
		int number2X;
		int number2Y;
		int numberX;
		int numberY;
		
		for (int i = 0; i < S; i++) {
			supplies[i] = new Supply(0, 1, 1, 1);
		}

		do {
			 number2X = 0;
			 number2Y = 0;
			Random rand2X = new Random();
			Random rand2Y=new Random();
			number2X = rand2X.nextInt((N*2)-1)+1;
			number2Y =rand2Y.nextInt(N-2)+1;
		}while (((number2X%2==0)||(number2Y%2==0))||(((number2Y==N/2)&&(number2X==(N*2)/2))||((number2Y==N-1)&&(number2X==(N*2)))));
		
		supplies[0] = new Supply(0, number2X,number2Y, number2Y+(N*number2X));
		
		for (int i = 1; i < S; i++) {
			for (int j = 0; j < i; j++) {

				do {
					 numberX = 0;
					 numberY = 0;
					Random randX = new Random();
					Random randY=new Random();
					numberX = randX.nextInt((N*2)-1)+1;
					numberY =randY.nextInt(N-2)+1;
			
				} while (((numberX%2==0)||(numberY%2==0))||(((numberY==N/2)&&(numberX==(N*2)/2))||((numberY==N-1)&&(numberX==(N*2)))));
				supplies[i].setSupplyTileId(numberX+(N*numberY));
		
				if ((supplies[i].getSupplyTileId() != supplies[j].getSupplyTileId())) {
					supplies[i] = new Supply(i, numberX,numberY, numberY+(N*numberX));
				}
				else --i;
			}
		}
	}	
 
	// This function will generate the game board in a pseudo-random fashion using the above functions.
	void createBoard() {				
	createSupply();					
	createTile();	
	}

	
	/* will create and return an array of dimension (2*N + 1)xN. Each
	tile needs two lines to represent. On the 1st line
	the horizontal walls are preserved (“ + --- + “) In the second line the sides
	walls and the contents of the tile (“| M |” or “ “). In case the
	tile does not contain an object, then it will remain empty.

	We created an array table and first put the character " " in all its positions. Then we put " + " in the corresponding positions and then the walls
	finally we put "T" and "M" and made the function print and return the array */
	 String[][] getStringRepresentation(int theseusTile, int minotaurTile) {
		String[][] array = new String[N][(2 * N) + 1];

		for (int j = 0; j < (2 * N) + 1; j++) {
			for (int i = 0; i < N; i++) {
				array[i][j] = "   ";
			}
		}
		for (int j = 0; j < (2 * N) + 1; j += 2) {
			for (int i = 0; i < N; i += 2) {
				array[i][j] = " + ";
			}
		}


		for(int k=1;k<(2*N+1);k+=2) {
			for(int j=1;j<N;j+=2) {
				int i=j+k*N;
			  if(tiles[i].isDown()) {
				  array[tiles[i].getX()][tiles[i].getY()+1]="---"; 
				  }
			  if(tiles[i].isUp()) { 
				  array[tiles[i].getX()][tiles[i].getY()-1]="---"; 
				  }
			  if(tiles[i].isLeft()) {
				  array[tiles[i].getX()-1][tiles[i].getY()]=" | "; 
				  }
			  if(tiles[i].isRight()) {
				  array[tiles[i].getX()+1][tiles[i].getY()]=" |"; 
				  } 
			}
		}
		  		 

		for (int i = 0; i < S; i++) {
			array[supplies[i].getY()][supplies[i].getX()] = "s" + supplies[i].getSupplyId() + " ";
		}

		int xT = theseusTile % getN();
		int yT = theseusTile / getN();
		array[xT][yT] = " T ";
		int xM = minotaurTile % getN();
		int yM = minotaurTile / getN();
		array[xM][yM] = " M ";

		for (int i = 0; i < (2 * N) + 1; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(array[j][i]);
			}
			System.out.println();
		}

		return array;
	}
	

	public int getN() {
		return N;
	}
	
	public void setN(int n) {
		N = n;
	}
	

	public int getS() {
		return S;
	}
	
	public void setS(int s) {
		S = s;
	}
	
	public int getW() {
		return W;
	}
	
	public void setW(int w) {
		W = w;
	}
	
	public Tile[] getTiles() {
		return tiles;
	}
	
	public void setTiles(Tile[] tiles) {
		this.tiles = tiles;
	}
	
	public Supply[] getSupplies() {
		return supplies;
	}
	
	public void setSupplies(Supply[] supplies) {
		this.supplies = supplies;
	}

}
