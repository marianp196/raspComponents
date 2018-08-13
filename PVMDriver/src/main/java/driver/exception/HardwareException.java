/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver.exception;

/**
 *
 * @author marian
 */
public class HardwareException extends Exception{
    public HardwareException(Exception e){
        super(e.getMessage());
    }
}
