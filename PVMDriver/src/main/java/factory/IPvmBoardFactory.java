/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import domain.PVMBoard;

/**
 *
 * @author marian
 */
public interface IPvmBoardFactory {

    //ToDo hier muss das noch anders. Was mit i2c adresse
    PVMBoard Build(EHardware hardwareType, int frequence) throws Exception;
    
}
