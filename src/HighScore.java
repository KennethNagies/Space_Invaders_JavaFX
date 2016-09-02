/*
 * 	DECLARE score as an int
 * 	DECLARE initials as a String
 *
 * 	METHOD HighScore(int, String)
 * 		INITIALIZE score and initials
 * 	END METHOD HighScore(int, String)
 *
 * 	METHOD compareTo(HighScore)
 * 		RETURN a positive, negative, or 0 depending on the way I choose to organize the list
 * 	END METHOD compareTo(HighScore)
 *
 * 	METHOD getScore()
 * 		RETURN score
 * 	END METHOD getScore()
 *
 * 	METHOD getInitials()
 * 		RETURN initials
 * 	END METHOD getInitials()
 */
import java.io.Serializable;

/**
 * Objects of this class represent high scores and can be compared or serialized
 * @author Kenneth Nagies
 * @version September 2, 2016
 *
 */
public class HighScore implements Comparable<HighScore>, Serializable
{
	// The ID necessary to make this class Serializable
	private static final long serialVersionUID = -2188826275737210151L;
	private int score;
	private String initials;

	/**
	 * Initializes the high score object with a score and initials
	 * @param score The score from the game
	 * @param initials The initials of the player
	 */
	public HighScore(int score, String initials)
	{
		this.score = score;
		this.initials = initials;
	}

	/**
	 * Allows for sorting in descending order
	 * positive is lower, 0 is the same, and negative is higher
	 */
	@Override
	public int compareTo(HighScore otherScore)
	{
		// returns negative if this score is higher, positive if this score is lower, and 0 if this score is equal
		// allows for sorting in descending order
		return otherScore.getScore() - score;
	}

	/**
	 * Returns the score 
	 * @return The score
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 * Returns the player's initials
	 * @return the players initials as a string
	 */
	public String getInitials()
	{
		return initials;
	}

}
