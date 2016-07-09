

package Exceptions;

public class DateOutOfScheduleException extends Exception{
    
    public DateOutOfScheduleException(String msj){
        super(msj);
    }
    
    public String getMessage(){
        return super.getMessage();
    }
}
