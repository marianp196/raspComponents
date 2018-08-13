/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import driver.IPVMBoardDriver;
import java.util.ArrayList;

/**
 *
 * @author marian
 */
public class PVMBoard {
    
    public PVMBoard(IPVMBoardDriver driver, int frequence) throws Exception{
        if(frequence < 0)
            throw new Exception("Frequence has to be greater than 0");
        _frequence = frequence;
        _pvmBoardDriver = driver;
        
        _pvmBoardDriver.SetFrequence(frequence);
    }
    
    public Led GetLed(int led){
        return new Led(led, _pvmBoardDriver); //ToDo Als Singleton-Instanzen einrichten
    }
   
    private int _frequence;
    private IPVMBoardDriver _pvmBoardDriver;
}
