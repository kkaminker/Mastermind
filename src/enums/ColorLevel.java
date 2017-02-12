package enums;

public enum ColorLevel
{
	EASY(4),
	MEDIUM(6),
	HARD(8),
	EXPERT(10);
	
	private int numColors;
	
	private ColorLevel(int numColors)
	{
		this.numColors = numColors;
	}
	
	public int getNumColors()
	{
		return numColors;
	}
}

