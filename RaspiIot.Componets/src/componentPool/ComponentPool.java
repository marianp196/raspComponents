/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentPool;


import domian.IComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import services.IComponentProvider;
import services.IComponentRegistry;

/**
 *
 * @author marian
 */
public class ComponentPool implements IComponentRegistry, IComponentProvider {

    public ComponentPool(){
        _internStorage = new ArrayList<>();
    }
    
    @Override
    public void Add(IComponent component) throws Exception {
        if(component== null)
           throw new Exception("null value");
        if(exists(component.GetID()))
           throw new Exception("id exists allready");
        _internStorage.add(component);
      
    }

    @Override
    public void Delete(String id) {             
        if(id == null)
            throw new NullPointerException("null value");
        try{ 
            IComponent component = get(id);
            if(component == null)
                return;
            
            _internStorage.remove(component);
        } catch (Exception ex) {
            Logger.getLogger(ComponentPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Update(IComponent component) throws Exception {
        if(component == null)
            throw new Exception("null value");
        if(!exists(component.GetID()))
            throw new Exception("doesnt exists");
        
        Delete(component.GetID());
        Add(component);
    }

    @Override
    public <TState, TResult> IComponent<TState, TResult> Get(String id) throws Exception {
        return (IComponent<TState, TResult>) get(id);
    }
    
    private boolean  exists(String id) throws Exception{
        return get(id) != null;
    }
    
    private IComponent get(String id) throws Exception{
        List<IComponent> result = _internStorage.stream().
                filter(c -> c.GetID().equals(id)).collect(Collectors.toList());
        
        if(result.size() > 1){
            throw new Exception("invalid ids");
        }
       
        return result.isEmpty()? null : result.get(0);
    }
    
    private ArrayList<IComponent> _internStorage;
    
}
