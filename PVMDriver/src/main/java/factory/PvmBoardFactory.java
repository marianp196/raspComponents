/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import I2CBus.IBusI2C;
import domain.PVMBoard;
import driver.IPVMBoardDriver;
import driver.PCA9685.PCA9685;

/**
 *
 * @author marian
 */
public class PvmBoardFactory implements IPvmBoardFactory {
    
   public PvmBoardFactory(IBusI2CFactory factory){
       _factory = factory;
   }
   
   //ToDo hier muss das noch anders. Was mit i2c adresse  
    @Override
   public PVMBoard Build(EHardware hardwareType, int frequence) throws Exception{
       if(hardwareType == EHardware.PCA9685)
       {
           IBusI2C i2c = _factory.Create();
           IPVMBoardDriver driver = new PCA9685(i2c);
                                 
           return new PVMBoard(driver, frequence);
       }
       
       throw new UnsupportedOperationException("HardwareType not supported");
   }
   
   private IBusI2CFactory _factory;
   
}
