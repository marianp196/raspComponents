package services;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import component.IComponent;
import component.IReadableComponent;
import component.IWriteableComponent;

/**
 *
 * @author marian
 */
public interface IComponentProvider {
   /**  
    * Wirft eine KeyException wenn nicht gefunden
    * @param <TState>
    * @param <TResult>
    * @param id
    * @param groupId
    * @return
    * @throws Exception 
    */
    <TState, TResult> IWriteableComponent<TState, TResult> GetExecuteable(String id, String groupId) throws Exception;
    <TResult> IReadableComponent<TResult> GetReadable(String id, String groupId) throws Exception;
    
    /**
     * Lädt alle Components neu in den internen Cache
     */
    void ReloadAll();
    
    /**
     * Wirft eine KeyException wenn die Component nicht gefunden wurde.
     * Wenn Componnet nicht mehr in ReloadDatenmenge existiert, dann wird sie aus dem Cache gelöscht
     * Ansonsten erstezt.
     * @param id
     * @param groupId
     * @throws Exception 
     */
    void Reload(String id, String groupId) throws Exception;
}
 