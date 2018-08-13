/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import driver.IPVMBoardDriver;

/**
 *
 * @author marian
 */
public class Led {

    public Led(int ledIndex, IPVMBoardDriver driver) {
        this._ledIndex = ledIndex;
        this._driver = driver;
    }
            
    public int GetLedIndex(){
        return _ledIndex;
    }
    
    public int GetFrequence() throws Exception{
        return _driver.GetFrequence();
    }
    
    public void SetPeriod(double start, double end) throws Exception{        
        if(start < 0 || start > 1 || end < 0 || end > 1)
            throw new IllegalArgumentException("start end hast to be grater than 0 and lower than 1");
       
        if(start + end > 1)
            throw new IllegalArgumentException("start + end higher than 1 is forbidden");
        
        int beginSteps = (int)(start * _driver.GetStepsMax());
        int endSteps = (int)(end * _driver.GetStepsMax());
        
        _driver.SetStepsLed(_ledIndex, beginSteps, endSteps);
    }
    
    public double GetStartHigh() throws Exception{
        return _driver.GetSteps(_ledIndex).BeginSteps / _driver.GetStepsMax();
    }
    
    public double GetEndHigh() throws Exception{
         return _driver.GetSteps(_ledIndex).EndSteps / _driver.GetStepsMax();
    }
    
    private int _ledIndex;
    private IPVMBoardDriver _driver;
}
