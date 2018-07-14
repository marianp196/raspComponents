/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.util;

import abstractions.domian.IComponent;

/**
 *
 * @author marian
 */
public class Component implements IComponent<State, Result>{

    public Component(String id){
        _id = id;
    }
    
    @Override
    public String GetID() {
        return _id;
    }

    @Override
    public Result Excute(State state) throws Exception {
        Result result = new Result();
        result.state = state;
        return result;
    }
    
    
    private String _id;
    
}
