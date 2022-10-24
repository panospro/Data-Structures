//The Supply class will represent the supplies
public class Supply {
	
	int supplyId; //the supply id.

	int x; // the x coordinate of the board tile where the supply is located.

	int y; // the y coordinate of the board tile where the supply is located.

	int supplyTileId; //the id of the board tile where the supply is located

	Supply()
	{
		supplyId=0;
		x=0;
		y=0;
		supplyTileId=0;
	}
	
	Supply(int supplyId,int x,int y,int supplyTileId){
		this.supplyId=supplyId;
		this.x=x;
		this.y=y;
		this.supplyTileId=supplyTileId;
	}
	
	Supply(Supply supply){
		supplyId=supply.getSupplyId();
		x=supply.getX();
		y=supply.getY();
		supplyTileId=supply.getSupplyTileId();
	}

	

	public int getSupplyId() {
		return supplyId;
	}
	

	public void setSupplyId(int supplyId) {
		this.supplyId = supplyId;
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
	
	public int getSupplyTileId() {
		return supplyTileId;
	}
	
	public void setSupplyTileId(int supplyTileId) {
		this.supplyTileId = supplyTileId;
	}
	
	
	
	
	
	
	
	
	
	
}
