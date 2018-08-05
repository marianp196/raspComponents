/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dataSource.IDataSource;
import dataSource.IDataSourceProvider;
import dataSourceReader.DatasourceReader;
import dataSourceReader.IDatasourceReader;
import java.util.ArrayList;
import services.ComponentPool;
import services.IComponentProvider;

/**
 *
 * @author marian
 */
public class ComponentProviderFactory implements IComponentProviderFactory {

    @Override
    public IComponentProvider Build(ArrayList<IDataSource> dataSources) throws Exception {
        return this.Build(() -> dataSources);
    }

    @Override
    public IComponentProvider Build(IDataSourceProvider provider) throws Exception {
        IDatasourceReader reader = new DatasourceReader(provider);
        return new ComponentPool(reader);
    }
    
}
