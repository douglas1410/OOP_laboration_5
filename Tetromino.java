package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;


public class Tetromino implements Commons{
	private ArrayList<Piece> thePieces;
	private double currentX;
	private double currentY;
	private Random ran ;
	public Tetromino(){
		ran= new Random();
		
		thePieces = new ArrayList<Piece>();
			
			currentX=160;
			currentY=120;
			thePieces.add(new Piece(currentX, currentY));
			addPieces();
			

		
	}
	
	public Tetromino(Piece p){
		
		ran= new Random();
		thePieces = new ArrayList<Piece>();
			thePieces.add(p);
			currentX=p.getX();
			currentY=p.getY();
			addPieces();
			
	}
	private void addPieces(){
		for (int i = 1; i <4; i++) {
			Piece temp= null;
			SetRandomPieceXY();
			temp = new Piece(currentX, currentY);
			thePieces.add(temp);
			for (int j = 0; j < i; j++) {
				if (thePieces.get(j).equals(temp)) {
					thePieces.remove(thePieces.get(j));
					i--;
				}
			}
		}		
		Collections.sort(thePieces);
		System.out.println(toString());
		System.out.println(thePieces.get(1).toString());

		
	}
	
	public void RotationRight(){
	

		double centerX = thePieces.get(1).getX();
		double centerY = thePieces.get(1).getY();
		
		for (int i = 0; i <4; i++) {
			if(i==1){
				continue;
			}
			
			double newX = thePieces.get(i).XrotationRight()-thePieces.get(1).XrotationRight();
			double newY= thePieces.get(i).YrotationRight()-thePieces.get(1).YrotationRight();

			thePieces.get(i).setNewCoord(newX+centerX,newY+centerY );
 		}
	}
	
	public int getNbOfPieces(){
		return thePieces.size();
	}
	private void SetRandomPieceXY(){
		int ranx=0, rany=0;
		
		ranx =  (ran.nextInt(3)-1);
		if(ranx==0){
			rany = (2*ran.nextInt(2))-1;
		}else{
			rany=0;
		}
		
		currentX =currentX+ PIECEWIDTH*ranx;
		currentY= currentY+ PIECEWIDTH*rany;
	}
	
	
	public void paint(GraphicsContext gc){
		for (Piece p : thePieces) {
			
			p.Paint(gc);
		}
	
	}
	public String toString(){
		String info="";
		info=thePieces.toString();
		return info;
	}
}
