/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver.PCA9685;

import I2CBus.DeviceNotFoundException;
import I2CBus.IBusI2C;
import driver.exception.HardwareException;
import driver.util.LedConfig;
import java.nio.ByteBuffer;
import driver.IPVMBoardDriver;

/**
 *
 * @author marian
 */
public class PCA9685 implements IPVMBoardDriver{

    public PCA9685(IBusI2C i2c) {
        _i2c = i2c;
    }

        
    @Override
    public synchronized void SetI2CAdress(int adress) {
        _i2cAdress = adress;
    }

    @Override
    public synchronized int GetI2CAdress() {
        return _i2cAdress;
    }

    @Override
    public synchronized void SetFrequence(int f) throws Exception {
        if(f != 50)
            throw new UnsupportedOperationException("only 50Hz is allowed yet");
        
        byte frequence = (byte)0x79; //ToDO
        
        try {
            _i2c.Write(_i2cAdress, _mode0, (byte) 0x10);
            _i2c.Write(_i2cAdress, _frequenceAdress, frequence);
            _i2c.Write(_i2cAdress, _mode0, (byte) 0xa1);
        } catch (DeviceNotFoundException deviceNotFoundException) {            
            throw new HardwareException(deviceNotFoundException);
        }
    }
    
    
    @Override
    public synchronized int GetFrequence() throws Exception {
        if(_i2c.Read(_i2cAdress, _frequenceAdress) != 0x79)
            throw new UnsupportedOperationException("Only 50Hz supported yet");
        return 50;
    }
    
    @Override
    public int GetStepsMax() {
        return 4096;
    }

    @Override
    public synchronized void SetStepsLed(int led, int beginSteps, int endsteps) throws Exception {
        if(led < 0 || led > 15)
            throw new Exception("led doesnt exist");  //überdenken
        
        byte[] bytesBegin = ByteBuffer.allocate(4).putInt(beginSteps).array();
        byte[] bytesEnd = ByteBuffer.allocate(4).putInt(endsteps).array();
                      
        try { 
            LedAdresses adresses = getAdressesForLed(led);
            _i2c.Write(_i2cAdress, adresses.BeginLow, bytesBegin[3]);
            _i2c.Write(_i2cAdress, adresses.BeginHigh, bytesBegin[2]);
            _i2c.Write(_i2cAdress, adresses.EndLow, bytesEnd[3]);
            _i2c.Write(_i2cAdress, adresses.EndHigh, bytesEnd[2]);            
         } catch (DeviceNotFoundException deviceNotFoundException) {
            
            throw new HardwareException(deviceNotFoundException);
        }
    }

    @Override
    public synchronized void SetStepsLed(int led, LedConfig config) throws Exception {
        this.SetStepsLed(led, config.BeginSteps, config.EndSteps);
    }
    
    
    @Override
    public synchronized LedConfig GetSteps(int led) throws Exception {
        if(led < 0 || led > 15)
            throw new Exception("led doesnt exist");  //überdenken
        
        LedConfig result = new LedConfig();     
        
        LedAdresses adresses = getAdressesForLed(led);
        
        try {
            
            byte[] begin = {_i2c.Read(_i2cAdress, adresses.BeginHigh),
                _i2c.Read(_i2cAdress, adresses.BeginLow)};
            
            byte[] end = {_i2c.Read(_i2cAdress, adresses.EndHigh),
                _i2c.Read(_i2cAdress, adresses.EndLow)};
            
            result.BeginSteps = ByteBuffer.wrap(begin).getInt();
            result.EndSteps = ByteBuffer.wrap(end).getInt();
        } catch (DeviceNotFoundException deviceNotFoundException) {
            
            throw new HardwareException(deviceNotFoundException);
        }
        
        
        return result;
    }

    @Override
    public synchronized void SetStepsAll(int beginSteps, int endsteps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void SetStepsAll(LedConfig config) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private LedAdresses getAdressesForLed(int led){
        LedAdresses adress = new LedAdresses();
        int base = (4 * led);
        
        adress.BeginLow = base + 6;
        adress.BeginHigh = base + 7;
        adress.EndLow = base + 8;
        adress.EndHigh = base + 9;
        
        return adress;
    }

    
    private IBusI2C _i2c;
    private int _i2cAdress = 0x40;


   private static final int _frequenceAdress = 0xfe;
   private static final int _mode0 = 0x00;
}
