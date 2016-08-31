
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class GameDriver extends Application
{
	public void start(Stage primaryStage)
	{
		Pane pane = new Pane();
		// Sets the pane's background color to black
		// If both pane and scene are not the same color, using buttons causes some graphical issues
		pane.setStyle("-fx-background: #000000;");
		Scene scene = new Scene(pane, 800, 750, Color.BLACK);
		new TitleScreen(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
