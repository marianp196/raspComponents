
import I2CBus.IBusI2C;
import I2CBusFactory.I2CBusFactory;
import domain.Led;
import domain.PVMBoard;
import factory.EHardware;
import factory.IBusI2CFactory;
import factory.PvmBoardFactory;
import java.nio.ByteBuffer;

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
        boolean schalter = false;
        
        if(schalter)
            oldTest();
        else
            pvmBoardTest();
    }
    
    private static void pvmBoardTest() throws Exception{
        IBusI2CFactory bus = new I2CBusFactory("http://192.168.192.44:8080/comp/webresources/");
        
        PVMBoard pvmBoard = new PvmBoardFactory(bus, 0x40).Build(50);
        
        Led led = pvmBoard.GetLed(1);
        
        led.SetPeriod(0, 0.08);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void oldTest() throws Exception{
        IBusI2C bus = new I2CBusFactory("http://192.168.192.44:8080/comp/webresources/").Create();
              
        setup(bus);
        writeLed0(bus, 1, 0, 400);
        
        while(true){
            
            writeLed0(bus, 1, 0, 800);
            Thread.sleep(500);
            writeLed0(bus, 1, 0, 500);
            
          
            
            for(int i= 0; i < 3; i++){
                 for(int j=150; j < 300; j+=3 ){
                     writeLed0(bus, 2, 0, j);
                     writeLed0(bus, 3, 0, j);
                    Thread.sleep(20);
                } 
                 
                 for(int j=300; j > 150; j-=4 ){
                     writeLed0(bus, 2, 0, j);
                     writeLed0(bus, 3, 0, j);
                    Thread.sleep(20);
                } 
                
                 for(int j = 0; j < 5; j++ )
                 {
                    writeLed0(bus, 4, 0, 200);
                    Thread.sleep(500);
                    writeLed0(bus, 4, 0, 400);
                    Thread.sleep(500);
                }
                 
                 
            }
              
            
            for(int j=150; j < 300; j+=31 ){
                writeLed0(bus, 2, 0, j);
                Thread.sleep(20);
            } 
          
            for(int i=300; i < 400; i+=3 ){
                writeLed0(bus, 0, 0, i);
                writeLed0(bus, 2, 0, i);
                writeLed0(bus, 3, 0, i);
                Thread.sleep(20);
            } 
                        
            writeLed0(bus, 1, 0, 800);
            Thread.sleep(500);
            writeLed0(bus, 1, 0, 500);
            
            for(int i = 0; i<5; i++){
                writeLed0(bus, 4, 0, 200);
                Thread.sleep(1000);
                writeLed0(bus, 4, 0, 400);
                Thread.sleep(1000);
            }
                       
         
            
            for(int i=399; i > 300; i-=3 ){
                writeLed0(bus, 0, 0, i);
                writeLed0(bus, 2, 0, i);
                writeLed0(bus, 3, 0, i);
                Thread.sleep(20);
            } 
            
        }          
    }

    private static void setup(IBusI2C i2c) throws Exception{
        i2c.Write(0x40, 0x00, (byte)0x10);
        i2c.Write(0x40, 0xfe, (byte)0x79);
        i2c.Write(0x40, 0x00, (byte)0xa1);
    }
    
    private static void writeLed0(IBusI2C bus,int led,int begin, int end) throws Exception{
        byte[] bytesBegin = ByteBuffer.allocate(4).putInt(begin).array();
        byte[] bytesEnd = ByteBuffer.allocate(4).putInt(end).array();
        
        int base = (4 * led);      
        
        bus.Write(0x40, base + 6, bytesBegin[3]);
        bus.Write(0x40, base + 7, bytesBegin[2]);
        bus.Write(0x40, base + 8, bytesEnd[3]);
        bus.Write(0x40, base + 9, bytesEnd[2]);        
    }
}
