/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

/**
 *
 * @author marian
 */
public class CompGpioPin implements IComponent<PinState, PinState>{

    public CompGpioPin(String id, int pin){
        _id = id;
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
    public PinState Excute(PinState state) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String _id;
    private int _pin;    
}
