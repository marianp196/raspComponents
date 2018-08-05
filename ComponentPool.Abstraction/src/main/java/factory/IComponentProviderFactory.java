/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dataSource.IDataSource;
import dataSource.IDataSourceProvider;
import java.util.ArrayList;
import services.IComponentProvider;

/**
 *
 * @author marian
 */
public interface IComponentProviderFactory {
    IComponentProvider Build(ArrayList<IDataSource> dataSources) throws Exception;
    IComponentProvider Build(IDataSourceProvider provider) throws Exception;
}
