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
public class InvalidEmailException extends Exception {

    public InvalidEmailException() {
    }
    
    public InvalidEmailException(String msj){
        super(msj);
    }
    
    @Override
    public String getMessage(){
        return super.getMessage();
    }
}
