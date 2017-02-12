package enums;

public enum GuessLevel
{
	EASY(15),
	MEDIUM(10),
	HARD(5),
	EXPERT(3);
	
	private int numGuesses;
	
	private GuessLevel(int numGuesses)
	{
		this.numGuesses = numGuesses;
	}
	
	public int getNumGuesses()
	{
		return numGuesses;
	}
}
