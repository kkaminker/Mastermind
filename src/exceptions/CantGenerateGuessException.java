package exceptions;

public class CantGenerateGuessException extends RuntimeException
{
	public CantGenerateGuessException()
	{
		super("no guess to generate");
	}
	
	public CantGenerateGuessException(String message)
	{
		super(message);
	}
	
	
}
