/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import component.CompGpioPin;
import component.IComponent;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author marian
 */
public class GpioPinDataSource implements IDataSource{
    
    @Override
    public Collection<IComponent> Read() {
        int[] pins = { 3,5,7,8,10, 11, 13,14,15, 16,18, 19,21,22,23,24,
            26,27,28, 29,31, 32,33,35,36, 37, 38,40};
        
        ArrayList<IComponent> result = new ArrayList<>();
        
        for(int pin : pins)
            result.add(new CompGpioPin(pin));
            
        return result;
    }
   
}
