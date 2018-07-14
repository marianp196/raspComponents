package factory;


import componentPool.ComponentPool;
import services.IComponentProvider;
import services.IComponentRegistry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marian
 */
public class ComponentsFactory {
    
    public static IComponentProvider GetProvider(){
        return get();
    }
    
    public static IComponentRegistry GetRegistry(){
        return get();
    }
    
    private static ComponentPool get(){
        if(_instance == null)
            _instance = new ComponentPool();
        return _instance;
    }
    
    private static ComponentPool _instance;
}
