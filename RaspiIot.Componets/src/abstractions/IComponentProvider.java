package abstractions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import abstractions.domian.IComponent;

/**
 *
 * @author marian
 */
public interface IComponentProvider {
    <TState, TResult> IComponent<TState, TResult> Get(String id) throws Exception ;
}
 