/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import gpio.ControlerFactory;
import gpioDriver.GpioPin;
import javax.naming.ldap.ControlFactory;

/**
 *
 * @author marian
 */
public class CompGpioPin implements IComponent<PinState, PinState>{

    public CompGpioPin(String id, int pin){
        _id = id;
        _pin = pin;
        //_gpioPin = new GpioPin(ControlerFactory.getInstance(), _pin);
    }
    
    @Override
    public String GetID() {
        return _id;
    }

    @Override
    public String GetGroupID() {
        return "gpio";
    }

    @Override
    public PinState Excute(PinState state) throws Exception {
        return state;
        
        /*_gpioPin.SetMode(state.Out);
        
        PinState result = new PinState();
        if(state.Out){
            if(state.State == null)
                throw new Exception("state is null");
            _gpioPin.SetState(state.State);
            result.Out = true;
            result.State = state.State;            
        }else{
            result.State = _gpioPin.GetState();
            result.Out = false;
        }
        
        return result;*/
    }
    
    private String _id;
    private int _pin;
    private GpioPin _gpioPin;
}
