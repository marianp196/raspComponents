package services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import domian.IComponent;
import java.util.Collection;

/**
 *
 * @author marian
 */
public interface IComponentRegistry {
    void Add(IComponent component) throws Exception;
    void Delete(String id);    
    void Update(IComponent component) throws Exception;
    IComponent Get(String id) throws Exception;
    Collection<IComponent> GetAll();
}
