package customexceptions;

public class InvalidBrowserException extends RuntimeException{
    public InvalidBrowserException(String message){
        super(message);
    }

}
