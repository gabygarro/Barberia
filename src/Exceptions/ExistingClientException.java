

package Exceptions;

public class ExistingClientException extends Exception{
    
    public ExistingClientException(String msj) {
        super(msj);
    }

    @Override
    public String getMessage() {
        return super.getMessage(); 
    }
      
}
