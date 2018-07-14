/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domian.IComponent;

/**
 *
 * @author marian
 */
public class ComponetntProvider implements IComponentProvider{
    
    public ComponetntProvider(IComponentRegistry registry){
        _registry = registry;
    }
    
    @Override
    public <TState, TResult> IComponent<TState, TResult> Get(String id) throws Exception {
        return (IComponent<TState, TResult>) _registry.Get(id);
    }
    
    private IComponentRegistry _registry;
}
