package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application  implements Commons{
	@Override
	public void start(Stage primaryStage) {
		try {
		//	Shape s = new Shape(Tetriminos.Square);
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Canvas canvas = new Canvas(400, 600);
			
			GraphicsContext gc = canvas.getGraphicsContext2D();
			root.getChildren().add(canvas);
			Tetromino t = new Tetromino();
			TetrisApp game = new TetrisApp(gc);
			
			t.RotationRight();
			
			t.paint(gc);
			//s.Paint(gc);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

