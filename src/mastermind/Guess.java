package mastermind;

import java.util.Arrays;

import enums.*;
import exceptions.*;

public class Guess 
{
	private Color[] sequence;
	private int numReds;
	private int numWhites;
	
	private Color[] key;
	private boolean[] foundInKey;
	private boolean[] foundInSequence;
	
	public Guess(Color[] key, Color[] attempt)
	{
		if (key == null)
		{
			throw new InvalidDataException("The key cannot be null.");
		}
		this.key = key;
		
		if (attempt == null)
		{
			throw new InvalidDataException("The sequence cannot be null.");
		}
		
		if (key.length != attempt.length)
		{
			throw new InvalidDataException("Key and sequence must be the same length");
		}
		
		foundInKey = new boolean[key.length];
		foundInSequence = new boolean[key.length];
		numReds = 0;
		numWhites = 0;
		
		// deep copy
		sequence = new Color[attempt.length];
		for (int i = 0; i < attempt.length; i++)
		{
			sequence[i] = attempt[i];
		}
	}
	
	public void checkForReds()
	{
		for (int index = 0; index < key.length; index++)
		{
			if (sequence[index].equals(key[index]))
			{
				numReds++;// total red pegs updated
				foundInKey[index] = true;
				foundInSequence[index] = true;
			}
		}
	}
	
	public void checkForWhites()
	{
		if (!isAllRed())
		{
			//loops once per each position in the key
			for (int keyIndex = 0; keyIndex < key.length; keyIndex++)
			{
				//loops once per each possible position in the attempt
				for (int sequenceIndex = 0; sequenceIndex < sequence.length; sequenceIndex++)
				{
					//as long as not same place (the current peg we're looking at and the position we're comparing it to- because then would be red), 
					//and this peg in the attempt hasn't been found yet
					if (sequenceIndex != keyIndex && sequence[sequenceIndex].equals(key[keyIndex]) && !foundInKey[keyIndex] && !foundInSequence[sequenceIndex])
					{
						numWhites++;
						foundInKey[keyIndex] = true;
						foundInSequence[sequenceIndex] = true;
					}
				}
			}
			
		}
		
	} 
	
	
	public boolean  isAllRed()
	{
		return (numReds == key.length);
	}

	// getters

	public Color[] getSequence() 
	{
		// deep copy
		Color[] array = new Color[sequence.length];
		for (int i = 0; i < sequence.length; i++)
		{
			array[i] = sequence[i];
		}

		return array;
	}

	public int getNumReds() 
	{
		return numReds;
	}

	public int getNumWhites() 
	{
		return numWhites;
	}

	@Override
	public String toString() 
	{
		StringBuilder str = new StringBuilder();
		str.append("Sequence: ");
		for (Color c : sequence)
		{
			str.append(c + " ");
		}
		str.append("\nReds: " + numReds);
		str.append("\nWhites: " + numWhites);
		return str.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guess other = (Guess) obj;
		if (!Arrays.equals(sequence, other.sequence))
			return false;
		return true;
	}
}

