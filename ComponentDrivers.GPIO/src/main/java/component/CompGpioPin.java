/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import gpio.ControlerFactory;
import gpio.Enums.EModus;
import gpio.Enums.EStatus;
import gpio.Interfaces.IControler;

/**
 *
 * @author marian
 */
public class CompGpioPin implements IWriteableComponent<PinState, PinState>{

    public CompGpioPin(int pin){
        _id = String.valueOf(pin);
        _pin = pin;
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
    public PinState Write(PinState state) throws Exception {

        //Hier muss neues Interface her
        IControler controler = ControlerFactory.getInstance();
        
        controler.register(_pin, EModus.Out);
        controler.setSate(_pin, state.State ? EStatus.High : EStatus.Low);
        
        state.Out = true;
        return state;
    }
    
     @Override
    public PinState Read() throws Exception {
        IControler controler = ControlerFactory.getInstance();
        
        controler.register(_pin, EModus.In);
        
        PinState result = new PinState();
        result.Out = false;
        result.State = controler.getState(_pin);
        
        return result;
    }
    
    private String _id;
    private int _pin;
}
