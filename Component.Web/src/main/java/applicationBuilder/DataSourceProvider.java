/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationBuilder;

import dataSource.GpioPinDataSource;
import dataSource.IDataSource;
import dataSource.IDataSourceProvider;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author marian
 */
public class DataSourceProvider implements IDataSourceProvider{

    @Override
    public Collection<IDataSource> Get() {
        ArrayList<IDataSource> dataSources = new ArrayList<>();
        dataSources.add(new GpioPinDataSource());
        return dataSources;
    }
    
}
