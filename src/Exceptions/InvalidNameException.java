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
public class InvalidNameException extends Exception{

    public InvalidNameException() {
    }
    
    public InvalidNameException(String msj){
        super(msj);
    }
    
    public String getMessage(){
        return super.getMessage();
    }
}
