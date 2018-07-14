/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistency;

import domian.IComponent;
import java.util.Collection;

/**
 *
 * @author marian
 */
public interface IPersistency {
    void Persist(Collection<IComponent> components) throws Exception;
    Collection<IComponent> Get() throws Exception;
}
