/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSourceReader;

import component.IComponent;
import dataSource.IDataSource;
import dataSource.IDataSourceProvider;
import java.util.Collection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        throw new NotImplementedException();
    }
    
    private Collection<IDataSource> _dataSources;
}
