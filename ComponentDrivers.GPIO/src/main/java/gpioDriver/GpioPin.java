/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpioDriver;

import gpio.Enums.EModus;
import gpio.Enums.EStatus;
import gpio.Interfaces.IControler;

/**
 *
 * @author marian
 */
public class GpioPin {
    
    public GpioPin(IControler controler, int pin){
        _pin = pin;
        _controler = controler;
    }
    
    /**
     * True is out
     * @param mode
     * @throws Exception 
     */
    public void SetMode(boolean mode) throws Exception{
        _controler.register(_pin, mode ? EModus.Out : EModus.In);
    }
    
    public void SetState(boolean state) throws Exception{
        _controler.setSate(_pin, state? EStatus.High : EStatus.Low);
    }
    
    public boolean GetState() throws Exception{
        return _controler.getState(_pin);
    }
            
    //irgendwie kein gloreiches interface
    private IControler _controler;
    private int _pin;
}
