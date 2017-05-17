package java_workshop04;

@SuppressWarnings("serial")
public class BookException extends RuntimeException{
	public BookException(){ }
	public BookException(String msg){ 
		super(msg);
	}
}
