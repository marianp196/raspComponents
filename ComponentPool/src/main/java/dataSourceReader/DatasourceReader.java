/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSourceReader;

import component.IComponent;
import dataSource.IDataSource;
import dataSource.IDataSourceProvider;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author marian
 */

public class DatasourceReader implements IDatasourceReader{
    
    public DatasourceReader(IDataSourceProvider dataSources){
        _dataSources = dataSources.Get();
    }
    
    @Override
    public Collection<IComponent> Get() {
        ArrayList<IComponent> result = new ArrayList<>();
        
        for(IDataSource dataSource : _dataSources)
            for(IComponent component : dataSource.Read())
            {
                if(!exists(result, component.GetID(), component.GetGroupID()))
                    result.add(component);
                else
                {    /*Throw Exception*/ }
            }
        
        return result;
    }
    
    private boolean exists(Collection<IComponent> data, String id, String groupId){
        return data.stream().filter(c -> c.GetID().equals(id) && c.GetGroupID().equals(groupId))
                .count() > 1;
    }
    
    private Collection<IDataSource> _dataSources;
}
