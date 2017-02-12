package exceptions;

public class InvalidDataException extends RuntimeException {
	
	//Default constructor
	public InvalidDataException()
	{
		super("Invalid Data");
	}
	
	//Constructor that accepts a message
	public InvalidDataException(String message)
	{
		super(message);
	}
}