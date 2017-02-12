package mastermind;

import enums.Color;

public class ComputerGuess
{
	private Color[] sequence;
	private int numReds;
	private int numWhites;
	
	public ComputerGuess(Color[] sequence)
	{
		if(sequence == null)
		{
			throw new NullPointerException("sequence cannot be null");
		}
		
		this.sequence = new Color[sequence.length];
		
		for (int i = 0; i < sequence.length; i++)
		{
			this.sequence[i] = sequence[i];
			numReds = 0;
			numWhites = 0;
		}
	}

	public void setNumReds(int numReds)
	{
		if(numReds<0 || numReds+numWhites>Game.getKeySize())
		{
			throw new IllegalArgumentException("numReds must be greater than 0 and numReds + numwhites can't be more than " + Game.getKeySize());
		}
		
		this.numReds = numReds;
	}

	public void setNumWhites(int numWhites)
	{
		if(numWhites<0 || numWhites+numReds>Game.getKeySize())
		{
			throw new IllegalArgumentException("numWhites must be greater than 0 and numReds + numwhites can't be more than " + Game.getKeySize());
		}
		
		this.numWhites = numWhites;
	}

	public int getNumReds()
	{
		return numReds;
	}

	public int getNumWhites()
	{
		return numWhites;
	}

	public Color[] getSequence()
	{
		Color[] temp = new Color[sequence.length];
		
		for(int i=0; i<temp.length; i++)
		{
			temp[i] = sequence[i];
		}
		
		return temp;		
	}
	
	public boolean isAllOneColor()
	{
		Color color = sequence[0];
		
		for(int i=1;i<sequence.length; i++)
		{
			if(sequence[i] != color)
			{
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("sequence: ");
		
		for(Color color: sequence)
		{
			sb.append(color + " ");
		}
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
		{
			return true;
		}
		
		if(obj == null)
		{
			return false;
		}
		
		if(! (obj instanceof ComputerGuess))
		{
			return false;
		}
		
		ComputerGuess guess2 = (ComputerGuess)obj;
		
		for(int i=0; i<sequence.length; i++)
		{
			if(guess2.sequence[i] != sequence[i])
			{
				return false;
			}
		}
		
		return true;
	}
}
