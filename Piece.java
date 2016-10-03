package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Piece implements Commons,Comparable<Piece>  {
	private double  x, y;
	
	

	public Piece(){
	
	    x=1;
	    y=1;
	}
	
	public Piece(double x , double y){
		this.x = x;
		this.y = y;
	}
	
	public void Board(GraphicsContext gc){
		for (int i = 0; i < BOARDWIDTH; i++) {
			for (int j = 0; j < BOARDHEIGHT; j++) {
				x=i*PIECEWIDTH;
				y=j*PIECEWIDTH;
				gc.setFill(Color.BLUE);
				gc.strokeRect(x, y, PIECEWIDTH, PIECEWIDTH);
				
				
			}
		}
	}
	public void constrain(){
		
	}
	public boolean equals(Object Other){
		 Piece OtherPiece = (Piece) Other;
		if (OtherPiece.getX()==x && OtherPiece.getY()==y){
			return true;
		}else{
			return false;
		}
	}
	public void Paint(GraphicsContext gc){
		
		gc.setFill(Color.SKYBLUE);
		gc.fillRect(x, y, PIECEWIDTH, PIECEWIDTH);
		
		
	}
	
	 
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setNewCoord(double x ,double y){
		this.x= x;
		this.y=y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		String info="";
		info = "x :" +x+ ", y : " + y +"\n";
		return info;
	}

	public double XrotationRight(){
		return x*Math.cos(Math.PI/2)-y*Math.sin(Math.PI/2);

	}
	public double YrotationRight(){
		return x*Math.sin(Math.PI/2)+y*Math.cos(Math.PI/2);

	}

	public int compareTo(Piece o) {
//		if (x==o.getX()) {
//			return (int)(y-o.getY());
//		}
//		if (y==o.getY()) {
//			return (int) (x-o.getX());
//		}
		
		return Math.abs((int)((x+y -o.getX()-o.getY())));
		
		
		
	}
	
}
