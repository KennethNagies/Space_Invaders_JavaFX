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
