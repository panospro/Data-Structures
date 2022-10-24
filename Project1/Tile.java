//The Tile class will represent the tiles
public class Tile {
	
	int tileId; // the id of the dashboard tile.

	int x; //the x coordinate of the board tile.
	
	int y; // the y coordinate of the dashboard tile.
	
	boolean up; // indicates if there is a wall on the north (top) side of the tile.
	
	boolean down; // indicates if there is a wall on the south (bottom) side of the tile.
	
	boolean left; // indicates if there is a wall on the west (left) side of the tile.
	
	boolean right; // indicates if there is a wall on the east (right) side of the tile

	Tile(){
		tileId=0;
		x=0;
		y=0;
		up=false;
		down=false;
		left=false;
		right=false;
	}
	
	Tile(int tileId,int x,int y,boolean up,boolean down,boolean left,boolean right){
		this.tileId=tileId;
		this.x=x;
		this.y=y;
		this.up=up;
		this.down=down;
		this.left=left;
		this.right=right;
	}
	
	Tile(Tile tile){
		
		tileId=tile.getTileId();
		x=tile.getX();
		y=tile.getY();
		up=tile.isUp();
		down=tile.isDown(); 
		left=tile.isLeft();
		right=tile.isRight();
	}

	
	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
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

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
