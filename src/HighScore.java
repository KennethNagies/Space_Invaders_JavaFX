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

public class HighScore implements Comparable<HighScore>, Serializable
{
	/**
	 *
	 */
	// The ID necessary to make this class Serializable
	private static final long serialVersionUID = -2188826275737210151L;
	private int score;
	private String initials;

	public HighScore(int score, String initials)
	{
		this.score = score;
		this.initials = initials;
	}

	@Override
	public int compareTo(HighScore otherScore)
	{
		// returns negative if this score is higher, positive if this score is lower, and 0 if this score is equal
		// allows for sorting in descending order
		return otherScore.getScore() - score;
	}

	public int getScore()
	{
		return score;
	}
	public String getInitials()
	{
		return initials;
	}

}
