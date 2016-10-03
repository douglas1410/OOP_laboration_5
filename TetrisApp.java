package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TetrisApp implements Commons{
	private Tetromino currentShape;
	private Piece Board;
	
	public TetrisApp(GraphicsContext gc){
		currentShape = new Tetromino();
		Board = new Piece();
		makeBoard(gc);
		
	}
	public void makeBoard(GraphicsContext gc){
		for (int i = 0; i < BOARDWIDTH; i++) {
			for (int j = 0; j < BOARDHEIGHT; j++) {
				int x=i*PIECEWIDTH;
				int y=j*PIECEWIDTH;
				gc.setFill(Color.BLUE);
				gc.strokeRect(x, y, PIECEWIDTH, PIECEWIDTH);
				
				
			}
		}
	}
}
