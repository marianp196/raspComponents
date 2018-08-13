/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import driver.util.LedConfig;

/**
 *
 * @author marian
 */
public interface IPVMBoardDriver {
    
     /*
    Andere Einstellungen müssten noch hinzuegefügt werden
    */
    void SetI2CAdress(int adress);
    int GetI2CAdress();
    
    void SetFrequence(int f) throws Exception;
    int GetFrequence() throws Exception;
    
    int GetStepsMax();    
    void SetStepsLed(int led, int beginSteps, int endsteps) throws Exception;
    void SetStepsLed(int led, LedConfig config) throws Exception;
    
    void SetStepsAll(int beginSteps, int endsteps) throws Exception;
    void SetStepsAll(LedConfig config) throws Exception;
    
    LedConfig GetSteps(int Led) throws Exception;
    
}
