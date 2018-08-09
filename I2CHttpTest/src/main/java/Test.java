
import I2CBus.IBusI2C;
import I2CBusFactory.I2CBusFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marian
 */
public class Test {
    public static void main(String[] args) throws Exception{
        IBusI2C bus = new I2CBusFactory("http://192.168.192.44:8080/comp/webresources/").Create();
        
        System.out.println(bus.Read(0x40, 0x00));
                
    }
}
