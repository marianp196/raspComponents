package services;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import component.IComponent;

/**
 *
 * @author marian
 */
public interface IComponentProvider {
    <TState, TResult> IComponent<TState, TResult> Get(String id, String groupId) throws Exception;
    void ReloadAll();
    void Reload(String id, String groupId) throws Exception;
}
 