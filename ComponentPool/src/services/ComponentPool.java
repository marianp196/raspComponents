/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import component.IComponent;
import dataSourceReader.IDatasourceReader;
import java.security.KeyException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author marian
 */
public class ComponentPool implements IComponentProvider{

    public ComponentPool(IDatasourceReader datasourceReader){
        _dataDatasourceReader = datasourceReader;
        _cachedComponents = null;
    }
   
    @Override
    public synchronized void ReloadAll() {
        _cachedComponents = _dataDatasourceReader.Get();
    }

    @Override
    public synchronized <TState, TResult> IComponent<TState, TResult> Get(String id, String groupId) throws Exception {
        if(id == null)
            throw new NullPointerException("id");
        if(groupId == null)
            throw new NullPointerException("groupId");
        
        checkForReload();
        
        IComponent result = getComponent(_cachedComponents,groupId, id);
        
        if(result == null)
            throw new KeyException("compnenet doesn't exists");
        
        return (IComponent<TState, TResult>) result;
    }

    @Override
    public synchronized void Reload(String id, String groupId) throws Exception {
         if(id == null)
            throw new NullPointerException("id");
        if(groupId == null)
            throw new NullPointerException("groupId");
        
        
        checkForReload(); //bisschen blöd das ebene hierdrunter keine gezielte Selektion zulässt...verienfact aber.. so oft wird ja nicht reloaded
        
        IComponent actualComponent = getComponent(_cachedComponents,id, groupId);
        if(actualComponent == null)
            throw new KeyException("Component doesn't exist");

        
        Collection<IComponent> reloadedComponents = _dataDatasourceReader.Get();
        IComponent newComponent = getComponent(reloadedComponents, groupId, id);
        
        _cachedComponents.remove(actualComponent);
        if(newComponent != null)
            _cachedComponents.add(newComponent);
        
    } 
        
    private IComponent getComponent(Collection<IComponent> list, String groupId, String id){
        //ToDO hier methode mit Datasourcereader sharen
        if(list == null)
            throw new NullPointerException("Componenet-Cache not loaded");
        List result = list.stream().filter(c -> c.GetGroupID().equals(groupId) && c.GetID().equals(id))
                .collect(Collectors.toList());
        return (IComponent)(result.size() == 0 ? null : result.get(0));
    }
    
    private void checkForReload(){
        if(_cachedComponents== null)
            ReloadAll();
    }
    
    private IDatasourceReader _dataDatasourceReader;
    private Collection<IComponent> _cachedComponents;    
}
