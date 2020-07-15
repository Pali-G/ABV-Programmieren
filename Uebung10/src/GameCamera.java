public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;					//entfernung der Camera von dem Punkt im Zentrum in X und Y Richtung
	
	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.handler = handler;
	}
	
	public void checkBlankSpace(){ 	//wenn die X/Y.Offsets zu groß bzw. zu klein sind, dann soll die Camera nicht weiter verschoben werden
		if (xOffset < 0) {			//somit bewegt sich die Camera innerhalb der Weltgrenzen und zeigt keinen BlankSpace
			xOffset = 0;
		}else if(xOffset > handler.getWorld().getWidth()*Tile.TILEWIDTH - handler.getWidth()) {		//weltgrößen sind in Tiles, müssen also 
			xOffset = handler.getWorld().getWidth()*Tile.TILEWIDTH - handler.getWidth();			//*Tilebreite verrechnet werden
		}
		if (yOffset < 0) {
			yOffset = 0;
		}else if(yOffset > handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight()*Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	public void centerOnPlayer(Player p) {					
		xOffset = p.getX() - handler.getGame().getWidth() / 2 + p.getWidth() / 2;
		yOffset = p.getY() - handler.getGame().getHeight() / 2 +  p.getHeight() / 2	;
		checkBlankSpace(); 	//wird nach dem Zentrieren gecallt, damit xOffset und yOffset nicht danach noch verändert werden
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}