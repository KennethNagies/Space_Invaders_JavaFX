/*
 * 	CLASS GameOverScreen
 * 		DECLARE pane as a Pane
 * 		DECLARE score as an int
 * 		DECLARE highScoreScreen as a HighScoresScreen
 * 		DECLARE menuButton as a Button that says "Main Menu"
 *
 * 		METHOD GameOverScreen(int pane)
 * 			INITIALIZE score and pane
 * 			SET the text of the menut button to continue if the score is high enough
 * 			CLEAR the pane
 * 			CALL initializeText
 * 			CALL initializeButton
 * 		END METHOD GameOverScreen(int, pane)
 *
 * 		METHOD initializeText()
 * 			INITIALIZE the text to be displayed on the screen
 * 			SET the position of the text
 * 		END METHOD initializeText()
 *
 * 		METHOD initializeButton()
 * 			INITIALIZE the button
 * 			SET the button's location
 * 		END METHOD initializeButton()
 *
 * 		CLASS MenuHandler
 * 			METHOD handle(ActionEvent)
 * 				DRAW the main menu or initials screen based on the text of the button
 * 			END METHOD handle(ActionEvent)
 * 		END CLASS MenuHandler
 * 	END CLASS GameOverScreen
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameOverScreen
{
	private Pane pane;
	private int score;
	private HighScoresScreen highScoreScreen;
	Button menuButton = new Button("Main Menu");

	public GameOverScreen(int score, Pane pane)
	{
		this.score = score;
		this.pane = pane;
		// Initialize a highScoresScreen so that comparisons can be made to see if the player scored high enough to be on it
		highScoreScreen = new HighScoresScreen(pane);
		// if the score is high enough to be on the list, change the button text to "Continue"
		if(highScoreScreen.highEnough(new HighScore(score, "TEST")))
		{
			menuButton.setText("Continue");
		}
		// Clear all objects from the pane
		pane.getChildren().clear();
		// Initialize all text and buttons
		initializeText();
		initializeButton();
	}

	private void initializeText()
	{
		Text gameOverText = new Text("Game Over");
		// Set the appropriate values for the texts
		Text scoreText = new Text("Score: " + score);
		// Color the texts white
		scoreText.setFill(Color.WHITE);
		gameOverText.setFill(Color.WHITE);
		// Set the texts' sizes to 80
		scoreText.setFont(new Font(80));
		gameOverText.setFont(new Font(80));
		// bind the game over text's position to the center horizontally and vertically
		gameOverText.xProperty().bind(pane.widthProperty().divide(2).subtract(gameOverText.getLayoutBounds().getWidth()/2));
		gameOverText.yProperty().bind(pane.heightProperty().divide(2).subtract(gameOverText.getLayoutBounds().getHeight()/2));
		// bind the score text to the center horizontally;
		scoreText.xProperty().bind(pane.widthProperty().divide(2).subtract(scoreText.getLayoutBounds().getWidth()/2));
		// bind the score text to 20 pixels below the center vertically
		scoreText.yProperty().bind(gameOverText.yProperty().add(gameOverText.getLayoutBounds().getHeight() + 20));
		// add the texts to the pane
		pane.getChildren().add(gameOverText);
		pane.getChildren().add(scoreText);
	}

	private void initializeButton()
	{
		// Set the button's action to those defined by the MenuHandler class
		menuButton.setOnAction(new MenuHandler());
		// Make the button twice as big in the x and y
		menuButton.setScaleX(2);
		menuButton.setScaleY(2);
		// bind the button to the center of the pane horizontally
		menuButton.layoutXProperty().bind(pane.widthProperty().divide(2).subtract(menuButton.widthProperty().divide(2)));
		// bind the button to 275 pixels below the center vertically
		menuButton.layoutYProperty().bind(pane.heightProperty().divide(2).add(275));
		pane.getChildren().add(menuButton);
	}

	class MenuHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			// if the button says continue because the score was high enough, create a screen that allows the player to enter their initials
			if(menuButton.getText() == "Continue")
			{
				new InitialsScreen(pane, score, highScoreScreen);
			}
			// if not, return to the title screen
			else
			{
				new TitleScreen(pane);
			}
		}
	}
}
