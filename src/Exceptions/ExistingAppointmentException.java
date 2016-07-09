/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

/**
 *
 * @author Daniel
 */
public class ExistingAppointmentException extends Exception {

    public ExistingAppointmentException(String msj) {
        super(msj);
    }
    
    public String getMessage(){
        return super.getMessage();
    }
    
    
}
