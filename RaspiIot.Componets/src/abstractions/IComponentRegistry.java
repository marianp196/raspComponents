/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractions;

import abstractions.domian.IComponent;

/**
 *
 * @author marian
 */
public interface IComponentRegistry {
    void Add(IComponent component) throws Exception;
    void Delete(String id);    
    void Update(IComponent component) throws Exception;
}
